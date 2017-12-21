package bwie.com.jd_app.view;

import java.util.List;

import bwie.com.jd_app.bean.LeftBean;
import bwie.com.jd_app.bean.RightBean;

/**
 * Created by 崔 on 2017/12/17.
 */

public interface ThreeView {
   // void getView (RightBean rightBean);

    void getView(List<RightBean.DataBean> dataBeans);
    int getCid();
}
