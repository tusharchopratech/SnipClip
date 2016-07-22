package com.snipclip.ui.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.snipclip.R;
import com.snipclip.pojo.VideoDataPojo;

import java.util.ArrayList;

/**
 * Created by tc on 7/23/16.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    ArrayList<VideoDataPojo> videoDataPojoArrayList;

    public ViewPagerAdapter(Context context, ArrayList<VideoDataPojo> videoDataPojoArrayList) {
        mContext = context;
        this.videoDataPojoArrayList = videoDataPojoArrayList;
    }


    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.inflate_view_pager, collection, false);
        collection.addView(layout);

        RecyclerView recyclerView= (RecyclerView) layout.findViewById(R.id.recyclerViewId);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(mLayoutManager);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(videoDataPojoArrayList.get(position).getUrls(), mContext);
        recyclerView.setAdapter(recyclerViewAdapter);

        TextView textView= (TextView) layout.findViewById(R.id.textViewViewPagerId);
        textView.setText("#"+ videoDataPojoArrayList.get(position).getVideoType());

        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return videoDataPojoArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return videoDataPojoArrayList.get(position).getVideoType();
    }

}