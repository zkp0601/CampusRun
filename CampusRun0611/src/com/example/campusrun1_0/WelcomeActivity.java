package com.example.campusrun1_0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends Activity implements AnimationListener {
	 private ImageView imageView = null;
	 private Animation alphaAnimation = null;
		      
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);  
		 setContentView(R.layout.welcome);  
		 imageView = (ImageView)findViewById(R.id.welcome_image_view);
		 alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.welcome_alpha);
		 alphaAnimation.setFillEnabled(true); //锟斤拷锟斤拷Fill锟斤拷锟斤拷  
		 alphaAnimation.setFillAfter(true);  //锟斤拷锟矫讹拷锟斤拷锟斤拷锟斤拷锟揭恢★拷潜锟斤拷锟斤拷锟絍iew锟斤拷锟斤拷  
		 imageView.setAnimation(alphaAnimation);  
		 alphaAnimation.setAnimationListener(this);  //为锟斤拷锟斤拷锟斤拷锟矫硷拷锟斤拷  
	}  
		      
	 @Override
	 public void onAnimationStart(Animation animation) {
		          
	 }  
		      
	 @Override
	 public void onAnimationEnd(Animation animation) {
		 //锟斤拷锟斤拷锟斤拷锟斤拷时锟斤拷锟斤拷迎锟斤拷锟芥并转锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟� 
		 Intent intent = new Intent(this, LoginActivity.class);
		 startActivity(intent);  
		 this.finish();  
	 }  
		      
	 @Override
	 public void onAnimationRepeat(Animation animation) {
		          
	 }  
		      
	 @Override
	 public boolean onKeyDown(int keyCode, KeyEvent event) {
		 //锟节伙拷迎锟斤拷锟斤拷锟斤拷锟斤拷BACK锟斤拷  
		 if(keyCode== KeyEvent.KEYCODE_BACK) {
		     return false;  
		 }  
		 return false;  
	}

}
