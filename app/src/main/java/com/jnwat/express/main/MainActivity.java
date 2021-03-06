package com.jnwat.express.main;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarSearchHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsMenuHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerBottomHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerStyleHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerTopHandler;
import com.blunderer.materialdesignlibrary.listeners.OnSearchListener;
import com.blunderer.materialdesignlibrary.models.Account;
import com.blunderer.materialdesignlibrary.views.ToolbarSearch;
import com.jnwat.express.R;
import com.jnwat.express.about.FragmentAbout;
import com.jnwat.express.clear.ClearFragment;
import com.jnwat.express.fragment.ViewPagerWithTabsFragment;
import com.jnwat.express.push.PushFragment;
import com.jnwat.express.set.setting.SettingFragment;
import com.jnwat.express.tools.ModifySysTitle;
import com.jnwat.express.utils.Utils;

/**
 * 主程序Activty
 */
public class MainActivity extends com.blunderer.materialdesignlibrary.activities.NavigationDrawerActivity {
    @Override
    public NavigationDrawerStyleHandler getNavigationDrawerStyleHandler() {
        return null;
    }

    @Override
    public NavigationDrawerAccountsHandler getNavigationDrawerAccountsHandler() {
        return new NavigationDrawerAccountsHandler(this)
                .enableSmallAccountsLayout()
                .addAccount("王晓天", "15662799889",
                        R.drawable.ic_launcher, R.drawable.profile1_background);
    }

    @Override
    public NavigationDrawerAccountsMenuHandler getNavigationDrawerAccountsMenuHandler() {
        return new NavigationDrawerAccountsMenuHandler(this)
                .addAddAccount(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {


                    }

                })
                .addManageAccounts(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                    }

                });
    }

    @Override
    public void onNavigationDrawerAccountChange(Account account) {
        System.out.println(account.getTitle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ModifySysTitle.ModifySysTitleStyle(R.color.color_primary_dark,
                MainActivity.this);


    }

    @Override
    public NavigationDrawerTopHandler getNavigationDrawerTopHandler() {
        return new NavigationDrawerTopHandler(this)
                //  .addSection(R.string.fragment)
                .addItem(R.string.fragment_viewpager_with_tabs, R.drawable.icon_nav_home, new ViewPagerWithTabsFragment())
                .addItem(R.string.fragment_viewpager_with_tabs_set, R.drawable.icon_nav_setting, new SettingFragment())
                .addItem(R.string.fragment_viewpager_with_tabs_clear, R.drawable.ic_launcher, new ClearFragment())
                .addItem(R.string.fragment_viewpager_with_tabs_push, R.drawable.icon_nav_news, new PushFragment())
                        //.addItem(R.string.fragment_viewpager_with_tabs_exit, R.drawable.ic_launcher, new ())
                .addItem(R.string.fragment_viewpager_with_tabs_about, R.drawable.icon_nav_about, new FragmentAbout());
                        /*.addItem(R.string.start_activity, R.drawable.abc_btn_check_to_on_mtrl_000,
                                new Intent(getApplicationContext(), MainActivity.class));*/
    }

    @Override
    public NavigationDrawerBottomHandler getNavigationDrawerBottomHandler() {
        return new NavigationDrawerBottomHandler(this)
                .addSettings(null)
                .addHelpAndFeedback(null);
    }

    @Override
    public boolean overlayActionBar() {
        return false;
    }

    @Override
    public boolean replaceActionBarTitleByNavigationDrawerItemTitle() {
        return true;
    }

    @Override
    public int defaultNavigationDrawerItemSelectedPosition() {
        return 0;
    }

    @Override
    protected boolean enableActionBarShadow() {
        return false;
    }

    /*       @Override
           protected ActionBarHandler getActionBarHandler() {
                   return new ActionBarDefaultHandler(this);
           }*/
        /*
        @Override
        protected ActionBarHandler getActionBarHandler() {
                return new ActionBarSearchHandler(this, new OnSearchListener() {

                        @Override
                        public void onSearched(String text) {
                                Toast.makeText(getApplicationContext(),
                                        "Searching \"" + text + "\"", Toast.LENGTH_SHORT).show();
                        }

                });
        }*/
    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarSearchHandler(this, new OnSearchListener() {

            @Override
            public void onSearched(String text) {
                Toast.makeText(getApplicationContext(),
                        "Searching \"" + text + "\"", Toast.LENGTH_SHORT).show();
            }

        })
                .enableAutoCompletion()
                        //  .setAutoCompletionItems(mItems)
                .setAutoCompletionMode(ToolbarSearch.AutoCompletionMode.CONTAINS);
    }

}