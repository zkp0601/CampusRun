package com.example.campusrun1_0;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends BaseFragment {
    private View layoutView;
    private Button Left_btn, Right_btn;
    private ImageView Runner_iv;
    private TextView Step_num_tv, time_left_tv;
    private static int step_num = 0;
    private Handler handler = new Handler();
    private int hour = 0,minute = 0,second = 10;
    private boolean isPlay = false;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        layoutView = inflater.inflate(R.layout.game_layout, null);
        Left_btn = (Button) layoutView.findViewById(R.id.left_btn);
        Right_btn = (Button) layoutView.findViewById(R.id.right_btn);
        Runner_iv = (ImageView) layoutView.findViewById(R.id.runner_blue);
        Step_num_tv = (TextView) layoutView.findViewById(R.id.stepnum);
        time_left_tv = (TextView) layoutView.findViewById(R.id.time_left);
        
        Left_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
            	 if (!isPlay) {
            		 handler.postDelayed(runnable, 1000);
            		 isPlay = true;
            	 }
            	 Left_btn.setEnabled(false);
            	 Right_btn.setEnabled(true);
            	 step_num++;
            	 Step_num_tv.setText("Step: " + step_num);
            	 Runner_iv.setImageResource(R.drawable.blue_front2);
            }

        });
        
        Right_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
            	if (!isPlay) {
		       		handler.postDelayed(runnable, 1000);
		       	    isPlay = true;
		       	}
            	Left_btn.setEnabled(true);
           	 	Right_btn.setEnabled(false);
           	 	step_num++;
           	 	Step_num_tv.setText("Step: " + step_num);
           	 	Runner_iv.setImageResource(R.drawable.blue_front3);
            }

        });
        
        return layoutView;
    }
     
    
    
    private Runnable runnable = new Runnable() {
      public void run() {
//          this.update();
//    	  second--;
//    	  String t = "0" + hour + ":0" + minute + ":0" + second;
//    	  time_left_tv.setText(t);
    	  if (isPlay) {
	          if (second > 0) {
	        	  handler.postDelayed(this, 1000);
	        	  second--;
	        	  String t = "0" + hour + ":0" + minute + ":0" + second;
	        	  time_left_tv.setText(t);
	          } else {
	        	  Left_btn.setEnabled(false);
	              Right_btn.setEnabled(false);
	        	  isPlay = false;
	              handler.removeCallbacks(runnable);
	        	  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
					builder.setMessage("时间到！总共走了"+ step_num +"步")
				       .setCancelable(false)
				       .setPositiveButton("确定", new DialogInterface.OnClickListener() {
				           public void onClick(DialogInterface dialog, int id) {
	//			        	   AddAppointActivity.this.finish();
				        	   step_num = 0;
				        	   Step_num_tv.setText("Step: " + step_num);
				        	   Left_btn.setEnabled(true);
				               Right_btn.setEnabled(true);
				               Runner_iv.setImageResource(R.drawable.blue_front1);
				               second = 10;
				               time_left_tv.setText("00:00:" + second);
				           }
				       });
					builder.setTitle("提示");
					builder.create().show();
	          }
    	  }
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
          time_left_tv.setText(t);
      }
    };
}