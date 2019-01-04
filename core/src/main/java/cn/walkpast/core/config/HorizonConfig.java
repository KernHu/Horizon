package cn.walkpast.core.config;

import android.app.Application;

import cn.walkpast.utils.HorizonUtils;
import cn.walkpast.utils.ToastUtils;

/**
 * author: Kern Hu
 * email: sky580@126.com
 * data_time: 2019/1/4 11:22 PM
 * describe: This is...
 */

public class HorizonConfig {


    private static HorizonConfig mHorizonConfig;

    private Application mApplication;
    private int mToastBgc;
    private int mToastMsgColor;


    public static HorizonConfig getInstance() {

        if (mHorizonConfig == null) {
            mHorizonConfig = new HorizonConfig();
        }

        return mHorizonConfig;

    }

    public Application getApplication() {
        return mApplication;
    }

    public HorizonConfig setApplication(Application application) {
        mApplication = application;
        return this;
    }

    public int getToastBgc() {
        return mToastBgc;
    }

    public HorizonConfig setToastBgc(int toastBgc) {
        mToastBgc = toastBgc;
        return this;
    }

    public int getToastMsgColor() {
        return mToastMsgColor;
    }

    public HorizonConfig setToastMsgColor(int toastMsgColor) {
        mToastMsgColor = toastMsgColor;
        return this;
    }

    public void build(){


        //初始化工具类
        HorizonUtils.init(getApplication());
        ToastUtils.setBgColor(getToastBgc());
        ToastUtils.setBgColor(getToastMsgColor());
    }
}