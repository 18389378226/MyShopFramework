package com.chensen.myshopframework.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.chensen.myshopframework.R;


public class MyRadioButton extends RadioButton {
	private Drawable drawableTop;
	private int mTopWith, mTopHeight;

	public MyRadioButton(Context context) {
		super(context);
		initView(context, null);
	}

	public MyRadioButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context, attrs);
	}

	public MyRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView(context, attrs);
	}

	private void initView(Context context, AttributeSet attrs) {
		if (attrs != null) {
			float scale = context.getResources().getDisplayMetrics().density;
			TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyRadioButton);
			int n = a.getIndexCount();
			for (int i = 0; i < n; i++) {
				int attr = a.getIndex(i);
				switch (attr) {
				case R.styleable.MyRadioButton_drawableTop:
					drawableTop = a.getDrawable(attr);
					break;
				case R.styleable.MyRadioButton_drawableTopWith:
					mTopWith = (int) (a.getDimension(attr, 20));
					break;
				case R.styleable.MyRadioButton_drawableTopHeight:
					mTopHeight = (int) (a.getDimension(attr, 20));
					break;
				}
			}
			a.recycle();
			setCompoundDrawablesWithIntrinsicBounds(null, drawableTop, null, null);
		}
	}

	// 设置Drawable定义的大小
	@Override
	public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
		if (top != null) {
			top.setBounds(0, 0, mTopWith <= 0 ? top.getIntrinsicWidth() : mTopWith,
					mTopHeight <= 0 ? top.getMinimumHeight() : mTopHeight);
		}

		setCompoundDrawables(left, top, right, bottom);
	}

}
