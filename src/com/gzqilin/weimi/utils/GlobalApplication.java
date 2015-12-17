package com.gzqilin.weimi.utils;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;

/**
 * Application基类，需在AndroidManifest.xml中的<application>节点的android:name中写明
 *
 * @author lsh
 * @version 2014-3-18
 */
public class GlobalApplication extends Application {
    private LinkedList<Activity> activities = new LinkedList<Activity>();
    private static GlobalApplication instance = null;

    public static synchronized GlobalApplication getInstance() {
        if (!(instance instanceof GlobalApplication)) {
            instance = new GlobalApplication();
        }
        return instance;
    }

    /**
     * 注册Activity以便集中“finish()”
     *
     * @param a
     */
    public void addActivity(Activity a) {
        activities.add(a);
    }

    /**
     * 完全退出软件
     */
    public void exit() {
        for (Activity activity : activities) {
            activity.finish();
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);//narmal exit applicatin
    }

}
