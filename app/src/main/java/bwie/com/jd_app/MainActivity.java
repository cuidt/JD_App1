package bwie.com.jd_app;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import bwie.com.jd_app.fragment.ClassifyFragment;
import bwie.com.jd_app.fragment.FaxianFragment;
import bwie.com.jd_app.fragment.HomeFragment;
import bwie.com.jd_app.fragment.MyFragment;
import bwie.com.jd_app.fragment.ShopCartFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private FrameLayout fl;
    private BottomNavigationBar bar;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int i =0;
        fl = findViewById(R.id.main_fl);
        bar = findViewById(R.id.main_boottomBar);

        bar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bar.addItem(new BottomNavigationItem(R.mipmap.one, "首页").setActiveColor(Color.RED))
                .addItem(new BottomNavigationItem(R.mipmap.two, "分类").setActiveColor(Color.RED))
                .addItem(new BottomNavigationItem(R.mipmap.three, "发现").setActiveColor(Color.RED))
                .addItem(new BottomNavigationItem(R.mipmap.four, "购物车").setActiveColor(Color.RED))
                .addItem(new BottomNavigationItem(R.mipmap.five, "我的").setActiveColor(Color.RED))
                .setFirstSelectedPosition(0)
                .initialise();
        fragments = getFragments();
        //setDefaultFragment();
        bar.setTabSelectedListener(this);


    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_fl, new HomeFragment());
        transaction.commit();
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ClassifyFragment());
        fragments.add(new FaxianFragment());
        fragments.add(new ShopCartFragment());
        fragments.add(new MyFragment());
        return fragments;
    }

    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    ft.replace(R.id.main_fl, fragment);
                } else {
                    ft.add(R.id.main_fl, fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }

    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
