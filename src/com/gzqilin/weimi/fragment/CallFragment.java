package com.gzqilin.weimi.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.gzqilin.weimi.R;
import com.gzqilin.weimi.activity.ArgproductActivity;
import com.gzqilin.weimi.utils.IntentUtils;
import com.lidroid.xutils.ViewUtils;

/**
 * Created by Administrator on 2015/12/13.
 * 
 * @author oy
 */
public class CallFragment extends BaseFragment implements OnClickListener {

	// 定义按钮
	private Button bt1;
	private Button bt2;
	private Button bt3;
	private Button bt4;
	private Button bt5;
	private ListView lv;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		ViewUtils.inject(this, view);
		init();
	}

	public void init() {
		lv = (ListView) view.findViewById(R.id.call_lv_item);

		bt1 = (Button) view.findViewById(R.id.home_bt_hot);
		bt2 = (Button) view.findViewById(R.id.home_bt_supermarket);
		bt3 = (Button) view.findViewById(R.id.home_bt_economic);
		bt4 = (Button) view.findViewById(R.id.home_bt_social);
		bt5 = (Button) view.findViewById(R.id.home_bt_argproducts);

		// 设置按钮监听
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
		bt5.setOnClickListener(this);

		ArrayList<HashMap<String, Object>> map = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 10; i++) {
			HashMap<String, Object> ob = new HashMap<String, Object>();
			ob.put("image", R.drawable.testicon);
			ob.put("title", "转基因蔬菜");
			ob.put("market", "花溪市场");
			map.add(ob);
		}

		SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), map,
				R.layout.item, new String[] { "image", "title", "market" },
				new int[] { R.id.iv_item_good_list_image,
						R.id.tv_item_good_list_title,
						R.id.tv_item_good_list_market });
		lv.setAdapter(simpleAdapter);

		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				IntentUtils.startActivity(getActivity(),
						ArgproductActivity.class);
			}
		});
	}

	/**
	 * 切换视图
	 */
	public void switchView(int id, String title, String market) {

		Object image;
		switch (id) {
		case 1:
			image = R.drawable.testpng1;
			break;
		case 2:
			image = R.drawable.testpng2;
			break;
		case 3:
			image = R.drawable.testpng3;
			break;
		case 4:
			image = R.drawable.testpng4;
			break;
		case 5:
			image = R.drawable.testpng5;
			break;
		default:
			image = R.drawable.testicon;
			break;
		}

		ArrayList<HashMap<String, Object>> map = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 10; i++) {
			HashMap<String, Object> ob = new HashMap<String, Object>();
			ob.put("image", image);
			ob.put("title", title);
			ob.put("market", market);
			map.add(ob);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), map,
				R.layout.item, new String[] { "image", "title", "market" },
				new int[] { R.id.iv_item_good_list_image,
						R.id.tv_item_good_list_title,
						R.id.tv_item_good_list_market });
		lv.setAdapter(simpleAdapter);
	}

	@Override
	protected int getLayoutResource() {
		// TODO Auto-generated method stub
		return R.layout.activity_information;
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.home_bt_hot:
			ShowHotinfo();
			break;
		case R.id.home_bt_supermarket:
			ShowSupermarket();
			break;
		case R.id.home_bt_economic:
			ShowEconomic();
			break;
		case R.id.home_bt_social:
			ShowSocial();
			break;
		case R.id.home_bt_argproducts:
			ShowArgproduct();
			break;
		default:
			break;
		}
	}

	/**
	 * 显示农产品信息
	 */
	private void ShowArgproduct() {
		switchView(1, "土豆", "天茂市场");
	}

	/**
	 * 显示社会信息
	 */
	private void ShowSocial() {

		switchView(2, "豆芽", "世纪市场");
	}

	/**
	 * 显示经济信息
	 */
	private void ShowEconomic() {

		switchView(3, "竹笋", "正大广场");
	}

	/**
	 * 显示市场信息
	 */
	private void ShowSupermarket() {

		switchView(4, "豆腐", "沃尔玛超市");
	}

	/**
	 * 显示热点信息
	 */
	private void ShowHotinfo() {

		switchView(5, "青椒", "天茂市场");
	}

}
