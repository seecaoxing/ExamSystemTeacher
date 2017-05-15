package com.see.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.see.examsystemteacher.R;

/**
 * Created by see on 2017/4/9.
 */
public class ClassListViewItemClickActivity extends Activity {
    private TextView classlistviewitemclick_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classlistviewitemclick_layout);
        classlistviewitemclick_tv = (TextView) findViewById(R.id.classlistviewitemclick_tv);
        classlistviewitemclick_tv.setText("");
    }

    public static void launcherClassListViewItemClickActivity(Context context) {
        Intent intent = new Intent(context, ClassListViewItemClickActivity.class);
        context.startActivity(intent);
    }
}
