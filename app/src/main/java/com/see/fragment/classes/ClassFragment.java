package com.see.fragment.classes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.see.activity.ClassListViewItemClickActivity;
import com.see.constant.Constant;
import com.see.examsystemteacher.BaseFragment;
import com.see.examsystemteacher.MainActivity;
import com.see.examsystemteacher.R;
import com.see.ui.XListView.widget.XListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by see on 2016/11/6.
 */
public class ClassFragment extends BaseFragment {
    private static final String TAG = "ClassFragment";

    private XListView listView_Class;
    private View classLayout = null;
    private ClassListAdapter classListAdapter;
    private TextView test_tv;
    private Context context;
    private TextView addclass;
    private List<String> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (classLayout == null) {
            classLayout = inflater.inflate(R.layout.class_layout, container, false);
            context = getActivity();
            initView();
            initData();
            setListeners();
        }
        // 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) classLayout.getParent();
        if (parent != null) {
            parent.removeView(classLayout);
        }
        return classLayout;
    }

    private void initData() {

        for (int i = 0; i < 20; i++) {
            list.add("班级管理" + i);
        }
        classListAdapter.notifyDataSetChanged();

    }

    private void initView() {

        addclass = (TextView) getActivity().findViewById(R.id.right_title);
        listView_Class = (XListView) classLayout.findViewById(R.id.class_lv);

        listView_Class.setPullRefreshEnable(false);
        listView_Class.setPullLoadEnable(false);
        listView_Class.setAutoLoadEnable(false);
        listView_Class.setRefreshTime(getTime());
        classListAdapter = new ClassListAdapter(context, list);
        listView_Class.setAdapter(classListAdapter);
        listView_Class.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, ClassListViewItemClickActivity.class);
                startActivity(intent);
            }
        });
        listView_Class.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //NetRequeste


                        onLoad();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //NetRequeste


                        onLoad();
                    }
                }, 2000);
            }
        });


    }

    public void setListeners() {

    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.currFragTag = Constant.FRAGMENT_FLAG_CLASS;
    }

    private void onLoad() {
        listView_Class.stopRefresh();
        listView_Class.stopLoadMore();
        listView_Class.setRefreshTime(getTime());
    }

    private String getTime() {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date());
    }
}
