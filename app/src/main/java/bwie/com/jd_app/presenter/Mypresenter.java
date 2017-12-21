package bwie.com.jd_app.presenter;

import bwie.com.jd_app.Internet.Wangluo;
import bwie.com.jd_app.bean.HomeBean;
import bwie.com.jd_app.model.GetModel;
import bwie.com.jd_app.model.ShowModel;
import bwie.com.jd_app.view.IuserView;

/**
 * Created by 崔 on 2017/12/13.
 */

public class Mypresenter implements IuserPresenter,Wangluo{
    ShowModel showModel;
    IuserView iuserView;
    //
    public Mypresenter(IuserView iuserView) {
        this.showModel = new GetModel();
        this.iuserView = iuserView;
    }

    @Override
    public void getPresenter() {
        showModel.showmodel(this);
    }

    @Override
    public void getWl(HomeBean homeBean) {
        iuserView.getView(homeBean);
    }





}
