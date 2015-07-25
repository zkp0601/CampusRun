package com.example.campusrun1_0;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class myAdapter extends BaseAdapter {
	List<Map<String, String>> list;
	Context mContext = null;

	public myAdapter(Context it, List list) {
		this.list = list;
		this.mContext = it;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int positoin, View arg1, ViewGroup arg2) {
		
		final int index = positoin;
		View view = arg1;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.list_item, null);
		}
		//  ImageButton ib = (ImageButton) view.findViewById(R.id.imageButton1);
		TextView contentstv = (TextView) view.findViewById(R.id.listContentText);
		TextView posttimetv = (TextView) view.findViewById(R.id.listTimeText);
        ImageView sextv = (ImageView) view.findViewById(R.id.list_sex);
        ImageView icon = (ImageView) view.findViewById(R.id.list_display_icon);
        TextView schooltv = (TextView) view.findViewById(R.id.listSchoolText);
        TextView user_name = (TextView) view.findViewById(R.id.listNameText);

        
		String contentsstr = list.get(index).get("contents");
		String posttimeStr = list.get(index).get("post_time");
        String sexstr = list.get(index).get("sex");
        String schoolStr = list.get(index).get("school");
        String nameStr = list.get(index).get("poster_name");
        
        user_name.setText(nameStr);
		contentstv.setText(contentsstr);
		posttimetv.setText(posttimeStr);
        schooltv.setText(schoolStr);
        
        if(sexstr.equals("ÄÐ")){
        	sextv.setImageResource(R.drawable.male);
        	icon.setImageResource(R.drawable.myicon);
        } else {
        	sextv.setImageResource(R.drawable.female);
        	icon.setImageResource(R.drawable.myicon_female);
        }

		//  ib.setTag(index);
		/*ib.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				list.remove(index);
				myAdapter.this.notifyDataSetChanged();
			}
		});*/
		return view;
	}

}
