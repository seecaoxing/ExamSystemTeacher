package com.see.classes;

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
public class ClassFragment extends BaseFragment {
    private static final String TAG = "ClassFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View classLayout = inflater.inflate(R.layout.class_layout, container, false);
        return classLayout;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.currFragTag = Constant.FRAGMENT_FLAG_CLASS;
    }
}
