package com.see.personal;

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
public class PersonalFragment extends BaseFragment {


    private static final String TAG = "PersonalFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View personalLayout = inflater.inflate(R.layout.personal_layout, container, false);
        return personalLayout;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.currFragTag = Constant.FRAGMENT_FLAG_PERSONAL;
    }
}
