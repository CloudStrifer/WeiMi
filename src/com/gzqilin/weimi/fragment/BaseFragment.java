package com.gzqilin.weimi.fragment;

import com.gzqilin.weimi.R;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Fragment的基类
 * @author lsh
 */
public abstract class BaseFragment extends Fragment {
    protected Activity activity;
    protected View view;
    private static Toast toast; 
    protected abstract int getLayoutResource();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
     }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //界面布局
        if (view == null) {
            try {
                view = inflater.inflate(getLayoutResource(), container, false);
            } catch (Exception e) {
                view = new View(activity);
            }
        }
        //缓存的view如果有parent，则需要从parent中删除，不然会发生异常
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
    
    /**
     * 打印Toast
     */
    public void showToast(String text) {
        if (toast != null) {
            toast.cancel();// 显示之前先取消之前显示的
        }
        TextView textView = new TextView(activity);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(layoutParams);
//        textView.setBackgroundColor(Color.argb(240, 68, 68, 68));
        textView.setBackgroundResource(R.drawable.toast_bg);
        textView.setTextColor(Color.WHITE);
        textView.setPadding(25, 15, 25, 15);
        textView.setText(text);
        toast = new Toast(activity);
        toast.setView(textView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
    
}
