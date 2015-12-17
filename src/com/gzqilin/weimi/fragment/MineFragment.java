package com.gzqilin.weimi.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.gzqilin.weimi.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by Administrator on 2015/12/16.
 *
 * @author OY
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {

    @ViewInject(R.id.mine_message)
    private LinearLayout message;
    @ViewInject(R.id.mine_collect)
    private LinearLayout collect;
    @ViewInject(R.id.mine_village)
    private RelativeLayout village;
    @ViewInject(R.id.mine_set)
    private RelativeLayout set;
    
    @Override
    protected int getLayoutResource() {
        return R.layout.mine_frag_laout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewUtils.inject(this, view);
    }

    @OnClick({R.id.mine_message, R.id.mine_collect, R.id.mine_village,
            R.id.mine_set})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_message:
                break;
            case R.id.mine_collect:
                break;
            case R.id.mine_village:
                break;
            case R.id.mine_set:
                break;
        }
    }
}
