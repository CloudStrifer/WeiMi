package com.gzqilin.weimi.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;

import java.io.File;
import java.io.Serializable;

/**
 * 界面跳转及数据传递工具类
 *
 * @author lsh
 * @version 2014-4-21
 */
public class IntentUtils {
    public static String EXTRA_TAG = "intent_extra";

    /**
     * 拨打电话
     *
     * @param phone 电话号码
     */
    public static boolean call(Context context, String phone) {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phone));
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    /**
     * 发送短信
     *
     * @param text 短信内容
     */
    public static boolean sms(Context context, String text) {
        try {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:"));
            intent.putExtra("sms_body", text);
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    /**
     * 发送邮件
     *
     * @param text 邮件内容
     */
    public static void email(Context context, String text) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "");
        intent.putExtra(Intent.EXTRA_CC, new String[]
                {"1032694760@qq.com"});
        intent.putExtra(Intent.EXTRA_TEXT, text);
        context.startActivity(Intent.createChooser(intent, "选择邮件客户端"));
    }

    /**
     * 分享文本内容
     *
     * @param text 文本内容
     */
    public static void share(Context context, String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(Intent.createChooser(intent, "请选择分享方式："));
    }

    /**
     * 打开网址
     *
     * @param url 网址
     */
    public static boolean openUrl(Context context, String url) {
        try {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(Uri.decode(url)));// decode方法防止中文乱码
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 打开文件
     *
     * @param filePath 文件路径
     */
    public static boolean openFile(Context context, Class<? extends Activity> clazz, String filePath) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            if (clazz != null) {
                intent.setClass(context, clazz);
            }
            filePath = Uri.decode(filePath);// 防止中文乱码
            // 若不带协议“file://”，将会触发“ActivityNotFoundException”
            Uri uri = Uri.fromFile(new File(filePath));
            intent.setData(uri);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 打开文件
     *
     * @param filePath 文件路径
     */
    public static boolean openFile(Context context, String filePath) {
        return openFile(context, null, filePath);
    }

    /**
     * 启动第三方应用
     *
     * @param packageName 所要打开的程序包名
     * @param classPath   所要打开的程序包名+主运行类名
     */
    public static boolean openApp(Activity current, String packageName, String classPath) {
        try {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setComponent(new ComponentName(packageName, classPath));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            current.startActivity(intent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 启动新的Activity，不传递任何参数
     *
     * @param context
     * @param target
     */
    public static void startActivity(Context context, Class<?> target) {
        Intent intent = new Intent(context, target);
        context.startActivity(intent);
    }

    /**
     * 启动新Activity，并传递字符串
     */
    public static void startActivity(Context context, Class<?> target, String str) {
        Intent intent = new Intent(context, target);
        intent.putExtra(EXTRA_TAG, str);
        context.startActivity(intent);
    }

    /**
     * 启动Activity，并传递通过Bundle绑定的数据
     */
    public static void startActivity(Context context, Class<?> target, Bundle bundle) {
        Intent intent = new Intent(context, target);
        intent.putExtra(EXTRA_TAG, bundle);
        context.startActivity(intent);
    }

    /**
     * 启动新Activity，并传递实现了Parcelable接口的数据，如Bitmap
     */
    public static void startActivity(Context context, Class<?> target, Parcelable parcel) {
        Intent intent = new Intent(context, target);
        intent.putExtra(EXTRA_TAG, parcel);
        context.startActivity(intent);
    }

    /**
     * 启动新Activity，并传递实现了Serializable接口的数据，如：List<T>中的T必须实现Serializable接口
     */
    public static void startActivity(Context context, Class<?> target, Serializable serialize) {
        Intent intent = new Intent(context, target);
        intent.putExtra(EXTRA_TAG, serialize);
        context.startActivity(intent);
    }

    /**
     * 获取从第三方浏览器传来的文件路径
     *
     * @param activity
     * @return mybe return null
     */
    public static String getPath(Activity activity) {
        Intent intent = activity.getIntent();
        String action = intent.getAction();
        if (action == null) {
            return null;
        }
        if (action.equals(Intent.ACTION_VIEW)) {
            Uri uri = intent.getData();
            return uri.getPath();
        }
        return null;
    }

    /**
     * 获取启动Activity时传递的字符串
     *
     * @param activity
     * @return mybe return null
     */
    public static String getString(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null) {
            return intent.getStringExtra(EXTRA_TAG);
        }
        return null;
    }

    /**
     * 获取启动Activity时通过Bundle绑定的数据
     *
     * @param activity
     * @return mybe return null
     */
    public static Bundle getBundle(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null) {
            // 可能因java.lang.ClassCastException而返回null
            return intent.getBundleExtra(EXTRA_TAG);
        }
        return null;
    }

    /**
     * 获取启动Activity时传递的实现了Parcelable接口的数据对象，如“Bitmap”
     *
     * @param activity
     * @return mybe return null
     */
    public static Parcelable getParcelable(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null) {
            return intent.getParcelableExtra(EXTRA_TAG);
        }
        return null;
    }

    /**
     * 获取启动Activity时传递的实现了Serializable接口的数据对象，如“List”
     *
     * @param activity
     * @return mybe return null
     */
    public static Serializable getSerializable(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null) {
            return intent.getSerializableExtra(EXTRA_TAG);
        }
        return null;
    }

}
