package com.see.ui;

/**
 * Created by see on 2016/11/4.
 */

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.see.constant.Constant;
import com.see.examsystemteacher.R;

public class HeadControlPanel extends RelativeLayout {

    private static final String TAG = "HeadControlPanel";

    private Context mContext;
    private TextView mMidleTitle;
    private TextView mRightTitle;
    private static final float middle_title_size = 18f;
    private static final float right_title_size = 13f;
    private static final int default_background_color = Color.rgb(23, 124, 202);

    public HeadControlPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onFinishInflate() {
        // TODO Auto-generated method stub
        super.onFinishInflate();
        mMidleTitle = (TextView) findViewById(R.id.midle_title);
        mRightTitle = (TextView) findViewById(R.id.right_title);
        setBackgroundColor(default_background_color);
    }

    public void initHeadPanel() {

        if (mMidleTitle != null) {
            setMiddleTitle(Constant.FRAGMENT_FLAG_NOTIFY);
        }
        if (mRightTitle != null) {
            setRightTitle(Constant.FRAGMENT_FLAG_SENDMESSAGE);

        }
    }

    public void setMiddleTitle(String s) {
        mMidleTitle.setText(s);
        mMidleTitle.setTextSize(middle_title_size);
    }

    public void setRightTitle(String s) {
        mRightTitle.setText(s);
        mRightTitle.setTextSize(right_title_size);
    }


}