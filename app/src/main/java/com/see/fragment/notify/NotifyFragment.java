package com.see.fragment.notify;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.see.activity.NotifyBannerItenClickActivity;
import com.see.activity.NotityListViewItemClickActivity;
import com.see.bean.NotifyBean;
import com.see.constant.Constant;
import com.see.examsystemteacher.BaseFragment;
import com.see.examsystemteacher.MainActivity;
import com.see.examsystemteacher.R;
import com.see.ui.XListView.widget.XListView;
import com.see.util.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by see on 2016/11/6.
 */
public class NotifyFragment extends BaseFragment {

    private static final String TAG = "NotifyFragment";

    private XListView listView_Notify;
    private View notifyLayout = null;
    private NotifyListAdapter notifyListAdapter;

    private TextView test_tv;

    private TextView sendMessage;
    private Context context;
    public static List<NotifyBean> listContent = new ArrayList<>();
    private List<String> list = new ArrayList<>();


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x11) {
                notifyListAdapter.notifyDataSetChanged();
            } else if (msg.what == 0x12) {
                notifyListAdapter.notifyDataSetChanged();
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (notifyLayout == null) {
            notifyLayout = inflater.inflate(R.layout.notify_layout, container, false);
            context = getActivity();
            initView();
            initData();
            setListeners();
        }
// 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) notifyLayout.getParent();
        if (parent != null) {
            parent.removeView(notifyLayout);
        }
        return notifyLayout;
    }

    private void setListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.currFragTag = Constant.FRAGMENT_FLAG_NOTIFY;
    }


    public void initView() {

        Banner banner = (Banner) notifyLayout.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        List<String> images = new ArrayList<>();
        images.add("http://img.ivsky.com/img/tupian/pre/201308/30/yueyuanzhiye-004.jpg");
        images.add("http://img.ivsky.com/img/tupian/pre/201308/30/yueyuanzhiye-005.jpg");
        images.add("http://img.ivsky.com/img/tupian/pre/201308/30/yueyuanzhiye-006.jpg");
        images.add("http://img.ivsky.com/img/tupian/pre/201308/30/yueyuanzhiye-007.jpg");
        images.add("http://img.ivsky.com/img/tupian/pre/201308/30/yueyuanzhiye-008.jpg");
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(context, NotifyBannerItenClickActivity.class);
                startActivity(intent);
            }
        });

        sendMessage = (TextView) getActivity().findViewById(R.id.right_title);


        listView_Notify = (XListView) notifyLayout.findViewById(R.id.notify_lv);
        listView_Notify.setPullRefreshEnable(true);
        listView_Notify.setPullLoadEnable(true);
        listView_Notify.setAutoLoadEnable(true);
        listView_Notify.setRefreshTime(getTime());
        notifyListAdapter = new NotifyListAdapter(context, listContent);
        listView_Notify.setAdapter(notifyListAdapter);
        listView_Notify.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, NotityListViewItemClickActivity.class);
                intent.putExtra("notify_item_content", listContent.get(position-1));
                startActivity(intent);
            }
        });

        listView_Notify.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //当后台有数据后应该每次的刷新都是重新加载数据
                        notifyListAdapter = new NotifyListAdapter(context, listContent);
                        listView_Notify.setAdapter(notifyListAdapter);


//                        List<NotifyBean> templist = new ArrayList<>();
//                        for (int i = 0; i < 5; i++) {
//                            NotifyBean notifyBean = new NotifyBean();
//                            notifyBean.setContent("下拉刷新内容" + i);
//                            notifyBean.setAuthor("下拉刷新小名" + i);
//                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
//                            Date curDate = new Date(System.currentTimeMillis());//获取当前时间
//                            String str = formatter.format(curDate);
//                            notifyBean.setTime(str);
//                            notifyBean.setTitle("下拉刷新标题" + i);
//                            templist.add(0, notifyBean);
//                        }
//
//                        notifyListAdapter.setRefrashData(templist);
                        onLoad();
                        Message message = new Message();
                        message.what = 0x11;
                        handler.handleMessage(message);
                    }
                }, 2000);

            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<NotifyBean> templist = new ArrayList<>();
                        for (int i = 0; i < 5; i++) {
                            NotifyBean notifyBean = new NotifyBean();
                            notifyBean.setContent("上拉加载内容" + i);
                            notifyBean.setAuthor("上拉加载小名" + i);
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
                            Date curDate = new Date(System.currentTimeMillis());//获取当前时间
                            String str = formatter.format(curDate);
                            notifyBean.setTime(str);
                            notifyBean.setTitle("上拉加载标题" + i);
                            templist.add(notifyBean);
                        }
                        notifyListAdapter.setLoadMoreData(templist);
                        onLoad();
                        Message message = new Message();
                        message.what = 0x11;
                        handler.handleMessage(message);
                    }
                }, 2000);
            }
        });
    }

    public void initData() {

        for (int i = 0; i < 20; i++) {
            NotifyBean notifyBean = new NotifyBean();
            notifyBean.setContent("内容" + i);
            notifyBean.setAuthor("小名" + i);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
            Date curDate = new Date(System.currentTimeMillis());//获取当前时间
            String str = formatter.format(curDate);
            notifyBean.setTime(str);
            notifyBean.setTitle("标题" + i);
            listContent.add(notifyBean);
        }
        notifyListAdapter.notifyDataSetChanged();

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        return false;
    }

    private void onLoad() {
        listView_Notify.stopRefresh();
        listView_Notify.stopLoadMore();
        listView_Notify.setRefreshTime(getTime());
    }

    private String getTime() {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date());
    }
}
