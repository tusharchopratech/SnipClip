package com.snipclip.ui.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.snipclip.ui.adapters.ViewPagerAdapter;
import com.snipclip.R;
import com.snipclip.pojo.VideoDataPojo;

import java.util.ArrayList;

public class SnipClipActivity extends AppCompatActivity {


    ArrayList<VideoDataPojo> videoDataPojoArrayList;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoDataPojoArrayList =new ArrayList<>();
        setVideoDataArrayList();

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(videoDataPojoArrayList.size());
        final ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this, videoDataPojoArrayList);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                viewPagerAdapter.stopAllVideos();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


    }

    private void setVideoDataArrayList() {

        ArrayList<String> urlArrayList=new ArrayList<>();
        urlArrayList.add("GC9vW-BCp20");
        urlArrayList.add("E-fzJnpf-T4");
        urlArrayList.add("1J9Z0qhKZqo");
        urlArrayList.add("KNNvi2hp1xM");
        urlArrayList.add("9OXFk-pdi6c");
        videoDataPojoArrayList.add(new VideoDataPojo("Entertainment",urlArrayList));


        urlArrayList=new ArrayList<>();
        urlArrayList.add("Cnfj6QCGLyA");
        urlArrayList.add("2JQsf7i_dXY");
        urlArrayList.add("hXI8RQYC36Q");
        urlArrayList.add("0KSOMA3QBU0");
        urlArrayList.add("J65GxJ2v9Wg");
        videoDataPojoArrayList.add(new VideoDataPojo("Music",urlArrayList));



        urlArrayList=new ArrayList<>();
        urlArrayList.add("93enaMBAW_4");
        urlArrayList.add("aHwvb7w_kGs");
        urlArrayList.add("XWvI2QrqFPM");
        urlArrayList.add("2QpO_QNFQjU");
        urlArrayList.add("XeoPeer5zcM");
        videoDataPojoArrayList.add(new VideoDataPojo("Sports",urlArrayList));

    }


}
