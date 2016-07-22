package com.snipclip.tc.snipclip.view;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.snipclip.tc.snipclip.adapters.ViewPagerAdapter;
import com.snipclip.tc.snipclip.R;
import com.snipclip.tc.snipclip.pojo.VideoData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<VideoData> videoDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoDataArrayList=new ArrayList<>();
        setVideoDataArrayList();
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new ViewPagerAdapter(this,videoDataArrayList));

    }

    private void setVideoDataArrayList() {

        ArrayList<String> urlArrayList=new ArrayList<>();
        urlArrayList.add("GC9vW-BCp20");
        urlArrayList.add("E-fzJnpf-T4");
        urlArrayList.add("1J9Z0qhKZqo");
        urlArrayList.add("9OXFk-pdi6c");
        urlArrayList.add("KNNvi2hp1xM");
        videoDataArrayList.add(new VideoData("Entertainment",urlArrayList));


        urlArrayList=new ArrayList<>();
        urlArrayList.add("Cnfj6QCGLyA");
        urlArrayList.add("2JQsf7i_dXY");
        urlArrayList.add("hXI8RQYC36Q");
        urlArrayList.add("0KSOMA3QBU0");
        urlArrayList.add("J65GxJ2v9Wg");
        videoDataArrayList.add(new VideoData("Music",urlArrayList));



        urlArrayList=new ArrayList<>();
        urlArrayList.add("93enaMBAW_4");
        urlArrayList.add("aHwvb7w_kGs");
        urlArrayList.add("XWvI2QrqFPM");
        urlArrayList.add("2QpO_QNFQjU");
        urlArrayList.add("XeoPeer5zcM");
        videoDataArrayList.add(new VideoData("Sports",urlArrayList));

    }


}
