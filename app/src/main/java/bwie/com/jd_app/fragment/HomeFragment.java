package bwie.com.jd_app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;

import bwie.com.jd_app.R;
import bwie.com.jd_app.bean.HomeBean;
import bwie.com.jd_app.presenter.Mypresenter;
import bwie.com.jd_app.util.GlideImageLoader;
import bwie.com.jd_app.view.IuserView;


public class HomeFragment extends Fragment implements IuserView {

    private Banner banner;
    private List<String> imageUrl;
    private List<String> bannerTitle;

    private List<HomeBean> mDatas = new ArrayList<>();
    private String url;
    private List<String> lists;
    private List<HomeBean.DataBean> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
          banner = view.findViewById(R.id.banner);

        Mypresenter mypresenter = new Mypresenter(this);
        mypresenter.getPresenter();
        initData();
        return view ;
    }

    @Override
    public void getView(HomeBean homeBean) {
        data = homeBean.getData();
        lists = new ArrayList<>();
        for(int i = 0; i< data.size(); i++){
            url = data.get(i).getIcon();
            lists.add(url);
        }
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(lists);
        banner.start();
    }

    private void initData() {
        //图片地址
        imageUrl = new ArrayList<>();
        imageUrl.add("http://img05.tooopen.com/images/20140604/sy_62331342149.jpg");
        imageUrl.add("http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg");
        imageUrl.add("http://img.taopic.com/uploads/allimg/121017/234940-12101FR22825.jpg");
       /* //Title名称
        bannerTitle = new ArrayList<>();
        bannerTitle.add("一");
        bannerTitle.add("二");
        bannerTitle.add("三");*/
    }

    private void initView() {
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(imageUrl);
        banner.setDelayTime(3000);
        banner.start();
    }
}
