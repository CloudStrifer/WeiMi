package com.gzqilin.weimi.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gzqilin.weimi.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class TitleLayout extends RelativeLayout {

	private Context context;

	@ViewInject(R.id.tv_title_name)
	private TextView tvTitle;

	@ViewInject(R.id.btn_title_menu)
	private Button btnMenu;

	@ViewInject(R.id.tv_title_back)
	private TextView tvBack;

	public TitleLayout(Context context) {
		super(context);
	}

	public TitleLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init();
	}

	private void init() {
		View titleLayout = LayoutInflater.from(context).inflate(
				R.layout.title_layout, this, true);
		ViewUtils.inject(this, titleLayout);
		tvBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				((Activity) context).finish();
			}
		});
	}

	/**
	 * 设置点击返回按钮事件
	 * 
	 * @param l
	 */
	public void setOnBackListener(OnClickListener l) {
		tvBack.setOnClickListener(l);
	}

	/**
	 * 设置标题名
	 */
	public void setTitleText(String name) {
		tvTitle.setText(name);
	}

	/**
	 * 设置标题名
	 */
	public void setTitleText(int name) {
		tvTitle.setText(name);
	}

	/**
	 * 设置标题名字大小
	 */
	public void setTitleTextSize(float size) {
		tvTitle.setTextSize(size);
	}

	/**
	 * 设置标题菜单项点击事件
	 * 
	 * @param l
	 *            传入的OnClickListener接口
	 */
	public void setMenuOnClickListener(OnClickListener l) {
		btnMenu.setOnClickListener(l);
	}

	/**
	 * 设置标题菜单项是否显示
	 * 
	 * @param visibility
	 *            View.VISIBLE View.GONE 显示与消失
	 */
	public void setMenuVisibility(int visibility) {
		btnMenu.setVisibility(visibility);
	}

	public void setMenuBackgroundResource(int resid) {
		btnMenu.setBackgroundResource(resid);
	}

	public void setMenuText(String s) {
		btnMenu.setText(s);
	}

}
