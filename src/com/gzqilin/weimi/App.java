package com.gzqilin.weimi;

import android.app.Application;

public class App extends Application {

	public static int SCREEN_WIDTH; // 屏幕 宽度
	public static int SCREEN_HEIGHT; // 屏幕 高度
	public static float SCREEN_DENSITY; // 屏幕 密度

	public static String appName = "WeiMi"; // app 名称

	public static App appContext;

	@Override
	public void onCreate() {
		super.onCreate();
		appContext = this;
		SCREEN_WIDTH = getResources().getDisplayMetrics().widthPixels;
		SCREEN_HEIGHT = getResources().getDisplayMetrics().heightPixels;
		SCREEN_DENSITY = getResources().getDisplayMetrics().density;

//		TCAgent.init(this);
		//程序崩溃处理，写日志，发邮件
//		CrashHandler crashHandler = CrashHandler.getInstance();
//		crashHandler.init(getApplicationContext());
	}

}
