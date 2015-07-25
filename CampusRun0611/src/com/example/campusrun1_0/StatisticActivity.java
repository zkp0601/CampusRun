package com.example.campusrun1_0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

public class StatisticActivity extends Activity {
	
	private ImageButton return_btn;
	private TextView last_distance, last_time, last_kaluli, 
		total_distance, total_time, total_kaluli;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.statistic);
		
		return_btn = (ImageButton)findViewById(R.id.returnbtn);
		last_distance = (TextView) findViewById(R.id.last_distance);
		last_time = (TextView) findViewById(R.id.last_time);
		last_kaluli = (TextView) findViewById(R.id.last_kaluli);
		total_distance = (TextView) findViewById(R.id.total_distance);
		total_time = (TextView) findViewById(R.id.total_time);
		total_kaluli = (TextView) findViewById(R.id.total_kaluli);
		
		String url = "http://"+AppointActivity.curIp+"/android/index.php/run_record/";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", LoginActivity.user_id);
		PostingMessage postingMessage = new PostingMessage();
		ArrayList<HashMap<String, Object>> message = new ArrayList<HashMap<String, Object>>();
		try {
			message = postingMessage.sendingMessage(map, url);
		} catch (Exception e) { }
		
		if(!message.isEmpty()){
			if(message.get(0).containsKey("user_id")){
				HashMap<String, Object> temp = message.get(0);
				last_distance.setText(temp.get("last_distance").toString());
				last_time.setText(temp.get("last_time").toString());
				last_kaluli.setText(temp.get("last_kaluli").toString());
				total_distance.setText(temp.get("total_distance").toString());
				total_time.setText(temp.get("total_time").toString());
				total_kaluli.setText(temp.get("total_kaluli").toString());
			}
		}
		
		return_btn.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				StatisticActivity.this.finish(); 
			}
		});
	}

}
