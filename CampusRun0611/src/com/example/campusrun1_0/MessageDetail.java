package com.example.campusrun1_0;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MessageDetail extends Activity {
	private String md_content, md_sex, md_accept_num, md_post_time,
		md_school, md_start_time, md_phone_num;
	private TextView md_content_tv, md_sex_tv, md_accept_num_tv, md_post_time_tv,
		md_school_tv, md_start_time_tv, md_phone_num_tv;
	private Button cancel_btn, attend_btn;
	private String md_contents_id;
	private int recieve_pos;
	private Context mContext = this;
	
	public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mes_detail);
        
        //  接收传递过来的信息
        Bundle mBundle = this.getIntent().getExtras();
        md_content = mBundle.getString("contents");
        md_sex = mBundle.getString("sex");
        md_accept_num = mBundle.getString("accept_num");
        md_post_time = mBundle.getString("post_time");
        md_school = mBundle.getString("school");
        md_start_time = mBundle.getString("start_time");
        md_phone_num = mBundle.getString("phone_num");
        md_sex = mBundle.getString("sex");
        
        md_contents_id = mBundle.getString("contents_id");
        recieve_pos = mBundle.getInt("position");

        md_content_tv = (TextView) findViewById(R.id.de_content);
        md_sex_tv = (TextView) findViewById(R.id.de_sex);
        md_accept_num_tv = (TextView) findViewById(R.id.de_accept_num);
        md_post_time_tv = (TextView) findViewById(R.id.de_post_time);
		md_school_tv = (TextView) findViewById(R.id.de_school);
		md_start_time_tv = (TextView) findViewById(R.id.de_start_time);
		md_phone_num_tv = (TextView) findViewById(R.id.de_phone);
		cancel_btn = (Button) findViewById(R.id.de_cancel);
		attend_btn = (Button) findViewById(R.id.de_attend);
        
		md_content_tv.setText(md_content);
		md_sex_tv.setText(md_sex);
		md_accept_num_tv.setText(md_accept_num);
		md_post_time_tv.setText(md_post_time);
		md_school_tv.setText(md_school);
		md_start_time_tv.setText(md_start_time);
		md_phone_num_tv.setText(md_phone_num);
		
		attend_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String url = "http://"+AppointActivity.curIp+"/android/index.php/message";
		        HashMap<String, Object> mMap = new HashMap<String, Object>();
		    	PostingMessage postingMessage = new PostingMessage();
		    	ArrayList<HashMap<String, Object>> mDataList = new ArrayList<HashMap<String, Object>>();
		    	try {
					mDataList = postingMessage.sendingMessage(mMap, url);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		    	
		    	String alertMessage = "";
		    	String receiver_id = mDataList.get(recieve_pos).get("receiver_id").toString();
		    	
		    	//  edit by japhon 0610
		    	/*
		    	String[] recs = receiver_id.split("#");
		    	boolean isUserExist = false;
		    	for (int i = 0; i < recs.length; i++) {
		    		if (recs[i].equals(LoginActivity.user_id + "")) {
		    			isUserExist = true;
		    		}
		    	}
		    	if (isUserExist) {
		    		alertMessage = "童鞋你已经参与过啦";
		    	} else {
		    		String accept_num_str = mDataList.get(recieve_pos).get("accept_num").toString();
					int accept_num = Integer.parseInt(accept_num_str);
					accept_num++;
					receiver_id = (receiver_id + "#" + LoginActivity.user_id);
					url =  "http://"+AppointActivity.curIp+"/android/index.php/message/update";
					mMap.clear();
					mMap.put("contents_id", md_contents_id);
					mMap.put("receiver_id", receiver_id);
					mMap.put("accept_num", accept_num);
					mDataList.clear();
					try {
						mDataList = postingMessage.sendingMessage(mMap, url);
						AppointActivity.setData();
					} catch (Exception e) { }
						alertMessage = mDataList.get(0).get("mess").toString();
		    		}
		    		*/
		    	if(receiver_id.indexOf(LoginActivity.user_name) == -1){
		    		String accept_num_str = mDataList.get(recieve_pos).get("accept_num").toString();
					int accept_num = Integer.parseInt(accept_num_str);
					accept_num++;
					receiver_id = (receiver_id + "#" + LoginActivity.user_name);
					url =  "http://"+AppointActivity.curIp+"/android/index.php/message/update";
					mMap.clear();
					mMap.put("contents_id", md_contents_id);
					mMap.put("receiver_id", receiver_id);
					mMap.put("accept_num", accept_num);
					mDataList.clear();
					try {
						mDataList = postingMessage.sendingMessage(mMap, url);
						AppointActivity.setData();
					} catch (Exception e) { }
					alertMessage = mDataList.get(0).get("mess").toString();
		    	}else{
		    		alertMessage = "童鞋你已经参与过啦";
		    	}
		    	
				// 点击加入后信息提示
				AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
				builder1.setMessage(alertMessage)
			       .setCancelable(false)
			       .setPositiveButton("确定",  new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	   dialog.cancel();
			        	   MessageDetail.this.finish();
			           }
			       });
				builder1.setTitle("提示");
				builder1.create().show();
			}		
		});
		
		cancel_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				MessageDetail.this.finish();
			}		
		});
	}
}
