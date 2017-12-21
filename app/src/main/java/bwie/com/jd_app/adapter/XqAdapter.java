package bwie.com.jd_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import bwie.com.jd_app.R;
import bwie.com.jd_app.activity.XqActivity;
import bwie.com.jd_app.bean.ShopDetailBean;
import bwie.com.jd_app.fragment.ShopCartFragment;

/**
 * Created by 崔 on 2017/12/18.
 */

public class XqAdapter extends RecyclerView.Adapter<XqAdapter.Mythree>  {

    Context context;
    ShopDetailBean.DataBean shopbean;
    private AdapterView.OnItemClickListener mOnItemClickListener = null;

    public XqAdapter(Context context, ShopDetailBean.DataBean shopbean) {
        this.context = context;
        this.shopbean = shopbean;
    }


    @Override
    public Mythree onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=  LayoutInflater.from(context).inflate(R.layout.xqitem,parent,false);
        return new Mythree(view) ;
    }

    @Override
    public void onBindViewHolder(Mythree holder, int position) {
        holder.title.setText(shopbean.getTitle());
        holder.price.setText(shopbean.getPrice());
        holder.sdv.setImageURI("http://120.27.23.105/images/icon.png");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, XqActivity.class);
                intent.putExtra("pid",shopbean.getPid()+" ");
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

     class Mythree extends RecyclerView.ViewHolder{

        TextView title;
        TextView price;
        SimpleDraweeView sdv;
        public Mythree(View itemView) {
            super(itemView);
            sdv   = itemView.findViewById(R.id.sdv);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);


        }
    }
}
