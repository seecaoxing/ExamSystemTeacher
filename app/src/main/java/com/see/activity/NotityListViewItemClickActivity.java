package com.see.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.see.bean.NotifyBean;
import com.see.examsystemteacher.R;

/**
 * Created by see on 2017/4/9.
 */
public class NotityListViewItemClickActivity extends Activity {
    private TextView notify_lv_item_click_layout_title,
            notify_lv_item_click_layout_time,
            notify_lv_item_click_layout_author,
            notify_lv_item_click_layout_content;
    private NotifyBean notifyBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifylistviewitemclick_layout);
        initView();
        initData();

    }

    public void initData() {
        notifyBean = (NotifyBean) getIntent().getSerializableExtra("notify_item_content");
        notify_lv_item_click_layout_title.setText(notifyBean.getTitle());
        notify_lv_item_click_layout_time.setText(notifyBean.getTime());
        notify_lv_item_click_layout_author.setText(notifyBean.getAuthor());
        notify_lv_item_click_layout_content.setText(notifyBean.getContent());

    }


    public void initView() {
        notify_lv_item_click_layout_title = (TextView) findViewById(R.id.notify_lv_item_click_layout_title);
        notify_lv_item_click_layout_time = (TextView) findViewById(R.id.notify_lv_item_click_layout_time);
        notify_lv_item_click_layout_author = (TextView) findViewById(R.id.notify_lv_item_click_layout_author);
        notify_lv_item_click_layout_content = (TextView) findViewById(R.id.notify_lv_item_click_layout_content);

    }

    public static void launcherNotityListViewItemClickActivity(Context context) {
        Intent intent = new Intent(context, NotityListViewItemClickActivity.class);
        context.startActivity(intent);
    }
}
