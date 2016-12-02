package com.see.examsystemteacher;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Toast;

import com.see.constant.Constant;
import com.see.notify.NotifyFragment;
import com.see.ui.BottomControlPanel;
import com.see.ui.HeadControlPanel;


public class MainActivity extends Activity implements BottomControlPanel.BottomPanelCallback {

    private static final String TAG = "MainActivity";
    BottomControlPanel bottomPanel = null;
    HeadControlPanel headPanel = null;

    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction = null;

/*	private MessageFragment messageFragment;
    private ContactsFragment contactsFragment;
	private NewsFragment newsFragment;
	private SettingFragment settingFragment;*/

    public static String currFragTag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        initUI();
        fragmentManager = getFragmentManager();
        setDefaultFirstFragment(Constant.FRAGMENT_FLAG_NOTIFY);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    private void initUI() {
        bottomPanel = (BottomControlPanel) findViewById(R.id.bottom_layout);
        if (bottomPanel != null) {

            bottomPanel.initBottomPanel();
            bottomPanel.setBottomCallback(this);
        }
        headPanel = (HeadControlPanel) findViewById(R.id.head_layout);
        if (headPanel != null) {
            headPanel.initHeadPanel();
        }
    }

    /* 处理BottomControlPanel的回调
     * @see org.yanzi.ui.BottomControlPanel.BottomPanelCallback#onBottomPanelClick(int)
     */
    @Override
    public void onBottomPanelClick(int itemId) {
        // TODO Auto-generated method stub
        String tag = "";
        if ((itemId & Constant.BTN_FLAG_NOTIFY) != 0) {
            tag = Constant.FRAGMENT_FLAG_NOTIFY;
        } else if ((itemId & Constant.BTN_FLAG_CLASS) != 0) {
            tag = Constant.FRAGMENT_FLAG_CLASS;
        } else if ((itemId & Constant.BTN_FLAG_PERSONAL) != 0) {
            tag = Constant.FRAGMENT_FLAG_PERSONAL;
        }
        setTabSelection(tag); //切换Fragment
        headPanel.setMiddleTitle(tag);//切换标题
    }

    private void setDefaultFirstFragment(String tag) {
        Log.i("yan", "setDefaultFirstFragment enter... currFragTag = " + currFragTag);
        setTabSelection(tag);
        bottomPanel.defaultBtnChecked();
        Log.i("yan", "setDefaultFirstFragment exit...");
    }

    private void commitTransactions(String tag) {
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
            currFragTag = tag;
            fragmentTransaction = null;
        }
    }

    private FragmentTransaction ensureTransaction() {
        if (fragmentTransaction == null) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        }
        return fragmentTransaction;

    }

    private void attachFragment(int layout, Fragment f, String tag) {
        if (f != null) {
            if (f.isDetached()) {
                ensureTransaction();
                fragmentTransaction.attach(f);

            } else if (!f.isAdded()) {
                ensureTransaction();
                fragmentTransaction.add(layout, f, tag);
            }
        }
    }

    private Fragment getFragment(String tag) {

        Fragment f = fragmentManager.findFragmentByTag(tag);

        if (f == null) {
            Toast.makeText(getApplicationContext(), "fragment = null tag = " + tag, Toast.LENGTH_SHORT).show();
            f = BaseFragment.newInstance(getApplicationContext(), tag);
        }
        return f;

    }

    private void detachFragment(Fragment f) {

        if (f != null && !f.isDetached()) {
            ensureTransaction();
            fragmentTransaction.detach(f);
        }
    }

    /**
     * 切换fragment
     *
     * @param tag
     */
    private void switchFragment(String tag) {
        if (TextUtils.equals(tag, currFragTag)) {
            return;
        }
        //把上一个fragment detach掉
        if (currFragTag != null && !currFragTag.equals("")) {
            detachFragment(getFragment(currFragTag));
        }
        attachFragment(R.id.fragment_content, getFragment(tag), tag);
        commitTransactions(tag);
    }

    /**
     * 设置选中的Tag
     *
     * @param tag
     */
    public void setTabSelection(String tag) {
        // 开启一个Fragment事务
        fragmentTransaction = fragmentManager.beginTransaction();
/*		 if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_MESSAGE)){
           if (messageFragment == null) {
				messageFragment = new MessageFragment();
			}

		}else if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_CONTACTS)){
			if (contactsFragment == null) {
				contactsFragment = new ContactsFragment();
			}

		}else if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_NEWS)){
			if (newsFragment == null) {
				newsFragment = new NewsFragment();
			}

		}else if(TextUtils.equals(tag,Constant.FRAGMENT_FLAG_SETTING)){
			if (settingFragment == null) {
				settingFragment = new SettingFragment();
			}
		}else if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_SIMPLE)){
			if (simpleFragment == null) {
				simpleFragment = new SimpleFragment();
			}

		}*/
        switchFragment(tag);

    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        currFragTag = "";
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        Fragment f = getFragment(currFragTag);
        if ( f instanceof NotifyFragment) {

            ((NotifyFragment) f).onKeyDown(keyCode,event);
        }
        return super.onKeyDown(keyCode, event);
    }

}