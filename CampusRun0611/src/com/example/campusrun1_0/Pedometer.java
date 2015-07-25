/*
 *  Pedometer - Android App
 *  Copyright (C) 2009 Levente Bagi
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.example.campusrun1_0;


import java.util.ArrayList;
import java.util.HashMap;

import runningImplement.PedometerSettings;
import runningImplement.Utils;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;



public class Pedometer extends Activity {
	private static final String TAG = "Pedometer";
    private SharedPreferences mSettings;
    private PedometerSettings mPedometerSettings;
    public static boolean ret;
    private Utils mUtils;
    
    private TextView mStepValueView;
    private TextView mPaceValueView;
    private TextView mDistanceValueView;
    private TextView mSpeedValueView;
    private TextView mCaloriesValueView;
    TextView mDesiredPaceView;
    private int mStepValue;//mStepValueView的值
    private int mPaceValue;//mPaceValueView的值
    private float mDistanceValue;//mDistanceValueView的值
    private float mSpeedValue;//mSpeedValueView的值
    private int mCaloriesValue;//mCaloriesValueView的值
    private float mDesiredPaceOrSpeed;//
    private int mMaintain;//是否是爬山
    private boolean mIsMetric;//公制和米制切换标志
    private float mMaintainInc;//
    private boolean mQuitting = false; 
    // Set when user selected Quit from menu, can be used by onPause, onStop, onDestroy
    
    private Button pause_btn, stop_btn;
    private Context mContext = this;
    /**
     * True, when service is running.
     */
    private boolean mIsRunning;//程序是否运行的标志位
    private boolean isUnbindService = false;
    private StepService mService;
    
    private boolean isPause = false;
    private TextView runtime;
    
    private Handler handler = new Handler();
    private int hour = 0,minute = 0,second = 0;
    
  private Runnable runnable = new Runnable() {
      public void run() {
          this.update();
          if (!isPause)
          	handler.postDelayed(this, 1000);
      }
      void update() {
          String t = "";
          String d = "";
          if(second < 59) {
          	second++;
          } else {
          	second = 0;
          	minute++;
          }
          if(minute >= 59) {
          	minute = 0;
          	hour++;
          }
          if(hour < 10 && minute < 10 && second < 10) {
          	t = "0" + hour + ":0" + minute + ":0" + second;
          } else if (hour < 10 && minute < 10 && second >= 10) {
          	t = "0" + hour + ":0" + minute + ":" + second;
          } else if (hour < 10 && minute >= 10 && second < 10) {
          	t = "0" + hour + ":" + minute + ":0" + second;
          } else if (hour >= 10 && minute < 10 && second < 10) {
          	t = "" + hour + ":0" + minute + ":0" + second;
          }else if (hour < 10 && minute >= 10 && second >= 10) {
          	t = "0" + hour + ":" + minute + ":" + second;
          }else{
          	t = "" + hour + ":" + minute + ":" + second;
          }
          runtime.setText(t);
      }
  }; 
    
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "[ACTIVITY] onCreate");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.run);
        
        mStepValue = 0;
        mPaceValue = 0;
             
        mUtils = Utils.getInstance();       
        handler.postDelayed(runnable, 1000);
        
    }
    
    //开始函数，重写该函数，加入日志。
    @Override
    protected void onStart() {
        Log.i(TAG, "[ACTIVITY] onStart");
        super.onStart();
    }

    //重写回复函数
    @Override
    protected void onResume() {
        Log.i(TAG, "[ACTIVITY] onResume");
        super.onResume();
        
        mSettings = PreferenceManager.getDefaultSharedPreferences(this);
        mPedometerSettings = new PedometerSettings(mSettings);
        
        mUtils.setSpeak(mSettings.getBoolean("speak", false));
        
        // Read from preferences if the service was running on the last onPause
        mIsRunning = mPedometerSettings.isServiceRunning();
        
        // Start the service if this is considered to be an application start (last onPause was long ago)
        if (!mIsRunning && mPedometerSettings.isNewStart()) {
            startStepService();
            bindStepService();
        }
        else if (mIsRunning) {
            bindStepService();
        }
        
        mPedometerSettings.clearServiceRunning();

        mStepValueView     = (TextView) findViewById(R.id.step_value);
        mPaceValueView     = (TextView) findViewById(R.id.pace_value);
        mDistanceValueView = (TextView) findViewById(R.id.distance_value);
        mSpeedValueView    = (TextView) findViewById(R.id.speed_value);
        mCaloriesValueView = (TextView) findViewById(R.id.calories_value);
             
        resetValues(true);
        
        pause_btn = (Button) findViewById(R.id.pause_btn);
        stop_btn = (Button) findViewById(R.id.stop_btn);
        
        runtime = (TextView) findViewById(R.id.runtime);

        pause_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View arg0) {
          	if(!isPause) {
          		isPause= true;
          		handler.postDelayed(runnable, 1000);
          		if(!isUnbindService){
          			unbindStepService();
          			isUnbindService = true;
          		}
          		pause_btn.setText("继续");
          		stopStepService();
          	} else {
          		isPause= false;
          		handler.postDelayed(runnable, 1000);
          		pause_btn.setText("暂停");
          		startStepService();
                bindStepService();
                isUnbindService = false;
          	}
          }
      });
      
      stop_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View arg0) {
        	  //resetValues(false);
        	  AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
        	  builder1.setMessage("确定结束吗?")
  		       .setCancelable(false)
  		       .setPositiveButton("确定", new DialogInterface.OnClickListener() {
  		           public void onClick(DialogInterface dialog, int id) {
  		        	   if(!isUnbindService){
  		        		   isUnbindService = true;
  		        		   unbindStepService();
  		   		   		}
  		   		        stopStepService();
  		   		        mQuitting = true;
  		   		        handler.removeCallbacks(runnable);
  		   		        send_run_record();	// 将本次运动记录发送至后台
  		   		        try {
  		   		        	RunActivity.setMessage(LoginActivity.user_id);
  		   		        } catch (Exception e) { }
  		           }
  		       }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
  		           public void onClick(DialogInterface dialog, int id) {
  		        	   // 确定结束跑步取消的话，让其相当于点了一次暂停
  		        	   if(!isPause) {
  		             		isPause= true;
  		             		handler.postDelayed(runnable, 1000);
  		             		if(!isUnbindService){
  		             			unbindStepService();
  		             			isUnbindService = true;
  		             		}
  		             		pause_btn.setText("继续");
  		             		stopStepService();
  		             	}
  		        	   dialog.cancel();
  		           }
  		       });
  			builder1.setTitle("提示");
  			builder1.create().show();
          }
      });
    }
    
    @Override
    protected void onPause() {
        Log.i(TAG, "[ACTIVITY] onPause");
        if (mIsRunning) {
            unbindStepService();
        }
        if (mQuitting) {
            mPedometerSettings.saveServiceRunningWithNullTimestamp(mIsRunning);
        }
        else {
            mPedometerSettings.saveServiceRunningWithTimestamp(mIsRunning);
        }

        super.onPause();
        savePaceSetting();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "[ACTIVITY] onStop");
        super.onStop();
    }

    protected void onDestroy() {
        Log.i(TAG, "[ACTIVITY] onDestroy");
        handler.removeCallbacks(runnable);
        super.onDestroy();
    }
    
    protected void onRestart() {
        Log.i(TAG, "[ACTIVITY] onRestart");
        super.onDestroy();
    }
    
    private void savePaceSetting() {
        mPedometerSettings.savePaceOrSpeedSetting(mMaintain, mDesiredPaceOrSpeed);
    }

    
    
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            mService = ((StepService.StepBinder)service).getService();

            mService.registerCallback(mCallback);
            mService.reloadSettings();
            
        }

        public void onServiceDisconnected(ComponentName className) {
            mService = null;
        }
    };
    

    private void startStepService() {
        if (! mIsRunning) {
            Log.i(TAG, "[SERVICE] Start");
            mIsRunning = true;
            startService(new Intent(Pedometer.this,
                    StepService.class));
        }
    }
    
    private void bindStepService() {
        Log.i(TAG, "[SERVICE] Bind");
        bindService(new Intent(Pedometer.this, 
                StepService.class), mConnection, Context.BIND_AUTO_CREATE + Context.BIND_DEBUG_UNBIND);
    }

    private void unbindStepService() {
        Log.i(TAG, "[SERVICE] Unbind");
        unbindService(mConnection);
    }
    
    private void stopStepService() {
        Log.i(TAG, "[SERVICE] Stop");
        if (mService != null) {
            Log.i(TAG, "[SERVICE] stopService");
            stopService(new Intent(Pedometer.this,
                  StepService.class));
        }
        mIsRunning = false;
    }
    
  
    private void resetValues(boolean updateDisplay) {
        if (mService != null && mIsRunning) {
            mService.resetValues();                    
        }
        else {
            mStepValueView.setText("0");
            mPaceValueView.setText("0");
            mDistanceValueView.setText("0");
            mSpeedValueView.setText("0");
            mCaloriesValueView.setText("0");
            SharedPreferences state = getSharedPreferences("state", 0);
            SharedPreferences.Editor stateEditor = state.edit();
            if (updateDisplay) {
                stateEditor.putInt("steps", 0);
                stateEditor.putInt("pace", 0);
                stateEditor.putFloat("distance", 0);
                stateEditor.putFloat("speed", 0);
                stateEditor.putFloat("calories", 0);
                stateEditor.commit();
            }
        }
    }
 
    // TODO: unite all into 1 type of message
    private StepService.ICallback mCallback = new StepService.ICallback() {
        public void stepsChanged(int value) {
            mHandler.sendMessage(mHandler.obtainMessage(STEPS_MSG, value, 0));
        }
        public void paceChanged(int value) {
            mHandler.sendMessage(mHandler.obtainMessage(PACE_MSG, value, 0));
        }
        public void distanceChanged(float value) {
            mHandler.sendMessage(mHandler.obtainMessage(DISTANCE_MSG, (int)(value*1000), 0));
        }
        public void speedChanged(float value) {
            mHandler.sendMessage(mHandler.obtainMessage(SPEED_MSG, (int)(value*1000), 0));
        }
        public void caloriesChanged(float value) {
            mHandler.sendMessage(mHandler.obtainMessage(CALORIES_MSG, (int)(value), 0));
        }
    };
    
    private static final int STEPS_MSG = 1;
    private static final int PACE_MSG = 2;
    private static final int DISTANCE_MSG = 3;
    private static final int SPEED_MSG = 4;
    private static final int CALORIES_MSG = 5;
    
    private Handler mHandler = new Handler() {
        @Override public void handleMessage(Message msg) {
            switch (msg.what) {
                case STEPS_MSG:
                    mStepValue = (int)msg.arg1;
                    mStepValueView.setText("" + mStepValue);
                    break;
                case PACE_MSG:
                    mPaceValue = msg.arg1;
                    if (mPaceValue <= 0) { 
                        mPaceValueView.setText("0");
                    }
                    else {
                        mPaceValueView.setText("" + (int)mPaceValue);
                    }
                    break;
                case DISTANCE_MSG:
                    mDistanceValue = ((int)msg.arg1)/1000f;
                    if (mDistanceValue <= 0) { 
                        mDistanceValueView.setText("0");
                    }
                    else {
                        mDistanceValueView.setText(
                                ("" + (mDistanceValue + 0.000001f)).substring(0, 5)
                        );
                    }
                    break;
                case SPEED_MSG:
                    mSpeedValue = ((int)msg.arg1)/1000f;
                    if (mSpeedValue <= 0) { 
                        mSpeedValueView.setText("0");
                    }
                    else {
                        mSpeedValueView.setText(
                                ("" + (mSpeedValue + 0.000001f)).substring(0, 4)
                        );
                    }
                    break;
                case CALORIES_MSG:
                    mCaloriesValue = msg.arg1;
                    if (mCaloriesValue <= 0) { 
                        mCaloriesValueView.setText("0");
                    }
                    else {
                        mCaloriesValueView.setText("" + (int)mCaloriesValue);
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
        
    };
    
    private void send_run_record(){

    	String url = "http://"+AppointActivity.curIp+"/android/index.php/run_record/update/";
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	map.put("user_id", LoginActivity.user_id);
    	map.put("current_distance", mDistanceValueView.getText().toString());
    	map.put("current_time", runtime.getText().toString());	
    	map.put("current_kaluli", mCaloriesValueView.getText().toString());
    	
    	PostingMessage postingMessage = new PostingMessage();
    	ArrayList<HashMap<String, Object>> run_record_update = new ArrayList<HashMap<String, Object>>();
    	try {
			run_record_update = postingMessage.sendingMessage(map, url);
		} catch (Exception e) { }
    	
    	if(run_record_update.get(0).get("mess").toString().equals("更新成功")){
    		AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
			builder1.setMessage("本次跑步结束")
		       .setCancelable(false)
		       .setPositiveButton("确定", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		        	   dialog.cancel();
		        	   try {
		        		   RunActivity.setMessage(LoginActivity.user_id);
		        	   } catch (Exception e) { }
		               finish();
		           }
		       });
			builder1.setTitle("提示");
			builder1.create().show();
    	}
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	if (keyCode == KeyEvent.KEYCODE_BACK) {
    		AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
      	  	builder1.setMessage("确定结束吗?")
    	       .setCancelable(false)
    	       .setPositiveButton("确定", new DialogInterface.OnClickListener() {
    	           public void onClick(DialogInterface dialog, int id) {
    	        	   Pedometer.ret = true;
    	        	   if(!isUnbindService){
    	        		   isUnbindService = true;
    	        		   unbindStepService();
    	   		   		}
    	   		        stopStepService();
    	   		        mQuitting = true;
    	   		        handler.removeCallbacks(runnable);
    	   		        send_run_record();	// 将本次运动记录发送至后台
    	   		        try {
    	   		        	RunActivity.setMessage(LoginActivity.user_id);
    	   		        } catch (Exception e) { }
    	           }
    	       }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
    	           public void onClick(DialogInterface dialog, int id) {
    	        	   // 确定结束跑步取消的话，让其相当于点了一次暂停
    	        	   Pedometer.ret = false;
    	        	   dialog.cancel();
    	           }
    	       });
    		builder1.setTitle("提示");
    		builder1.create().show();
    		return Pedometer.ret;
    	}
        return super.onKeyDown(keyCode, event);
    }
}