package com.see.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.see.examsystemteacher.R;

/**
 * Created by see on 2017/5/9.
 */
public class AddClassActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addclass_layout);
    }

    public static void launcherAddClassActivity(Context context) {
        Intent intent = new Intent(context, AddClassActivity.class);
        context.startActivity(intent);
    }
}
