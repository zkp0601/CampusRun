package com.example.campusrun1_0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RegisterActivity extends Activity {
	
	private EditText register_name, register_pass, confirm_pass, register_phone;
	private RadioGroup register_sex;
	private Button confirm_button;
	private Context mContext = this;
	private String sex = "男";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		register_name = (EditText)findViewById(R.id.register_name);
		register_pass = (EditText)findViewById(R.id.register_password);
		confirm_pass = (EditText)findViewById(R.id.register_confirm_password);
		confirm_button = (Button)findViewById(R.id.register_btn);
		register_phone = (EditText)findViewById(R.id.register_tel);
		register_sex = (RadioGroup)findViewById(R.id.register_sex);
		register_name.requestFocus();
		register_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton register_sex_button = (RadioButton)findViewById(register_sex.getCheckedRadioButtonId());
				sex = "";
				sex += register_sex_button.getText().toString();
			}
		});
		
		confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
            	// 若注册信息有部分为空
            	if(register_name.getText().toString().equals("")){
            		register_name.requestFocus();
            		register_name.setError("用户名不能为空");
            		return;
            	}
            	else if(register_pass.getText().toString().equals("")){
            		register_pass.requestFocus();
            		register_pass.setError("密码不能问为空");
            		return;
            	}
            	else if(confirm_pass.getText().toString().equals("")){
            		confirm_pass.requestFocus();
            		confirm_pass.setError("确认密码不能为空");
            		return;
            	}
            	else if(register_phone.getText().toString().equals("")){
            		register_phone.requestFocus();
            		register_phone.setError("电话不能为空");
            		return;
            	}
            	// 若输入密码不一致
            	else if( !(confirm_pass.getText().toString()).equals(register_pass.getText().toString()) ){
            		confirm_pass.requestFocus();
            		confirm_pass.setError("输入密码不一致");
            		return;
            	}else if( !checkPhoneNum(register_phone.getText().toString()) ){
            		register_phone.requestFocus();
            		register_phone.setError("电话格式不正确");
            	}
            	else{ 
            		PostingMessage postingMessage = new PostingMessage();
            		String url = "http://"+AppointActivity.curIp+"/android/index.php/login/register";
            		Map<String, Object> map = new HashMap<String, Object>();
            		map.put("user_name", register_name.getText().toString());
            		map.put("user_pass", register_pass.getText().toString());
            		map.put("phone_num", register_phone.getText().toString());
            		map.put("sex", sex);
            		try {
						ArrayList<HashMap<String, Object>> message = postingMessage.sendingMessage(map, url);
						if( message.size() > 0){
							// 若用户名已存在
							if(message.get(0).get("mess").toString().equals("用户名已存在")){
								register_name.requestFocus();
								register_name.setError("用户名已存在");
							}else{
								AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
								builder1.setMessage("注册成功")
							       .setCancelable(false)
							       .setPositiveButton("确定",  new DialogInterface.OnClickListener() {
							           public void onClick(DialogInterface dialog, int id) {
							        	   RegisterActivity.this.finish();
							           }
							       });
								builder1.setTitle("提示");
								builder1.create().show();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
            	}
            }
        });
	}
	
	// 判断输入的电话号码是否合法
	private boolean checkPhoneNum(String register_phone){
		Pattern pattern = Pattern.compile("([0-9]+-){0,1}[0-9]+"); 
		Matcher isNum = pattern.matcher(register_phone);
		if( !isNum.matches() ){
			return false; 
		} 
		return true; 
	}
}
