package com.gzqilin.weimi.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.gzqilin.weimi.R;
import com.gzqilin.weimi.adapter.ViewPagerAdapter;
import com.gzqilin.weimi.utils.IntentUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lsh
 * 用户第一次使用app是的介绍引导界面
 */

public class FirstUseAty extends BaseActivity {
	@ViewInject(R.id.view_pager)
	private ViewPager view_pager;
	@ViewInject(R.id.btn1)
	private Button btn1;
	private List<View> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new);
		ViewUtils.inject(this);
		data = new ArrayList<View>();
		ImageView img = new ImageView(this);
		img.setBackgroundResource(R.drawable.guide1);
		data.add(img);
		img = new ImageView(this);
		img.setBackgroundResource(R.drawable.guide2);
		data.add(img);
		img = new ImageView(this);
		img.setBackgroundResource(R.drawable.guide3);
		data.add(img);

		ViewPagerAdapter adapter = new ViewPagerAdapter(data);
		view_pager.setAdapter(adapter);

		view_pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				if (arg0 == data.size() - 1) {
					btn1.setVisibility(View.VISIBLE);
				} else {
					btn1.setVisibility(View.GONE);
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		btn1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				IntentUtils.startActivity(FirstUseAty.this,LoginAty.class);
				finish();
			}
		});
	}
}
