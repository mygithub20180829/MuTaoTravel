package com.liuwang.mutaotravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuwang.mutaotravel.R;
import com.liuwang.mutaotravel.entity.Menu;

import java.util.List;

/**
 * Created by liuwang on 2019/8/4.
 */

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuViewHolder> {
    protected Context context;
    protected List<Menu> menus;

    public MainMenuAdapter(Context context, List<Menu> menus) {
        this.context=context;
        this.menus=menus;
    }

    @Override
    public MainMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainMenuViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_menu,null));
    }

    @Override
    public void onBindViewHolder(MainMenuViewHolder holder, int position) {
        Menu menu=menus.get(position);
        holder.mImgMenuIcon.setImageResource(menu.icon);
        holder.mTxtMenuName.setText(menu.menuName);
    }

    @Override
    public int getItemCount() {
        return null!=menus?menus.size():0;
    }
}

class MainMenuViewHolder extends RecyclerView.ViewHolder {
    public ImageView mImgMenuIcon;
    public TextView mTxtMenuName;

    public MainMenuViewHolder(View itemView) {
        super(itemView);
        mImgMenuIcon= (ImageView) itemView.findViewById(R.id.img_menu_icon);
        mTxtMenuName= (TextView) itemView.findViewById(R.id.txt_menu_name);

    }
}
