package com.example.campusrun1_0;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

/**
 * Created by zhuangzefan on 15/5/4.
 */
public class ShowAbout extends Activity {
	
	private ImageButton return_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.about);
        return_btn = (ImageButton)findViewById(R.id.about_returnbtn);
        
        return_btn.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				ShowAbout.this.finish(); 
			}
		});
    }
}
/*
public class ShowAbout extends BaseFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private View layoutView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        layoutView = inflater.inflate(R.layout.about, null);
        return layoutView;
    }
}
*/