package com.example.campusrun1_0;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;


public class AddAppointActivity extends Activity {
	private EditText content;
	private Switch clock;
	//  private EditText school;
	private Spinner choose_school_spi;
	private EditText year, month, day, hour, minute;
	private Button submit;
	private Context mContext = this;
	@Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_appoint);
        
        submit = (Button) findViewById(R.id.submit);
        content = (EditText) findViewById(R.id.info);
        choose_school_spi = (Spinner) findViewById(R.id.chooseschool);
        
        year = (EditText) findViewById(R.id.year);
        month = (EditText) findViewById(R.id.month);
        day = (EditText) findViewById(R.id.day);
        hour = (EditText) findViewById(R.id.hour);
        minute = (EditText) findViewById(R.id.minute);
        
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            /*that's something wrong*/
            public void onClick(View arg0) {
            	PostingMessage postingMessage = new PostingMessage();
            	String url = "http://"+AppointActivity.curIp+"/android/index.php/message/insert";
        		Map<String, Object> map = new HashMap<String, Object>();
        		
        		//  cur time
        		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");       
        		Date curDate = new Date(System.currentTimeMillis());//获取当前时间       
        		String curDateStr = formatter.format(curDate);  
        		
        		//  start time
        		String startTime = year.getText().toString() + "-" +
        				month.getText().toString() + "-" +
        				day.getText().toString() + " " +
        				hour.getText().toString() + ":" +
        				minute.getText().toString() + ":" + "22";
        		
        		
        		map.put("user_id", LoginActivity.user_id);
        		map.put("contents", content.getText().toString());
        		map.put("school", choose_school_spi.getSelectedItem().toString());
        		map.put("phone_num", LoginActivity.phone_num);
        		map.put("start_time", startTime);
        		map.put("sex", LoginActivity.user_sex);
        		map.put("post_time", curDateStr);
        		map.put("poster_name", LoginActivity.user_name);
        		map.put("receiver_id", LoginActivity.user_name);
        		ArrayList<HashMap<String, Object>> return_message = new ArrayList<HashMap<String, Object>>();
        		try {
					return_message = postingMessage.sendingMessage(map, url);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
        		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
				builder.setMessage(return_message.get(0).get("mess").toString())
			       .setCancelable(false)
			       .setPositiveButton("确定", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	   AddAppointActivity.this.finish();
			           }
			       });
				builder.setTitle("提示");
				builder.create().show();
				try {
					AppointActivity.setData();
				} catch (Exception e) {
					e.printStackTrace();
				}
            }

        });
	}
        

}
