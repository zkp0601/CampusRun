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
	private String sex = "��";
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
            	// ��ע����Ϣ�в���Ϊ��
            	if(register_name.getText().toString().equals("")){
            		register_name.requestFocus();
            		register_name.setError("�û�������Ϊ��");
            		return;
            	}
            	else if(register_pass.getText().toString().equals("")){
            		register_pass.requestFocus();
            		register_pass.setError("���벻����Ϊ��");
            		return;
            	}
            	else if(confirm_pass.getText().toString().equals("")){
            		confirm_pass.requestFocus();
            		confirm_pass.setError("ȷ�����벻��Ϊ��");
            		return;
            	}
            	else if(register_phone.getText().toString().equals("")){
            		register_phone.requestFocus();
            		register_phone.setError("�绰����Ϊ��");
            		return;
            	}
            	// ���������벻һ��
            	else if( !(confirm_pass.getText().toString()).equals(register_pass.getText().toString()) ){
            		confirm_pass.requestFocus();
            		confirm_pass.setError("�������벻һ��");
            		return;
            	}else if( !checkPhoneNum(register_phone.getText().toString()) ){
            		register_phone.requestFocus();
            		register_phone.setError("�绰��ʽ����ȷ");
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
							// ���û����Ѵ���
							if(message.get(0).get("mess").toString().equals("�û����Ѵ���")){
								register_name.requestFocus();
								register_name.setError("�û����Ѵ���");
							}else{
								AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
								builder1.setMessage("ע��ɹ�")
							       .setCancelable(false)
							       .setPositiveButton("ȷ��",  new DialogInterface.OnClickListener() {
							           public void onClick(DialogInterface dialog, int id) {
							        	   RegisterActivity.this.finish();
							           }
							       });
								builder1.setTitle("��ʾ");
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
	
	// �ж�����ĵ绰�����Ƿ�Ϸ�
	private boolean checkPhoneNum(String register_phone){
		Pattern pattern = Pattern.compile("([0-9]+-){0,1}[0-9]+"); 
		Matcher isNum = pattern.matcher(register_phone);
		if( !isNum.matches() ){
			return false; 
		} 
		return true; 
	}
}
