package com.gzqilin.weimi.activity;

import com.gzqilin.weimi.R;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

/**
 * 农业产品详细信息
 *
 * @author oy
 */
public class ArgproductActivity extends BaseActivity {

	private TextView title;
	private TextView content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_argproduct);
		init();

	}

	private void init() {
		title = (TextView) findViewById(R.id.arg_title);
		content = (TextView) findViewById(R.id.arg_content);
		title.setText("互联网＋农业≠电商下乡");
		content.setText("	  互联网＋农业”，早已站上风口一年来，面对未来蓝海，不管是淘宝、京东等巨头还是赶街等新秀，"
				+ "从集体“刷墙”到设置服务站点再到开办电商产业园，电商企业争相下乡“跑马圈    一年来，面对未来蓝海，不管是淘宝、"
				+ "京东等巨头还是赶街等新秀，从集体“刷墙”到设置服务站点再到开办电商产业园，电商企业争相下乡“跑马圈地”。面对这股"
				+ "劲吹的新风，各地政府也期望借力提升当地经济，打造亮点工程。一时间，人人开网店，村村搞电商，农业电商似乎如火如荼"
				+ "但热闹背后，潜伏着对“互联网＋农业”认识的局限甚至是误区。喧哗之际，各地管理者尤其是农业主管部门该如何面对？"
				+ "互联网＋农业，绝不只是电商下乡。12月4日，全省首次农业信息化工作会议已作出冷静思考。"
				+ "优质农产品搭乘电商快车走俏全国 12月12日零时，西部（濛阳）农产品电商孵化园大屏幕上，数字开始跳动，"
				+ "每秒7单，10分钟成交额就达20184元。金堂红心柚正乘着电商快车销往全国。这是该孵化园联合淘宝四川馆在"
				+ "“双12”发起的营销活动，试水传统农产品批发与电商互动。“农户一斤多赚5毛，一亩多增收5000元。”"
				+ "淘宝四川馆负责人刘渊介绍。就在1个月前，农业电商在四川已展现“魔力”。11月11日，安岳柠檬电商交易额达4900余万元。"
				+ "“全国第二，第一名是褚橙。”安岳县委书记许志勋说。宜宾茶企也战绩不凡：“双11”当天，川红、川茶等6家企业借助一根网线销售1215.49万元。"
				+ "不仅是柠檬、茶叶这样的拳头产品。12月，广汉种粮大户冷小莲通过“买粮网”卖出广汉首单网销大宗粮食，而当地70余户种粮大户已网销5000吨粮食。"
				+ "12月3日，西部·四川内江水产电子商城实体店正式运营，入驻涉渔企业50余家，促成线下鲜鱼交易近亿元。我们的目标是打造四川水产电子商务第一平台。"
				+ "内江农业局负责人表示.");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.argproduct, menu);
		return true;
	}

}
