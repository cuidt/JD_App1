package bwie.com.jd_app.model;

import bwie.com.jd_app.Api.Api;
import bwie.com.jd_app.Api.Apiservier;
import bwie.com.jd_app.Internet.Wangluo;
import bwie.com.jd_app.bean.HomeBean;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 崔 on 2017/12/13.
 */

public class GetModel implements ShowModel {

    @Override
    public void showmodel(final Wangluo wangluo) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//新的配置
                .baseUrl(Api.HomeUrl)
                .build();
        Apiservier apiSyserver = retrofit.create(Apiservier.class);
        apiSyserver.getUser()
                .subscribeOn(Schedulers.io())
                //.observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new Subscriber<HomeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                            if(wangluo!=null){
                                wangluo.getWl(homeBean);
                            }
                    }
                });

    }

}
