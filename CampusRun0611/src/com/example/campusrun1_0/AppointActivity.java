package com.example.campusrun1_0;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zhuangzefan on 15/5/5.
 */
public class AppointActivity extends BaseFragment {
	
	public static String curIp = "172.18.33.27";  //  手机WIFI：192.168.43.131
	
    static ArrayList<HashMap<String, Object>> mDataList = new ArrayList<HashMap<String, Object>>();
    private static ArrayList<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    private static ArrayList<HashMap<String, Object>> tempRList = new ArrayList<HashMap<String, Object>>();
    public ListView appListview;
    private View layoutView;
    private ImageButton add_btn;
    private ImageButton search_btn;
    private Spinner school_spi, sex_spi;
    private Bundle mBundle;
    
    public static void setData() throws Exception {
    	String url = "http://"+curIp+"/android/index.php/message/index/";
        HashMap<String, Object> mMap = new HashMap<String, Object>();
    	PostingMessage postingMessage = new PostingMessage();
    	
    	/* 
    	 * mDataList 储存返回的所有约跑信息，每条信息均是一个 map 对象
    	 * 每个 map 对象包含的key有 contents(约跑信息内容), post_time(信息发布内容), 
    	 * sex(发布者性别), start_time(开始跑步时间), school(学校), accept_num(参与者人数), 
    	 * poster_name(发布者用户名), receiver_id(参与者ID,各ID之间以 # 分隔,如1#2表示当前参与者有1和2)
    	 */
    	mDataList.clear();
    	resultList.clear();
    	mMap.clear();
    	mDataList = postingMessage.sendingMessage(mMap, url);
    	resultList.addAll(mDataList);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
			setData();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        layoutView = inflater.inflate(R.layout.appoint_main, null);
        appListview = (ListView) layoutView.findViewById(R.id.appointlist);
        
        final myAdapter mSimpleAdapter = new myAdapter(getActivity().getApplicationContext(), resultList);
        appListview.setAdapter(mSimpleAdapter);
        
        add_btn = (ImageButton) layoutView.findViewById(R.id.add_btn);
        search_btn = (ImageButton) layoutView.findViewById(R.id.search_btn);
        school_spi = (Spinner) layoutView.findViewById(R.id.spinner_school);
        sex_spi = (Spinner) layoutView.findViewById(R.id.spinner_sex);
        
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
            	 Intent intent = new Intent();
                 intent.setClass(getActivity().getApplicationContext(), AddAppointActivity.class);
                 startActivity(intent);  
            }

        });
        
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            // 通过条件进行筛选
            public void onClick(View arg0) {
            	resultList.clear();
            	String goalSch = school_spi.getSelectedItem().toString();
            	String goalSex = sex_spi.getSelectedItem().toString();
            	if(mDataList.size() == 0)
            		return;
            	//  通过学校进行筛选        	
            	if (!goalSch.equals("学校") && mDataList.get(0).containsKey("user_id")) {
					for (int i = 0; i < mDataList.size(); i++) {
						String tempSch = mDataList.get(i).get("school").toString();
						if (tempSch.equals(goalSch)) {
							resultList.add(mDataList.get(i));
						}
					}
            	} else {
            		if(mDataList.get(0).containsKey("user_id"))
            			resultList.addAll(mDataList);
            	}
            	
            	// 通过性别进行筛选         	
            	if (!goalSex.equals("性别")) {
            		tempRList.clear();
            		if(resultList.size() > 0)
            			tempRList.addAll(resultList);
            		Log.e("tempRList", tempRList.size()+"");
            		resultList.clear();
            		for (int i = 0; i < tempRList.size(); i++) {
            			String tempSex = tempRList.get(i).get("sex").toString();
            			if (tempSex.equals(goalSex)) {
            				resultList.add(tempRList.get(i));
            			}
            		}
            	}
            	
            	final myAdapter mSimpleAdapter = new myAdapter(getActivity().getApplicationContext(), resultList);
            	appListview.setAdapter(mSimpleAdapter);
            }

        });
        
        //  ListView 弹出约跑信息详情       
        appListview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mBundle = new Bundle();
				mBundle.clear();
				mBundle.putString("contents", ((TextView) view.findViewById(R.id.listNameText)).getText().toString());
//				mBundle.putString("post_time", ((TextView) view.findViewById(R.id.listTimeText)).getText().toString());

				try {
					setData();
				} catch (Exception e) {
					e.printStackTrace();
				}
				HashMap<String, Object> curUser = new HashMap<String, Object>();
				curUser.putAll(resultList.get(position));
				mBundle.putString("sex", curUser.get("sex").toString());

				mBundle.putString("phone_num", curUser.get("phone_num").toString());
				mBundle.putString("post_time", curUser.get("post_time").toString());
				mBundle.putString("school", curUser.get("school").toString());
				mBundle.putString("accept_num", curUser.get("accept_num").toString());
				mBundle.putString("start_time", curUser.get("start_time").toString());				
				mBundle.putString("contents_id", curUser.get("contents_id").toString());
				mBundle.putInt("position", position);
				
				Intent i = new Intent(getActivity().getApplicationContext(), MessageDetail.class);
				i.putExtras(mBundle);
				startActivity(i);
				
			}
		});
        
        return layoutView;
    }
}
