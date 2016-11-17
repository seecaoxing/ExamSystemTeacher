package com.see.loginandregister;

import android.app.Activity;
import android.os.Bundle;

import com.see.examsystemteacher.R;

/**
 * Created by see on 2016/11/3.
 */
public class Login extends Activity{
    private static final String TAG="Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
}
