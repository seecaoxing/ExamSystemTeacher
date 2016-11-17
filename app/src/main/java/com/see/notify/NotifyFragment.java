package com.see.notify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.see.examsystemteacher.BaseFragment;
import com.see.constant.Constant;
import com.see.examsystemteacher.MainActivity;
import com.see.examsystemteacher.R;

/**
 * Created by see on 2016/11/6.
 */
public class NotifyFragment extends BaseFragment {

    private static final String TAG = "NotifyFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View notifyLayout = inflater.inflate(R.layout.notify_layout, container, false);
        return notifyLayout;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.currFragTag = Constant.FRAGMENT_FLAG_NOTIFY;
    }
}
