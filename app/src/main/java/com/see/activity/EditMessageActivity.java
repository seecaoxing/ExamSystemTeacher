package com.see.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.see.bean.NotifyBean;
import com.see.examsystemteacher.R;
import com.see.fragment.notify.NotifyFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by see on 2017/5/9.
 */
public class EditMessageActivity extends Activity {
    EditText editmessage_title, editmessage_content;
    Button editmessage_cancle, editmessage_enter;


    private String editmessage_title_str;
    private String editmessage_content_str;
    private String editmessage_time_str;
    private String editmessage_author_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editmessage_layout);


        initView();
    }

    public void initView() {

        editmessage_title = (EditText) findViewById(R.id.editmessage_theme);
        editmessage_content = (EditText) findViewById(R.id.editmessage_content);
        editmessage_cancle = (Button) findViewById(R.id.editmessage_cancle);
        editmessage_enter = (Button) findViewById(R.id.editmessage_enter);

        editmessage_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNetData();
            }
        });

        editmessage_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void sendNetData(){
        editmessage_title_str = editmessage_title.getText().toString();
        editmessage_content_str = editmessage_content.getText().toString();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        editmessage_time_str = formatter.format(curDate);
        editmessage_author_str = "xiaoxing";


        NotifyBean notifyBean = new NotifyBean();
        notifyBean.setTitle(editmessage_title_str);
        notifyBean.setTime(editmessage_time_str);
        notifyBean.setAuthor(editmessage_author_str);
        notifyBean.setContent(editmessage_content_str);

        NotifyFragment.listContent.add(0,notifyBean);
    }

    public static void launcherEditMessageActivity(Context context) {
        Intent intent = new Intent(context, EditMessageActivity.class);
        context.startActivity(intent);
    }
}
