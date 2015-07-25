package com.example.campusrun1_0;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MyAttendDetail extends Activity{
	private String md_content, md_sex, md_accept_num, md_post_time,
	md_school, md_start_time, md_phone_num;
private TextView md_content_tv, md_sex_tv, md_accept_num_tv, md_post_time_tv,
	md_school_tv, md_start_time_tv, md_phone_num_tv;
private Button OK_btn;
private String md_contents_id;
private int recieve_pos;
private Context mContext = this;

public void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.my_attend_mes_detail);
    
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

    md_content_tv = (TextView) findViewById(R.id.made_content);
    md_sex_tv = (TextView) findViewById(R.id.made_sex);
    md_accept_num_tv = (TextView) findViewById(R.id.made_accept_num);
    md_post_time_tv = (TextView) findViewById(R.id.made_post_time);
	md_school_tv = (TextView) findViewById(R.id.made_school);
	md_start_time_tv = (TextView) findViewById(R.id.made_start_time);
	md_phone_num_tv = (TextView) findViewById(R.id.made_phone);
	OK_btn = (Button) findViewById(R.id.confirm_ok);
    
	md_content_tv.setText(md_content);
	md_sex_tv.setText(md_sex);
	md_accept_num_tv.setText(md_accept_num);
	md_post_time_tv.setText(md_post_time);
	md_school_tv.setText(md_school);
	md_start_time_tv.setText(md_start_time);
	md_phone_num_tv.setText(md_phone_num);
	
	OK_btn.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			MyAttendDetail.this.finish();
		}		
	});
}
}
