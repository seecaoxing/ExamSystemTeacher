package com.see.constant;

/**
 * Created by see on 2016/11/4.
 */
public class Constant {

    private static final String TAG = "Constant";
    //Btn的标识
    public static final int BTN_FLAG_NOTIFY = 0x01;
    public static final int BTN_FLAG_CLASS = 0x01 << 1;
    public static final int BTN_FLAG_PERSONAL = 0x01 << 2;

    //Fragment的标识
    public static final String FRAGMENT_FLAG_NOTIFY = "通知";
    public static final String FRAGMENT_FLAG_CLASS = "班级";
    public static final String FRAGMENT_FLAG_PERSONAL = "个人中心";
    public static final String FRAGMENT_FLAG_SIMPLE = "simple";

    public static final String FRAGMENT_FLAG_SENDMESSAGE = "发布消息";


    public static final String FRAGMENT_FLAG_ADDCLASS = "添加班级";
    public static final String FRAGMENT_FLAG_refrash = "刷新";



}