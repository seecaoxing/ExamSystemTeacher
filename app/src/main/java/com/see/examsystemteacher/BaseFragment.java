package com.see.examsystemteacher;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.see.fragment.classes.ClassFragment;
import com.see.constant.Constant;
import com.see.fragment.notify.NotifyFragment;
import com.see.fragment.personal.PersonalFragment;

/**
 * Created by see on 2016/11/4.
 */

public class BaseFragment extends Fragment {
    private static final String TAG = "BaseFragment";
    protected FragmentManager mFragmentManager = null;
    protected FragmentTransaction mFragmentTransaction = null;

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
        Log.i(TAG, "onAttach...");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate...");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        Log.i(TAG, "onCreateView...");
//		View v = inflater.inflate(R.layout.messages_layout, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        Log.i(TAG, "onActivityCreated...");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        Log.i(TAG, "onStart...");
        super.onStart();
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        Log.i(TAG, "onResume...");
        super.onResume();
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        Log.i(TAG, "onPause...");
        super.onPause();
    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        Log.i(TAG, "onStop...");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        // TODO Auto-generated method stub
        Log.i(TAG, "onDestroyView...");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        Log.i(TAG, "onDestroy...");
        super.onDestroy();
    }

    public static BaseFragment newInstance(Context context, String tag) {
        BaseFragment baseFragment = null;
        if (TextUtils.equals(tag, Constant.FRAGMENT_FLAG_NOTIFY)) {
            baseFragment = new NotifyFragment();
        } else if (TextUtils.equals(tag, Constant.FRAGMENT_FLAG_CLASS)) {
            baseFragment = new ClassFragment();
        } else if (TextUtils.equals(tag, Constant.FRAGMENT_FLAG_PERSONAL)) {
            baseFragment = new PersonalFragment();
        }

        return baseFragment;

    }

}
