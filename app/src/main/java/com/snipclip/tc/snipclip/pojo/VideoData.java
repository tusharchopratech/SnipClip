package com.snipclip.tc.snipclip.pojo;

import java.util.ArrayList;

/**
 * Created by tc on 7/23/16.
 */

public class VideoData {

    String videoType;
    ArrayList<String> urls;

    public VideoData(String videoType, ArrayList<String> urls) {
        this.videoType = videoType;
        this.urls = urls;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public ArrayList<String> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<String> urls) {
        this.urls = urls;
    }
}
