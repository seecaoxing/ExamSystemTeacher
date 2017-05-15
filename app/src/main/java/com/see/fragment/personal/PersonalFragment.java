package com.see.fragment.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.see.examsystemteacher.BaseFragment;
import com.see.constant.Constant;
import com.see.examsystemteacher.MainActivity;
import com.see.examsystemteacher.R;

/**
 * Created by see on 2016/11/6.
 */
public class PersonalFragment extends BaseFragment {


    private static final String TAG = "PersonalFragment";
    private View personalLayout;
    private RelativeLayout personalInformation_rl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        personalLayout = inflater.inflate(R.layout.personal_layout, container, false);
        initView();
        setListeners();

        return personalLayout;
    }

    private void setListeners() {

        personalInformation_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), PersonalInformation.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        personalInformation_rl = (RelativeLayout) personalLayout.findViewById(R.id.personalInformation_rl);
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.currFragTag = Constant.FRAGMENT_FLAG_PERSONAL;
    }
}
