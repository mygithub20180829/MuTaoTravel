package com.liuwang.mutaotravel.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.liuwang.mutaotravel.R;
import com.liuwang.mutaotravel.adapter.MainHeaderAdAdapter;
import com.liuwang.mutaotravel.adapter.MainMenuAdapter;
import com.liuwang.mutaotravel.util.DataUtil;

/**
 * Created by liuwang on 2019/8/4.
 */

public class MainFragment extends Fragment {

    protected int [] icons={R.mipmap.header_pic_ad1,R.mipmap.header_pic_ad2,R.mipmap.header_pic_ad1};
    //菜单图标
    protected int [] menuIcons={R.mipmap.menu_airport,R.mipmap.menu_hatol,R.mipmap.menu_trav,
                    R.mipmap.menu_nearby,R.mipmap.menu_ticket,R.mipmap.menu_train,
                    R.mipmap.menu_car,R.mipmap.menu_course};
    protected int [] menuIcons2={R.mipmap.menu_second_airport,R.mipmap.menu_second_play,R.mipmap.menu_second_quan};
    protected String[] menus,menus2;
    protected ViewPager mVPagerHeaderAd;            //广告头部
    protected RecyclerView mRecyclerViewMenu,mRecyclerViewMenu2;       //主菜单

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        menus=this.getActivity().getResources().getStringArray(R.array.main_menu);
        menus2=this.getActivity().getResources().getStringArray(R.array.main_menu2);

        mVPagerHeaderAd= (ViewPager) getView().findViewById(R.id.vpager_main_header_ad);

        mRecyclerViewMenu= (RecyclerView) getView().findViewById(R.id.recycleview_main_menu);
        mRecyclerViewMenu2= (RecyclerView) getView().findViewById(R.id.recycleview_second_menu);

        MainHeaderAdAdapter adapter=new MainHeaderAdAdapter(getActivity(), DataUtil.getHeaderAdInfo(getActivity(),icons));
        mVPagerHeaderAd.setAdapter(adapter);
        //菜单
        mRecyclerViewMenu.setLayoutManager(new GridLayoutManager(getActivity(),4));//4列
        mRecyclerViewMenu2.setLayoutManager(new GridLayoutManager(getActivity(),3));//3列
        MainMenuAdapter mainMenuAdapter=new MainMenuAdapter(getActivity(),DataUtil.getMainMenus(menuIcons,menus));
        MainMenuAdapter mainMenuAdapter2=new MainMenuAdapter(getActivity(),DataUtil.getMainMenus(menuIcons2,menus2));
        mRecyclerViewMenu.setAdapter(mainMenuAdapter);
        mRecyclerViewMenu2.setAdapter(mainMenuAdapter2);
    }
}
