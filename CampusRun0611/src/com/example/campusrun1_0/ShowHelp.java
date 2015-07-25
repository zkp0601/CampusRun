package com.example.campusrun1_0;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

/**
 * Created by zhuangzefan on 15/5/4.
 */
public class ShowHelp extends Activity {
	private ImageButton return_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.help);
        
        return_btn = (ImageButton)findViewById(R.id.help_returnbtn);
        
        return_btn.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				ShowHelp.this.finish(); 
			}
		});
       
    }
}