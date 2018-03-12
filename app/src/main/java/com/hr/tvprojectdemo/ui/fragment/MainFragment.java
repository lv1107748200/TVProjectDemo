package com.hr.tvprojectdemo.ui.fragment;


import android.view.View;

import com.hr.tvprojectdemo.R;
import com.hr.tvprojectdemo.base.BaseFragment;
import com.hr.tvprojectdemo.entiy.ItemDatas;
import com.hr.tvprojectdemo.ui.adapter.base.CommonRecyclerViewAdapter;
import com.hr.tvprojectdemo.ui.adapter.base.StaggeredAdapter;
import com.owen.tvrecyclerview.widget.SimpleOnItemListener;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import butterknife.BindView;

/**
 * Created by 吕 on 2018/3/8.
 */

public class MainFragment extends BaseFragment {

    @BindView(R.id.tvStaggeredRecycleView)
    TvRecyclerView tvStaggeredRecycleView;

    private CommonRecyclerViewAdapter mAdapter;

    @Override
    public int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void init() {
        super.init();
        tvStaggeredRecycleView.setSpacingWithMargins(10, 10);

        mAdapter = new StaggeredAdapter(getContext(), tvStaggeredRecycleView);
        mAdapter.setDatas(ItemDatas.getDatas(60));
        tvStaggeredRecycleView.setAdapter(mAdapter);

        tvStaggeredRecycleView.setOnItemListener(new SimpleOnItemListener() {

            @Override
            public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
                onMoveFocusBorder(itemView, 1.1f, 10);
            }

            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {

            }
        });

        tvStaggeredRecycleView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                mFocusBorder.setVisible(hasFocus);
            }
        });
    }
}
