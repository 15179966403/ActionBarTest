package com.hrc.administrator.actionbartest;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/**
 * Created by Administrator on 2017/3/8.
 */

public class MyActionProvider extends ActionProvider{
    /**
     * Creates a new instance.
     *
     * @param context Context for accessing resources.
     */
    public MyActionProvider(Context context) {
        super(context);
    }

    @Override
    public View onCreateActionView() {
        return null;
    }

    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        subMenu.add("sub item 1")
                .setIcon(R.mipmap.ic_launcher)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Log.d("aa","sub item 1");
                        return true;
                    }
                });
        subMenu.add("sub item 2")
                .setIcon(R.mipmap.ic_launcher)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Log.d("aa","sub item 2");
                        return true;
                    }
                });
    }

    @Override
    public boolean hasSubMenu() {
        return true;
    }
}
