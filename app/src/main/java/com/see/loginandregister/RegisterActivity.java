package com.see.loginandregister;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.see.examsystemteacher.R;

/**
 * Created by see on 2016/11/3.
 */
public class RegisterActivity extends Activity{
    private static final String TAG = "RegisterActivity";
    private RadioGroup userTypeRg;
    private RadioButton studentRb, teacherRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initView();
        setListener();
    }

    private void setListener() {
        userTypeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==studentRb.getId()){


                }else if (checkedId==teacherRb.getId()){

                }
            }
        });




    }

    public void initView() {
        userTypeRg  = (RadioGroup) findViewById(R.id.usertype_rg);
        studentRb = (RadioButton) findViewById(R.id.usertype_student_rb);
        teacherRb = (RadioButton) findViewById(R.id.usertype_teacher_rb);
        studentRb.setChecked(true);
    }


}
