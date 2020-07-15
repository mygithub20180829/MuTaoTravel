package com.liuwang.mutaotravel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.liuwang.mutaotravel.R;
import java.util.List;
import java.util.Map;

/**
 * Created by liuwang on 2019/8/5.
 */

public class FindListViewAdapter extends BaseAdapter {
    protected Context context;
    protected LayoutInflater inflater;
    protected List<Map<String, Object>> list;


    public FindListViewAdapter(Context context, List<Map<String, Object>> list){
        this.context=context;
        this.list=list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View view;
        if (convertView == null) {
            view = inflater.inflate(R.layout.find_listview, null);
            holder = new ViewHolder();

            holder.find_home= (TextView) view.findViewById(R.id.find_home);
            holder.find_home_where= (TextView) view.findViewById(R.id.find_home_where);
            holder.find_home_scan= (TextView) view.findViewById(R.id.find_home_scan);
            holder.find_home_zan= (TextView) view.findViewById(R.id.find_home_zan);

            holder.find_city= (TextView) view.findViewById(R.id.find_city);
            holder.find_city_where= (TextView) view.findViewById(R.id.find_city_where);
            holder.find_city_scan= (TextView) view.findViewById(R.id.find_city_scan);
            holder.find_city_zan= (TextView) view.findViewById(R.id.find_city_zan);

            holder.find_jiangnan= (TextView) view.findViewById(R.id.find_jiangnan);
            holder.find_jiangnan_where= (TextView) view.findViewById(R.id.find_jiangnan_where);
            holder.find_jiangnan_scan= (TextView) view.findViewById(R.id.find_jiangnan_scan);
            holder.find_jiangnan_zan= (TextView) view.findViewById(R.id.find_jiangnan_zan);

            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.find_jiangnan.setText((String) list.get(position).get("find_jiangnan"));
        holder.find_jiangnan_where.setText((String) list.get(position).get("find_jiangnan_where"));
        holder.find_jiangnan_scan.setText((String) list.get(position).get("find_jiangnan_scan"));
        holder.find_jiangnan_zan.setText((String) list.get(position).get("find_jiangnan_zan"));

        holder.find_home.setText((String) list.get(position).get("find_home"));
        holder.find_home_where.setText((String) list.get(position).get("find_home_where"));
        holder.find_home_scan.setText((String) list.get(position).get("find_home_scan"));
        holder.find_home_zan.setText((String) list.get(position).get("find_home_zan"));

        holder.find_city.setText((String) list.get(position).get("find_city"));
        holder.find_city_where.setText((String) list.get(position).get("find_city_where"));
        holder.find_city_scan.setText((String) list.get(position).get("find_city_scan"));
        holder.find_city_zan.setText((String) list.get(position).get("find_city_zan"));
        return view;
    }
}

class ViewHolder {
    public TextView find_jiangnan,find_jiangnan_where,find_jiangnan_scan,find_jiangnan_zan,
            find_home,find_home_where,find_home_scan,find_home_zan,
            find_city,find_city_where,find_city_scan,find_city_zan;
}
