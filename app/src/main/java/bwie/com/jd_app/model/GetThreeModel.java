package bwie.com.jd_app.model;

import bwie.com.jd_app.Api.Api;
import bwie.com.jd_app.Api.Apiservier;
import bwie.com.jd_app.Api.OnNetLisenter;
import bwie.com.jd_app.Internet.ThreeWang;
import bwie.com.jd_app.bean.LeftBean;
import bwie.com.jd_app.bean.RightBean;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 崔 on 2017/12/17.
 */

public class GetThreeModel implements ThreeModel {

    @Override
    public void show(String cid, final ThreeWang threeWang) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//新的配置
                .baseUrl(Api.RightUrl)
                .build();
        Apiservier apiservier = retrofit.create(Apiservier.class);
        apiservier.getRight(cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RightBean rightBean) {
                        if (threeWang !=null){
                            threeWang.getWl(rightBean);
                        }

                    }
                });
    }


}
