package bwie.com.jd_app.presenter;

import bwie.com.jd_app.Internet.ThreeWang;
import bwie.com.jd_app.bean.LeftBean;
import bwie.com.jd_app.bean.RightBean;
import bwie.com.jd_app.model.GetThreeModel;
import bwie.com.jd_app.model.GetTwoModel;
import bwie.com.jd_app.view.ThreeView;
import bwie.com.jd_app.view.TwoView;

/**
 * Created by 崔 on 2017/12/17.
 */

public class ThreePresent implements RightPresent,ThreeWang {
    GetThreeModel getThreeModel;
    ThreeView threeView;

    public ThreePresent(ThreeView threeView) {
        this.getThreeModel = new GetThreeModel();
        this.threeView = threeView;
    }


    @Override
    public void getWl(RightBean rightBean) {
       // threeView.getView(rightBean);
        threeView.getView(rightBean.getData());
    }


    @Override
    public void getRightPresenter(int cid) {
        getThreeModel.show(threeView.getCid()+"",this);

    }
}
