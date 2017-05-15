package com.see.ui;

/**
 * Created by see on 2016/11/4.
 */

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.see.constant.Constant;
import com.see.examsystemteacher.R;

import java.util.ArrayList;
import java.util.List;


public class BottomControlPanel extends RelativeLayout implements View.OnClickListener {
    private static final String TAG = "BottomControlPanel";
    private Context mContext;
    private ImageText mNotifyBtn = null;
    private ImageText mClassBtn = null;
    private ImageText mPersonalBtn = null;
    private int DEFALUT_BACKGROUND_COLOR = Color.rgb(243, 243, 243); //Color.rgb(192, 192, 192)
    private BottomPanelCallback mBottomCallback = null;
    private List<ImageText> viewList = new ArrayList<ImageText>();

    public interface BottomPanelCallback {
        public void onBottomPanelClick(int itemId);
    }

    public BottomControlPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onFinishInflate() {
        // TODO Auto-generated method stub
        super.onFinishInflate();
        mNotifyBtn = (ImageText) findViewById(R.id.btn_notify);
        mClassBtn = (ImageText) findViewById(R.id.btn_class);
        mPersonalBtn = (ImageText) findViewById(R.id.btn_personal);
        setBackgroundColor(DEFALUT_BACKGROUND_COLOR);
        viewList.add(mNotifyBtn);
        viewList.add(mClassBtn);
        viewList.add(mPersonalBtn);

    }

    public void initBottomPanel() {
        if (mNotifyBtn != null) {
            mNotifyBtn.setImage(R.drawable.notify_unselect);
            mNotifyBtn.setText("通知");
        }
        if (mClassBtn != null) {
            mClassBtn.setImage(R.drawable.class_unselect);
            mClassBtn.setText("班级");
        }
        if (mPersonalBtn != null) {
            mPersonalBtn.setImage(R.drawable.personal_unselect);
            mPersonalBtn.setText("个人中心");
        }

        setBtnListener();

    }

    private void setBtnListener() {
        int num = this.getChildCount();
        for (int i = 0; i < num; i++) {
            View v = getChildAt(i);
            if (v != null) {
                v.setOnClickListener(this);
            }
        }
    }

    public void setBottomCallback(BottomPanelCallback bottomCallback) {
        mBottomCallback = bottomCallback;
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        initBottomPanel();
        int index = -1;
        switch (v.getId()) {
            case R.id.btn_notify:
                index = Constant.BTN_FLAG_NOTIFY;
                mNotifyBtn.setChecked(Constant.BTN_FLAG_NOTIFY);
                break;
            case R.id.btn_class:
                index = Constant.BTN_FLAG_CLASS;
                mClassBtn.setChecked(Constant.BTN_FLAG_CLASS);
                break;
            case R.id.btn_personal:
                index = Constant.BTN_FLAG_PERSONAL;
                mPersonalBtn.setChecked(Constant.BTN_FLAG_PERSONAL);
                break;
            default:
                break;
        }
        if (mBottomCallback != null) {
            mBottomCallback.onBottomPanelClick(index);
        }
    }

    public void defaultBtnChecked() {
        if (mNotifyBtn != null) {
            mNotifyBtn.setChecked(Constant.BTN_FLAG_NOTIFY);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        // TODO Auto-generated method stub
        super.onLayout(changed, left, top, right, bottom);
        layoutItems(left, top, right, bottom);
    }


    /**
     * 最左边和最右边的view由母布局的padding进行控制位置。这里需对第2、3个view的位置重新设置
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    private void layoutItems(int left, int top, int right, int bottom) {

        //TODO 为什么layoutItems会循环执行
        int n = getChildCount();
        //Toast.makeText(context,"获得父view的child个数"+n,Toast.LENGTH_SHORT).show();
        if (n == 0) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        Log.i("caoxing", "paddingLeft = " + paddingLeft + " paddingRight = " + paddingRight);

        int width = right - left;
        int height = bottom - top;
        int averageWidth = width / n;
        Log.i("caoxing", "width = " + width + " height = " + height);
        int allViewWidth = 0;
        for (int i = 0; i < n; i++) {
            //   Toast.makeText(context,"底部导航栏各个item宽度"+n,Toast.LENGTH_SHORT).show();
            View v = getChildAt(i);
            Log.i("caoxing", "v.getWidth() = " + v.getWidth());
            allViewWidth += v.getWidth();
        }
        //每个btn之间间隔的距离
        int blankWidth = (width - allViewWidth - paddingLeft - paddingRight) / (n - 1);
        Log.i("caoxing", "blankV = " + blankWidth);

        for (int i = 0; i <= n - 1; i++) {
            LayoutParams parsms = (LayoutParams) viewList.get(i).getLayoutParams();
            parsms.width = averageWidth;
//          parsms.leftMargin = blankWidth;//使各个按钮间没有间隔，用户点击时更加灵敏
            viewList.get(i).setLayoutParams(parsms);
        }
    }

}