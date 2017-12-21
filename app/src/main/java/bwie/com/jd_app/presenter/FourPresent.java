package bwie.com.jd_app.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import bwie.com.jd_app.Internet.FourWang;
import bwie.com.jd_app.bean.ShopDetailBean;
import bwie.com.jd_app.model.GetFourModel;
import bwie.com.jd_app.view.FourView;

/**
 * Created by 崔 on 2017/12/18.
 */

public class FourPresent implements XqPresent {
    GetFourModel getFourModel;
    FourView fourView;

    public FourPresent(FourView fourView) {
        this.getFourModel = new GetFourModel();
        this.fourView = fourView;
    }


    @Override
    public void getXqPresenter(int pid) {
        getFourModel.showfour(pid,this);

    }
    @Override
    public void getfourWl(ShopDetailBean shopDetailBean) {
        //ShopDetailBean.DataBean data = shopDetailBean.getData();
        Log.d("==", "getfourWl: "+shopDetailBean.getData().getDetailUrl());
        fourView.getFourView(shopDetailBean.getData());
    }

}
