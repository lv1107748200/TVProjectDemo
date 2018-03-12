package com.hr.tvprojectdemo.ui.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hr.tvprojectdemo.R;
import com.hr.tvprojectdemo.base.BaseActivity;
import com.hr.tvprojectdemo.base.BaseFragment;
import com.hr.tvprojectdemo.ui.adapter.MainAdapter;
import com.hr.tvprojectdemo.ui.fragment.MainFragment;
import com.hr.tvprojectdemo.utils.NLog;
import com.hr.tvprojectdemo.widget.focus.AbsFocusBorder;
import com.hr.tvprojectdemo.widget.focus.FocusBorder;
import com.hr.tvprojectdemo.widget.layout.tablayout.TabLayout;
import com.hr.tvprojectdemo.widget.layout.tablayout.TvTabLayout;
import com.hr.tvprojectdemo.widget.view.TvViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements
        BaseFragment.FocusBorderHelper,
        TabLayout.OnTabSelectedListener,
        ViewPager.OnPageChangeListener{

    private MainAdapter mainAdapter;
    private List<Fragment> fragmentList;
    private FocusBorder mFocusBorder;
    @BindView(R.id.tablayout3)
    TvTabLayout tablayout3;
    @BindView(R.id.viewPager)
    TvViewPager viewPager;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        super.init();
        if(null == mFocusBorder) {
//            mFocusBorder = new FocusBorder.Builder().asDrawable().borderResId(R.drawable.focus).build(this);
            mFocusBorder = new FocusBorder.Builder()
                    .asColor()
                    .borderColor(Color.TRANSPARENT)
                    .borderWidth(TypedValue.COMPLEX_UNIT_DIP, 2)
                    .shadowColor(Color.TRANSPARENT)
                    .shadowWidth(TypedValue.COMPLEX_UNIT_DIP, 18)
                    .build(this);
        }

        fragmentList = new ArrayList<>();

        for(int i = 0 ; i<2; i++){
            fragmentList.add(new MainFragment());
        }

        mainAdapter = new MainAdapter(getSupportFragmentManager());

        viewPager.addOnPageChangeListener(this);
        viewPager.setAdapter(mainAdapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setScrollerDuration(300);

        mainAdapter.upData(fragmentList);

        tablayout3.setScaleValue(1.2f);
        tablayout3.addOnTabSelectedListener(this);


    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
      //  NLog.e(NLog.TAGOther,"--->选中"+tab.getPosition());

        if(viewPager.getCurrentItem() == tab.getPosition()){

        }else {
            viewPager.setCurrentItem(tab.getPosition());
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

       if(tablayout3.getSelectedTabPosition() == position){

       }else {
           tablayout3.selectTab(position);
       }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public FocusBorder getFocusBorder() {
        return mFocusBorder;
    }
}
