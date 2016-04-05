package com.jnwat.express.fragment;

import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;
import com.jnwat.express.R;

/**
 * Created by chang-zhiyuan on 2016/3/2.
 */
public class ViewPagerWithTabsFragment extends com.blunderer.materialdesignlibrary.fragments.ViewPagerWithTabsFragment {
    FragmentGet mFragmentGet;
    FragmentNoGet mFragmentNoGet;

    @Override
    public ViewPagerHandler getViewPagerHandler() {

        if(null ==mFragmentGet ){
            mFragmentGet  = new FragmentGet();
        }
        if(null ==mFragmentNoGet ){
            mFragmentNoGet  = new FragmentNoGet();
        }



        return new ViewPagerHandler(getActivity())
                .addPage(R.string.title_noget,
                        //   MainFragment.newInstance("Material Design Fragment ViewPager with Tabs"));
                        mFragmentNoGet)
                .addPage(R.string.title_hadget,
                    //    MainFragment.newInstance("Material Design Fragment ViewPager with Tabs"))
                        mFragmentGet );


    }

    @Override
    public boolean expandTabs() {
        return false;
    }

    @Override
    public int defaultViewPagerPageSelectedPosition() {
        return 0;
    }

}
