package com.example.campusrun1_0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RunActivity extends BaseFragment {

    private ImageButton run_btn, statistic_btn;
    private Button pause_btn, stop_btn;
    private RelativeLayout runlayout;
    private View layoutView;
	private TextView runtime, rundistance;
    private Handler handler = new Handler();
    private int hour = 0,minute = 0,second = 0;
    private double dis = 0.0;
    private boolean isPause = true;

    public static TextView last_distance, his_distance;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    	
    	layoutView = inflater.inflate(R.layout.run_main, null);
        run_btn = (ImageButton) layoutView.findViewById(R.id.run_btn);
        pause_btn = (Button) layoutView.findViewById(R.id.pause_btn);
        stop_btn = (Button) layoutView.findViewById(R.id.stop_btn);
        runlayout = (RelativeLayout) layoutView.findViewById(R.id.run_layout);
        statistic_btn = (ImageButton) layoutView.findViewById(R.id.statistic_btn);

        last_distance = (TextView) layoutView.findViewById(R.id.lastdistance);
        his_distance = (TextView) layoutView.findViewById(R.id.hisdistance);
        
        runtime = (TextView) layoutView.findViewById(R.id.runtime);
 	
        MainActivity.m_radioGroup =(RadioGroup)layoutView.findViewById(R.id.main_radiogroup);
        
        try {
			new LoginActivity();
			setMessage(LoginActivity.user_id);
			//Log.e("setMessage", "called");
		} catch (Exception e) { }
        
        run_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
            	AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
    			builder1.setMessage("确定开始跑步吗?")
    		       .setCancelable(false)
    		       .setPositiveButton("确定", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		        	   Intent intent = new Intent();
    		        	   intent.setClass(getActivity().getApplicationContext(), Pedometer.class);
    		        	   startActivity(intent);
    		           }
    		       }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	   dialog.cancel();
			           }
			       });
    			builder1.setTitle("提示");
    			builder1.create().show();
            }
        });
        
        statistic_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
            	 Intent intent = new Intent();
                 intent.setClass(getActivity().getApplicationContext(), StatisticActivity.class);
            	 //intent.setClass(getActivity().getApplicationContext(), Pedometer.class);
                 startActivity(intent);  
            }

        });
        
        return layoutView;
    }
    
    
	@Override
	public void onResume() {
        super.onResume();

	}
	
	public static void setMessage(int user_id) throws Exception{
		String url = "http://"+AppointActivity.curIp+"/android/index.php/run_record/";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		PostingMessage postingMessage = new PostingMessage();
		ArrayList<HashMap<String, Object>> run_record_message = postingMessage.sendingMessage(map, url); // 返回run_record获取的数据
		
		Map<String, Object> temp = run_record_message.get(0);
		if( temp.containsKey("user_id") ){
			String id = temp.get("user_id").toString();
			String last = temp.get("last_distance").toString();
			String his = temp.get("total_distance").toString();
			last_distance.setText(last);
			his_distance.setText(his);
			run_record_message.clear();
		}
		else{
			Log.e("nothing", "....");
		}
	}

}





