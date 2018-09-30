package com.sh.mybottomlayout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * author： TongGuHermit
 * created on： 2018/9/30 11:44
 */

public class BottomItemView extends LinearLayout {

	private Context mContext;
	private ImageView mBottomImageView;
	private TextView mBottomTextView;
	private View mBottomColorView;
	private View mView;
	private BottomItemDTO bottomItemDTO;
	private int NORMALBOTTOMCOLOR;
	private int SELECTBOTTOMCOLOR;
	private int NOMALTEXTCOLOR;
	private int SELECTTEXTCOLOR;


	public BottomItemView(Context context) {
		super(context);
		mContext = context;
		initView(mContext);
	}

	public BottomItemView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		initView(mContext);
	}

	public BottomItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mContext = context;
		initView(mContext);
	}

	private void initView(Context context) {
		setOrientation(VERTICAL);
		setGravity(Gravity.CENTER);
		mView = LayoutInflater.from(mContext).inflate(R.layout.item_bottom,this,true);
		mBottomImageView = (ImageView) mView.findViewById(R.id.item_bottom_img);
		mBottomTextView = (TextView) mView.findViewById(R.id.item_bottom_text);
		mBottomColorView = (View) mView.findViewById(R.id.item_bottom_color);

	}

	public void initItem(BottomItemDTO bottomItemDTO) {
		if (bottomItemDTO.getItemText().equals("")) {
			if (bottomItemDTO.isSelect){
				mBottomTextView.setVisibility(GONE);
				mBottomColorView.setBackgroundColor(getResources().getColor(SELECTBOTTOMCOLOR));
				mBottomImageView.setImageResource(bottomItemDTO.getSelectImage());
			}else {
				mBottomTextView.setVisibility(GONE);
				mBottomColorView.setBackgroundColor(getResources().getColor(NORMALBOTTOMCOLOR));
				mBottomImageView.setImageResource(bottomItemDTO.getNomalImage());
			}
		}else {
			if (bottomItemDTO.isSelect){
				mBottomTextView.setVisibility(VISIBLE);
				mBottomTextView.setText(bottomItemDTO.getItemText());
				mBottomTextView.setTextColor(getResources().getColor(SELECTTEXTCOLOR));
				mBottomColorView.setBackgroundColor(getResources().getColor(SELECTBOTTOMCOLOR));
				mBottomImageView.setImageResource(bottomItemDTO.getSelectImage());
			}else {
				mBottomTextView.setVisibility(VISIBLE);
				mBottomTextView.setText(bottomItemDTO.getItemText());
				mBottomTextView.setTextColor(getResources().getColor(NOMALTEXTCOLOR));
				mBottomColorView.setBackgroundColor(getResources().getColor(NORMALBOTTOMCOLOR));
				mBottomImageView.setImageResource(bottomItemDTO.getNomalImage());
			}
		}

	}

	public void setTextColor(int nomalTextColor, int selectTextColor) {
		NOMALTEXTCOLOR = nomalTextColor;
		SELECTTEXTCOLOR = selectTextColor;
	}

	public void setBottomViewColor(int normalImage, int selectTextColor) {
		NORMALBOTTOMCOLOR = normalImage;
		SELECTBOTTOMCOLOR = selectTextColor;
	}
}
