package com.see.notify;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.see.constant.Constant;
import com.see.examsystemteacher.BaseFragment;
import com.see.examsystemteacher.MainActivity;
import com.see.examsystemteacher.R;

/**
 * Created by see on 2016/11/6.
 */
public class NotifyFragment extends BaseFragment {

    private static final String TAG = "NotifyFragment";

    private ListView listView_Notify;
    private View notifyLayout = null;

    private boolean clicked = false;//记录加号按钮的点击状态，默认为没点击
    private RelativeLayout plus_rl;
    private ImageView plus_im;
    private TextView dishui_tv, guoshui_tv;

    private Animation rotate_anticlockwise, rotate_clockwise, scale_max, scale_min, alpha_button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        notifyLayout = inflater.inflate(R.layout.notify_layout, container, false);
        initView();
        initData();
        setListeners();
        return notifyLayout;
    }


    private void setListeners() {
        // TODO Auto-generated method stub
        plus_im.setOnClickListener(new View.OnClickListener() {
            // 监听加号按钮的点击
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                clicked = !clicked;
                // 两个按钮的显示隐藏
                dishui_tv.setVisibility(clicked ? View.VISIBLE : View.GONE);
                guoshui_tv.setVisibility(clicked ? View.VISIBLE : View.GONE);
                // 加号旋转
                plus_im.startAnimation(clicked ? rotate_anticlockwise
                        : rotate_clockwise);
                // 按钮显示隐藏效果
                dishui_tv.startAnimation(clicked ? scale_max : scale_min);
                guoshui_tv.startAnimation(clicked ? scale_max : scale_min);
                // 背景色的改变
                plus_rl.setBackgroundColor(clicked ? Color
                        .parseColor("#ddffffff") : Color.TRANSPARENT);
                // 背景是否可点击，用于控制Framelayout层下面的视图是否可点击
                plus_rl.setClickable(clicked);
            }
        });

        dishui_tv.setOnClickListener(onClickListener);
        guoshui_tv.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            v.startAnimation(alpha_button);
            plus_im.performClick();
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.currFragTag = Constant.FRAGMENT_FLAG_NOTIFY;
    }

    public void initView() {
        listView_Notify = (ListView) notifyLayout.findViewById(R.id.notify_lv);
        plus_rl = (RelativeLayout) notifyLayout.findViewById(R.id.plus_rl);
        plus_im = (ImageView) notifyLayout.findViewById(R.id.plus_im);
        dishui_tv = (TextView) notifyLayout.findViewById(R.id.dishui_tv);
        guoshui_tv = (TextView) notifyLayout.findViewById(R.id.guoshui_tv);
    }

    public void initData() {
        rotate_anticlockwise = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_anticlockwise);
        rotate_clockwise = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_clockwise);
        scale_max = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_max);
        scale_min = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_min);
        alpha_button = AnimationUtils.loadAnimation(getActivity(), R.anim.alpha_button);


    }

    public  boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (dishui_tv.getVisibility() == View.VISIBLE && keyCode == KeyEvent.KEYCODE_BACK) {
            plus_im.performClick();

        }
        return true;
    }

}
