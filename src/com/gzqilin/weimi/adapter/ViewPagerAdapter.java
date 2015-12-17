package com.gzqilin.weimi.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author lsh
 * 第一次进应用是的介绍适配
 */
public class ViewPagerAdapter extends PagerAdapter {

	private List<View> mData;

	public ViewPagerAdapter(List<View> mData) {
		super();
		this.mData = mData;
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {

		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView(mData.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		((ViewPager) container).addView(mData.get(position));
		return mData.get(position);
	}

}
