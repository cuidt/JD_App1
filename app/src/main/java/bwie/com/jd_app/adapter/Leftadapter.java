package bwie.com.jd_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import bwie.com.jd_app.R;
import bwie.com.jd_app.bean.LeftBean;

/**
 * Created by 崔 on 2017/12/16.
 */

public class Leftadapter extends BaseAdapter {
    private Context context;
    private List<LeftBean.DataBean> list;
    private LayoutInflater inflater = null;
    private TextView textView;

    public Leftadapter(Context context, List<LeftBean.DataBean> list) {
        this.context = context;
        this.list = list;
        // 布局装载器对象
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null ){
            holder= new ViewHolder();
            convertView = View.inflate(context, R.layout.leftitem, null);
            holder.textView = (TextView) convertView.findViewById(R.id.left_tv);
            convertView.setTag(holder);
        }else {
            holder =(ViewHolder) convertView.getTag();
        }
        holder.textView.setText(list.get(position).getName());


        return convertView;
    }

    class ViewHolder{
        TextView textView;
    }

}
