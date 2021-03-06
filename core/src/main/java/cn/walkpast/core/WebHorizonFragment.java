package cn.walkpast.core;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.walkpast.core.config.CoreConfig;
import cn.walkpast.core.config.DownloadConfig;
import cn.walkpast.core.constant.CaptureStrategy;
import cn.walkpast.core.constant.NetworkType;
import cn.walkpast.core.constant.NotificationType;
import cn.walkpast.core.constant.ProgressStyle;
import cn.walkpast.core.constant.Strategy;
import cn.walkpast.core.constant.Theme;
import cn.walkpast.core.indicator.ProgressConfig;

/**
 * Author: Kern
 * Time: 2019/1/27 11:44
 * Description: This is..
 */

public class WebHorizonFragment extends Fragment {

    private Horizon mHorizon;

    public Horizon getHorizon() {
        return mHorizon;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHorizon = Horizon.with(getActivity())
                .setTag("horizon_1")
                .setProgressConfig(ProgressConfig
                        .with(getActivity())
                        .setBackgroundColor(R.color.default_progress_background)
                        .setProgressColor(R.color.default_progress_color)
                        .setHeight(R.dimen.default_progress_height)
                        .setProgressStyle(ProgressStyle.STYLE_HORIZONTAL_TOP)
                        .config()
                )
                .setCoreConfig(CoreConfig
                        .with(getActivity())
                        .setFontSize(16)
                        .setHardwareAccelerated(true)
                        .setPatternlessEnable(false)
                        .setSavePassword(true)
                        .setWakeupEnable(true)
                        .setAdblockPlusEnable(true)
                        .setGeolocationEnalbe(true)
                        .setThemeEnable(true)
                        .setWebContentsDebuggingEnabled(BuildConfig.DEBUG)
                        .setTheme(Theme.THEME_LIGHT)
                        .setStrategy(Strategy.CORE_BOTH_TEXT_IMAGE)
                        .config()
                )
                .setDownloadConfig(DownloadConfig
                        .with(getActivity())
                        .setStoragePath("download")
                        .setNetworkType(NetworkType.NETWORK_MOBILE_AND_WIFI)
                        .setNotificationType(NotificationType.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                        .setTooltipEnable(true)
                        .config()
                )
                .setCaptureStrategy(CaptureStrategy.START_FINISH);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mHorizon != null) {
            mHorizon.onResume();
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        if (mHorizon != null) {
            mHorizon.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mHorizon != null) {
            mHorizon.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mHorizon != null) {
            mHorizon.onDestroy();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (mHorizon != null) {
                mHorizon.onResume();
            }
        } else {
            if (mHorizon != null) {
                mHorizon.onPause();
            }
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e("sos", "onHiddenChanged==" + hidden);
        if (hidden) {
            if (mHorizon != null) {
                mHorizon.onPause();
            }
        } else {
            if (mHorizon != null) {
                mHorizon.onResume();
            }
        }
    }
}
