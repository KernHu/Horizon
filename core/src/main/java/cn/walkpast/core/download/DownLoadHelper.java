package cn.walkpast.core.download;

import android.app.Activity;
import android.util.Log;

import cn.walkpast.download.DownLoadService;

/**
 * Author: Kern
 * Time: 2019/1/16 20:55
 * Description: This is..
 */

public class DownLoadHelper {

    private Activity mActivity;
    private String downloadUrl;
    private String contentDisposition;
    private String mimetype;
    private long contentLength;
    private String storagePath;


    public Activity getActivity() {
        return mActivity;
    }

    public DownLoadHelper setActivity(Activity activity) {
        mActivity = activity;
        return this;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public DownLoadHelper setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
        return this;
    }

    public String getContentDisposition() {
        return contentDisposition;
    }

    public DownLoadHelper setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
        return this;
    }

    public String getMimetype() {
        return mimetype;
    }

    public DownLoadHelper setMimetype(String mimetype) {
        this.mimetype = mimetype;
        return this;
    }

    public long getContentLength() {
        return contentLength;
    }

    public DownLoadHelper setContentLength(long contentLength) {
        this.contentLength = contentLength;
        return this;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public DownLoadHelper setStoragePath(String storagePath) {
        this.storagePath = storagePath;
        return this;
    }

    public static DownLoadHelper getInstance() {

        return new DownLoadHelper();
    }

    public void justDoIt() {

        String filename;
        if (getContentDisposition().contains("filename=")) {
            filename = getContentDisposition().split("filename=")[1].replace("\"", "");
        } else {
            filename = getDownloadUrl().substring(getDownloadUrl().lastIndexOf("/") + 1).split("[?]")[0];
        }
        Log.e("sos", "justDoIt====url==" + getDownloadUrl() + ";;;;filename=" + filename + ";;;;mimetype=" + mimetype);
        DownLoadService
                .startDownloadService(getActivity(),
                        getDownloadUrl(),
                        filename,
                        getMimetype(),
                        getStoragePath());
    }
}
