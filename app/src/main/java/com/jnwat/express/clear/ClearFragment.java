package com.jnwat.express.clear;

import android.os.Handler;

import com.jnwat.express.R;

/**
 * Created by chang-zhiyuan on 2016/3/4.
 */
public class ClearFragment extends com.blunderer.materialdesignlibrary.fragments.ScrollViewFragment {

    @Override
    public int getContentView() {
        return R.layout.clear_fragment;
    }

    @Override
    public boolean pullToRefreshEnabled() {
        return true;
    }

    @Override
    public int[] getPullToRefreshColorResources() {
        return new int[]{R.color.color_primary};
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                setRefreshing(false);
            }

        }, 2000);
    }

}
