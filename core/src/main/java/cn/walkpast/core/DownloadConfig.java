package cn.walkpast.core;

import cn.walkpast.core.constant.NetworkType;

/**
 * author: Kern Hu
 * email: sky580@126.com
 * data_time: 2019/1/1 5:40 PM
 * describe: This is...
 */

public class DownloadConfig {

    private String mStoragePath;
    private NetworkType mNetworkType;


    public String getStoragePath() {
        return mStoragePath;
    }

    public DownloadConfig setStoragePath(String storagePath) {
        mStoragePath = storagePath;
        return this;
    }

    public NetworkType getNetworkType() {
        return mNetworkType;
    }

    public DownloadConfig setNetworkType(NetworkType networkType) {
        mNetworkType = networkType;
        return this;
    }

    public DownloadConfig build() {

        return this;
    }
}
