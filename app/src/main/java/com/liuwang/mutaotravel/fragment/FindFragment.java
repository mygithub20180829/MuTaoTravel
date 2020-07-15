package com.liuwang.mutaotravel.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.liuwang.mutaotravel.R;
import com.liuwang.mutaotravel.adapter.FindListViewAdapter;
import com.liuwang.mutaotravel.adapter.FindMenuAdapter;
import com.liuwang.mutaotravel.util.DataUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuwang on 2019/8/4.
 */

public class FindFragment extends Fragment {
    protected int [] menuIcons={R.mipmap.find_main_travel,R.mipmap.find_main_square,
            R.mipmap.find_main_hotwind,R.mipmap.find_main_way};
    protected int [] menuIcons2={R.mipmap.find_channel_parter,R.mipmap.find_chnnel_me,
            R.mipmap.find_channel_online};
    protected String[] menus,menus2;
    protected RecyclerView mRecyclerViewMenu,mRecyclerViewMenu2;       //主菜单
    protected List<Map<String, Object>> list;
    protected ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_find,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("find_jiangnan", "杏花落尽，只留下淡黄的记忆，浸润着江南的温柔");
        map.put("find_jiangnan_where", "来源：美丽中国");
        map.put("find_jiangnan_scan", "839932");
        map.put("find_jiangnan_zan", "167");
        map.put("find_home", "行旅箱，家居好物，让生活更精彩");
        map.put("find_home_where", "来源：家居生活");
        map.put("find_home_scan", "28621");
        map.put("find_home_zan", "47");
        map.put("find_city", "从东莞去广州仅需半个小时");
        map.put("find_city_where", "来源：羊城攻略");
        map.put("find_city_scan", "10526");
        map.put("find_city_zan", "23");
        list.add(map);

        listView= (ListView) getView().findViewById(R.id.lst_hot_infos);

        menus=this.getActivity().getResources().getStringArray(R.array.find_menu);
        menus2=this.getActivity().getResources().getStringArray(R.array.find_menu2);

        mRecyclerViewMenu= (RecyclerView) getView().findViewById(R.id.recycleview_find_menu);
        mRecyclerViewMenu2= (RecyclerView) getView().findViewById(R.id.recycleview_find_second);

        mRecyclerViewMenu.setLayoutManager(new GridLayoutManager(getActivity(),4));//4列
        mRecyclerViewMenu2.setLayoutManager(new GridLayoutManager(getActivity(),3));//3列
        FindMenuAdapter findMenuAdapter=new FindMenuAdapter(getActivity(), DataUtil.getMainMenus(menuIcons,menus));
        FindMenuAdapter findMenuAdapter2=new FindMenuAdapter(getActivity(),DataUtil.getMainMenus(menuIcons2,menus2));
        FindListViewAdapter adapter=new FindListViewAdapter(getActivity(),list);
        mRecyclerViewMenu.setAdapter(findMenuAdapter);
        mRecyclerViewMenu2.setAdapter(findMenuAdapter2);
        listView.setAdapter(adapter);
    }
}
