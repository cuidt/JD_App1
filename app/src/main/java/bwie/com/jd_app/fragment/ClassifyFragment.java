package bwie.com.jd_app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import bwie.com.jd_app.R;
import bwie.com.jd_app.adapter.Leftadapter;
import bwie.com.jd_app.adapter.RightAdapter;
import bwie.com.jd_app.bean.HomeBean;
import bwie.com.jd_app.bean.LeftBean;
import bwie.com.jd_app.bean.RightBean;
import bwie.com.jd_app.presenter.Mypresenter;
import bwie.com.jd_app.presenter.ThreePresent;
import bwie.com.jd_app.presenter.TwoPresent;
import bwie.com.jd_app.util.GetID;
import bwie.com.jd_app.view.ThreeView;
import bwie.com.jd_app.view.TwoView;

public class ClassifyFragment extends Fragment implements TwoView,ThreeView {

    private ListView lv_class;
    private ExpandableListView rv_class;
    private Leftadapter leftadapter;
    private List<LeftBean.DataBean> data;
    private List<String> groupList = new ArrayList<>();//一级列表数据
    private List<List<RightBean.DataBean.ListBean>> childList= new ArrayList<>();//二级列表数据
    private ThreePresent threePresent;
    private int cid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classify, container, false);
        lv_class = (ListView) view.findViewById(R.id.lv_class);
        rv_class = (ExpandableListView) view.findViewById(R.id.rv_class);
       // rv_class.setGroupIndicator(null);

        TwoPresent twoPresent = new TwoPresent(this);
        twoPresent.getPresenter();

        threePresent = new ThreePresent(this);


        lv_class.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LeftBean.DataBean dataBean = (LeftBean.DataBean) parent.getItemAtPosition(position);
               // int ci = dataBean.getCid();
               // Log.d("+++++++++",ci+" ");
                //cid=dataBean.getCid()+"";
                cid = dataBean.getCid();
               // Log.d("+++++++++",cid +" ");
                threePresent.getRightPresenter(cid);


            }
        });
        return view;
    }


    @Override
    public void getView(LeftBean leftBean) {
         data = leftBean.getData();
         leftadapter = new Leftadapter(getActivity(), data);
         lv_class.setAdapter(leftadapter);
    }

    @Override
    public void getView(List<RightBean.DataBean> dataBeans) {
        groupList.clear();
        childList.clear();
        for (int i = 0; i < dataBeans.size(); i++) {
            RightBean.DataBean dataBean = dataBeans.get(i);
            groupList.add(dataBean.getName());
            childList.add(dataBean.getList());
            //Toast.makeText(getActivity(), childList.toString(), Toast.LENGTH_SHORT).show();
           // Log.d("++++",childList.toString());
        }
        RightAdapter rightAdapteradapter = new RightAdapter(getActivity(),groupList,childList);

        rv_class.setAdapter(rightAdapteradapter);
        //默认二级列表都展开
        for (int i = 0; i < dataBeans.size(); i++) {
            rv_class.expandGroup(i);
        }

    }

    @Override
    public int getCid() {
        return cid;
    }



}
