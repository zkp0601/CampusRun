package com.example.campusrun1_0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends Activity {
	private EditText name,password;
	private String nameStr, passStr;
	private Button login_btn,register_btn;
	private CheckBox check_rem_key;
	private Intent intent;
	private String isMemory = "";//isMemory变量用来判断SharedPreferences有没有数据，包括上面的YES和NO
	private String FILE = "saveUserNamePwd";//用于保存SharedPreferences的文件
	private SharedPreferences sp = null;//声明一个SharedPreferences
	
	public static int user_id = 0;
	public static String user_sex, phone_num, email, age, school;
	public static String user_name = "";
	static PostingMessage postingMessage = new PostingMessage();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		check_rem_key = (CheckBox) findViewById(R.id.check_rem_key);
		login_btn = (Button)findViewById(R.id.login_btn);
		register_btn = (Button)findViewById(R.id.register_btn);
		name = (EditText)findViewById(R.id.login_name);
		password = (EditText)findViewById(R.id.login_password);
		
		sp = getSharedPreferences(FILE, MODE_PRIVATE);
		isMemory = sp.getString("isMemory", "no");
		
		// 严苟模式, 解决HttpClient.execute() 阻塞问题
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
        .detectDiskReads()
        .detectDiskWrites()
        .detectNetwork()   // or .detectAll() for all detectable problems
        .penaltyLog()
        .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());
		
        //  如果记住密码，则直接写入输入框
        if (isMemory.equals("yes")) {
	        nameStr = sp.getString("name", "");
	    	passStr = sp.getString("password", "");
	    	name.setText(nameStr);
	    	password.setText(passStr);
        }
    	Editor editor = sp.edit();
    	editor.putString(nameStr, name.toString());
    	editor.putString(passStr, password.toString());
    	editor.commit();
        
		login_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				name = (EditText)findViewById(R.id.login_name);
				password = (EditText)findViewById(R.id.login_password);
				
				// 若输入的帐号或者密码为空
				if(name.getText().toString().equals("")){
					name.requestFocus();
					name.setError("用户名不能为空");
					return;
				}
				else if(password.getText().toString().equals("")){
					password.requestFocus();
					password.setError("密码不能为空");
					return;
				}
				else{
					// 验证帐号输入
					PostingMessage postingMessage = new PostingMessage();
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("user_name", name.getText().toString());
					map.put("user_pass", password.getText().toString());
					String url = "http://"+AppointActivity.curIp+"/android/index.php/login/";
					ArrayList<HashMap<String, Object>> message = new ArrayList<HashMap<String, Object>>();
					
					try {
						message = postingMessage.sendingMessage(map, url);
					} catch (Exception e) { }
					
					if (!message.isEmpty()) {
//						for(Map.Entry<String, Object> entry : message.get(0).entrySet())
//							Log.e(entry.getKey(), entry.getValue().toString());
						if(message.get(0).containsKey("user_id")){
							LoginActivity.user_id = Integer.parseInt(message.get(0).get("user_id").toString());
							LoginActivity.user_name = name.getText().toString();
							message.clear(); // 清空先前的信息
							
							// 登录成功，读取个人信息表格记录在本地参数
			        		setPersonInfo();
							
			        		//  判断是否记住密码，若记住，写入文件
			        		remenber();
			        		
			        		//  页面跳转
							intent = new Intent(LoginActivity.this, MainActivity.class);
							startActivity(intent);  
							LoginActivity.this.finish(); 
						}
						else {
							password.setText("");
							password.setHint("账号或密码错误");
							password.requestFocus();
						}
					}
				}
			}
		});
		
		register_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				intent = new Intent(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);  
				//  LoginActivity.this.finish(); 
			}
		});
	}
	
	static void setPersonInfo(){
		String url_us = "http://"+AppointActivity.curIp+"/android/index.php/person_info/index";
		Map<String, Object> map_us = new HashMap<String, Object>();
		map_us.put("user_id", LoginActivity.user_id);
		ArrayList<HashMap<String, Object>> return_message_us = new ArrayList<HashMap<String, Object>>();
		try {
			return_message_us = postingMessage.sendingMessage(map_us, url_us);
		} catch (Exception e) {}
		user_sex = return_message_us.get(0).get("sex").toString();
		phone_num = return_message_us.get(0).get("phone_num").toString();
		email = return_message_us.get(0).get("email").toString();
		age = return_message_us.get(0).get("age").toString(); 
		school = return_message_us.get(0).get("school").toString();
	}

	public void remenber() {
		if (check_rem_key.isChecked()) {
			if (sp == null) {
				sp = getSharedPreferences(FILE, MODE_PRIVATE);
			}
			Editor edit = sp.edit();
			edit.putString("name", name.getText().toString());
			edit.putString("password", password.getText().toString());
			edit.putString("isMemory", "yes");
			edit.commit();
		} else {
			if (sp == null) {
				sp = getSharedPreferences(FILE, MODE_PRIVATE);
			}
			Editor edit = sp.edit();
			edit.putString("isMemory", "no");
			edit.commit();
		}
	}
}
