package com.example.campusrun1_0;

//  import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;

/**
 * Created by zhuangzefan on 15/5/5.
 */

public class PersonalActivity extends BaseFragment {

    private View layoutView;

    public RelativeLayout user_btn;
    public RelativeLayout plan_btn;
    public RelativeLayout attend_btn;
    public RelativeLayout help_btn;
    public RelativeLayout about_btn;
    private TextView my_username;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        layoutView = inflater.inflate(R.layout.personal_information, null);

        user_btn = (RelativeLayout) layoutView.findViewById(R.id.userbtn);
        plan_btn = (RelativeLayout) layoutView.findViewById(R.id.planbtn);
        attend_btn = (RelativeLayout) layoutView.findViewById(R.id.my_attend_btn);
        help_btn = (RelativeLayout) layoutView.findViewById(R.id.helpbtn);
        about_btn = (RelativeLayout) layoutView.findViewById(R.id.aboutbtn);
        my_username = (TextView) layoutView.findViewById(R.id.my_username);
        my_username.setText(LoginActivity.user_name);

        user_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity().getApplicationContext(), ShowUser.class);
                startActivity(intent);
            }
        });

        plan_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity().getApplicationContext(), ShowPlan.class);
                startActivity(intent);
            }
        });

        attend_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity().getApplicationContext(), ShowMyAttend.class);
                startActivity(intent);
            }
        });
        
        help_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity().getApplicationContext(), ShowHelp.class);
                startActivity(intent);
            }
        });

        about_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity().getApplicationContext(), ShowAbout.class);
                startActivity(intent);
            }
        });

        return layoutView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
