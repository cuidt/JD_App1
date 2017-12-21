package bwie.com.jd_app.presenter;

import java.util.List;

import bwie.com.jd_app.Internet.TwoWang;
import bwie.com.jd_app.bean.LeftBean;
import bwie.com.jd_app.model.GetTwoModel;
import bwie.com.jd_app.view.TwoView;

/**
 * Created by 崔 on 2017/12/16.
 */

public class TwoPresent implements LeftPresent,TwoWang {
    GetTwoModel getTwoModel;
    TwoView twoView;

    public TwoPresent(TwoView twoView) {
        this.getTwoModel = new GetTwoModel();
        this.twoView = twoView;
    }

    @Override
    public void getPresenter() {
        getTwoModel.showmodel(this);

    }


    @Override
    public void getWl(LeftBean leftBean) {
        twoView.getView(leftBean);
        List<LeftBean.DataBean> data = leftBean.getData();
        //int cid = data.get(0).getCid();


    }

}
