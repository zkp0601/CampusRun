package com.example.campusrun1_0;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ShowPlan extends Activity {
	private ImageButton return_btn;
	public ListView appListview;
    private View layoutView;
    private Bundle mBundle;
    private ArrayList<HashMap<String, Object>> myMessageList = new ArrayList<HashMap<String, Object>>();
    private Context mContext = this;
    
    private void setMyList(){
    	myMessageList.clear();
    	for (int i = 0; i < AppointActivity.mDataList.size(); i++) {
			if (LoginActivity.user_id == Integer.parseInt(AppointActivity.mDataList.get(i).get("user_id").toString())) {
				myMessageList.add(AppointActivity.mDataList.get(i));
			}
		}
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.plan);
        
        return_btn = (ImageButton)findViewById(R.id.plan_returnbtn);
        try {
			AppointActivity.setData();
		} catch (Exception e) { }
        
        return_btn.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				ShowPlan.this.finish(); 
			}
		});
        
        appListview = (ListView)findViewById(R.id.my_appointlist);
        
        setMyList();
        final myAdapter mSimpleAdapter = new myAdapter(mContext, myMessageList);
        appListview.setAdapter(mSimpleAdapter);
        
    	//ListView 弹出约跑信息详情       
        appListview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mBundle = new Bundle();
				mBundle.clear();
				mBundle.putString("contents", ((TextView) view.findViewById(R.id.listNameText)).getText().toString());
//				mBundle.putString("post_time", ((TextView) view.findViewById(R.id.listTimeText)).getText().toString());

				HashMap<String, Object> curUser = new HashMap<String, Object>();
				curUser.putAll(myMessageList.get(position));
				Log.e("accept_num", curUser.get("accept_num")+"");
				mBundle.putString("sex", curUser.get("sex").toString());

				mBundle.putString("phone_num", curUser.get("phone_num").toString());
				mBundle.putString("post_time", curUser.get("post_time").toString());
				mBundle.putString("school", curUser.get("school").toString());
				mBundle.putString("accept_num", curUser.get("accept_num").toString());
				mBundle.putString("start_time", curUser.get("start_time").toString());				
				mBundle.putString("contents_id", curUser.get("contents_id").toString());
				mBundle.putInt("position", position);
				
				Intent i = new Intent(ShowPlan.this, MyAttendDetail.class);
				i.putExtras(mBundle);
				startActivity(i);
				
			}
		});
    }
    
}