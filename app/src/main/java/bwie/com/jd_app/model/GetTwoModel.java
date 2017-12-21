package bwie.com.jd_app.model;

import bwie.com.jd_app.Api.Api;
import bwie.com.jd_app.Api.Apiservier;
import bwie.com.jd_app.Internet.TwoWang;
import bwie.com.jd_app.bean.HomeBean;
import bwie.com.jd_app.bean.LeftBean;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 崔 on 2017/12/14.
 */

public class GetTwoModel implements TwoModel {
    @Override
    public void showmodel(final TwoWang twoWang) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//新的配置
                .baseUrl(Api.LeftUrl)
                .build();
          Apiservier apiSyserver = retrofit.create(Apiservier.class);
          apiSyserver.getLeft()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeftBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LeftBean leftBean) {
                        if(twoWang!=null){
                            twoWang.getWl(leftBean);

                        }

                    }
                });

    }
}
