package com.sh.mybottomlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * author： TongGuHermit
 * created on： 2018/9/30 10:09
 */

public class BottomLayout extends LinearLayout implements OnClickListener{
	private Context mContext;
	private BottomItemView mView;
	private BottomItemDTO bottomItemDTO;
	private ArrayList<BottomItemDTO> items;
	private int NORMALTEXTCOLOR;
	private int SELECTTEXTCOLOR;
	private int NORMALBOTTOMCOLOR;
	private int SELECTBOTTOMCOLOR;

	public BottomLayout(@NonNull Context context) {
		super(context);
		mContext = context;
		initView();

	}

	public BottomLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		initView();
	}



	public BottomLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mContext = context;
		initView();
	}

	private void initView() {
		setOrientation(HORIZONTAL);
	}


	public void initData(ArrayList<BottomItemDTO> items) {
		this.items = items;
		LayoutParams params = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
		params.weight=1;
		for (int i = 0 ;i <items.size();i++){
			mView = new BottomItemView(getContext());
			mView.setTag(i);
			mView.setTextColor(NORMALTEXTCOLOR,SELECTTEXTCOLOR);
			mView.setBottomViewColor(NORMALBOTTOMCOLOR,SELECTBOTTOMCOLOR);
			mView.initItem(items.get(i));
			addView(mView,params);
			mView.setOnClickListener(this);
		}

	}


	@Override
	public void onClick(View v) {
		int position = (int)v.getTag();
		Log.e("position",String.valueOf(position));
		for (int i = 0 ;i <items.size();i++){
			if (i != position){
				items.get(i).isSelect = false;
				mView = (BottomItemView) getChildAt(i);
				mView.setTextColor(NORMALTEXTCOLOR,SELECTTEXTCOLOR);
				mView.setBottomViewColor(NORMALBOTTOMCOLOR,SELECTBOTTOMCOLOR);
				mView.initItem(items.get(i));
			}else if (i == position){
				items.get(i).isSelect = !items.get(i).isSelect;
				mView = (BottomItemView) getChildAt(i);
				mView.setTextColor(NORMALTEXTCOLOR,SELECTTEXTCOLOR);
				mView.setBottomViewColor(NORMALBOTTOMCOLOR,SELECTBOTTOMCOLOR);
				mView.initItem(items.get(i));
			}
		}
	}

	public void setTextColor(int textColorNormal, int textColorSelect) {
		NORMALTEXTCOLOR = textColorNormal;
		SELECTTEXTCOLOR = textColorSelect;
	}

	public void setBottomViewColor(int normalImg, int selectImg) {
		NORMALBOTTOMCOLOR = normalImg;
		SELECTBOTTOMCOLOR = selectImg;
	}
}
