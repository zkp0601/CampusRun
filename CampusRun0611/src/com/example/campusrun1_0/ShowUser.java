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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by zhuangzefan on 15/5/5.
 */
public class ShowUser extends Activity {
	
	private ImageButton return_btn,edit_btn;
	private EditText phone,email,sex,age,school;
	private Button edit_ok;
	private Spinner edit_school, edit_sex;
	private TextView display_username;
	private Context mContext = this;
	PostingMessage postingMessage = new PostingMessage();
	HashMap<String, Object> map = new HashMap<String, Object>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.userpage);
        
        return_btn = (ImageButton)findViewById(R.id.edit_returnbtn);
        edit_btn = (ImageButton)findViewById(R.id.editbtn);
        
        display_username = (TextView)findViewById(R.id.display_username);
        phone = (EditText)findViewById(R.id.phone);
        email = (EditText)findViewById(R.id.email);
        sex = (EditText)findViewById(R.id.sex);
        age = (EditText)findViewById(R.id.age);
        school = (EditText)findViewById(R.id.school);
        edit_school = (Spinner)findViewById(R.id.edit_school);
        edit_sex = (Spinner)findViewById(R.id.edit_sex);
        edit_ok = (Button)findViewById(R.id.edit_ok);
        
        // 设置个人信息
        display_username.setText(LoginActivity.user_name);
        phone.setText(LoginActivity.phone_num);
        email.setText(LoginActivity.email);
        sex.setText(LoginActivity.user_sex);
        age.setText(LoginActivity.age);
        school.setText(LoginActivity.school);
        
        return_btn.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				ShowUser.this.finish(); 
			}
		});
        
        edit_btn.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				phone.setEnabled(true); 
				email.setEnabled(true);
				sex.setVisibility(View.GONE);
				edit_sex.setVisibility(View.VISIBLE);
				for (int i = 0; i < 2; i++) {
					if (edit_sex.getItemAtPosition(i).toString().equals(sex.getText().toString())) {
						edit_sex.setSelection(i);
						break;
					}
				}
				age.setEnabled(true);
				school.setVisibility(View.GONE);
				edit_school.setVisibility(View.VISIBLE);
				for (int i = 0; i < 4; i++) {
					if (edit_school.getItemAtPosition(i).toString().equals(school.getText().toString())) {
						edit_school.setSelection(i);
						break;
					}
				}
				edit_ok.setVisibility(View.VISIBLE);
			}
		});
        
        edit_ok.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				// 除学校和性别外，若用户信息填写不完整则默认为未填写
				if(phone.getText().toString().equals(""))
					phone.setText("NULL");
				if(email.getText().toString().equals(""))
					email.setText("NULL");
				if(age.getText().toString().equals(""))
					age.setText("NULL");
				else{
					String url = "http://"+AppointActivity.curIp+"/android/index.php/person_info/update/";
					
					map.put("user_id", LoginActivity.user_id+"");
					map.put("email", email.getText().toString());
					map.put("phone_num", phone.getText().toString());
					map.put("age", age.getText().toString());
					map.put("sex", sex.getText().toString());
					map.put("school", edit_school.getSelectedItem().toString());
					ArrayList<HashMap<String, Object>> person_info_update = new ArrayList<HashMap<String, Object>>();
					try {
						person_info_update = postingMessage.sendingMessage(map, url);
						AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
						builder1.setMessage(person_info_update.get(0).get("mess").toString())
					       .setCancelable(false)
					       .setPositiveButton("确定",  new DialogInterface.OnClickListener() {
					           public void onClick(DialogInterface dialog, int id) {
					        	   try {
									updateMessage();
									AppointActivity.setData();
					        	   } catch (Exception e) { }
					        	   phone.setEnabled(false); 
					        	   email.setEnabled(false);
					        	   sex.setVisibility(View.VISIBLE);
					        	   sex.setText(edit_sex.getSelectedItem().toString());
					        	   edit_sex.setVisibility(View.GONE);
					        	   age.setEnabled(false);
					        	   school.setVisibility(View.VISIBLE);
					        	   school.setText(edit_school.getSelectedItem().toString());
					        	   edit_school.setVisibility(View.GONE);
					        	   edit_ok.setVisibility(View.GONE);
					        	   dialog.cancel();
					           }
					       });
						builder1.setTitle("提示");
						builder1.create().show();
					} catch (Exception e) { }
					LoginActivity.setPersonInfo();
				}
			}
		});
    }
    
    private void updateMessage() throws Exception{
    	String url = "http://"+AppointActivity.curIp+"/android/index.php/message/update";
    	postingMessage.sendingMessage(map, url);
    }
}