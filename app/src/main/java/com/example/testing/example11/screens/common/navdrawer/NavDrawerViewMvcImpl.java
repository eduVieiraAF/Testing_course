package com.example.testing.example11.screens.common.navdrawer;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.testing.R;
import com.example.testing.example11.screens.common.views.BaseObservableViewMvc;
import com.google.android.material.navigation.NavigationView;

public class NavDrawerViewMvcImpl extends BaseObservableViewMvc<NavDrawerViewMvc.Listener>
        implements NavDrawerViewMvc {

    private final DrawerLayout mDrawerLayout;
    private final FrameLayout mFrameLayout;

    public NavDrawerViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_drawer, parent, false));
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mFrameLayout = findViewById(R.id.frame_content);
        NavigationView mNavigationView = findViewById(R.id.nav_view);

        mNavigationView.setNavigationItemSelectedListener(item -> {
            mDrawerLayout.closeDrawers();
            if (item.getItemId() == R.id.drawer_menu_questions_list) {
                for (Listener listener : getListeners()) {
                    listener.onQuestionsListClicked();
                }
            }
            return false;
        });
    }

    @Override
    public void openDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public boolean isDrawerOpen() {
        return mDrawerLayout.isDrawerOpen(GravityCompat.START);
    }

    @Override
    public void closeDrawer() {
        mDrawerLayout.closeDrawers();
    }

    @Override
    public FrameLayout getFragmentFrame() {
        return mFrameLayout;
    }
}
