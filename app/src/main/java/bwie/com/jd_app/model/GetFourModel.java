package bwie.com.jd_app.model;

import android.util.Log;

import bwie.com.jd_app.Api.Api;
import bwie.com.jd_app.Api.Apiservier;
import bwie.com.jd_app.Internet.FourWang;
import bwie.com.jd_app.Internet.ThreeWang;
import bwie.com.jd_app.bean.RightBean;
import bwie.com.jd_app.bean.ShopDetailBean;
import bwie.com.jd_app.presenter.XqPresent;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by 崔 on 2017/12/18.
 */

public class GetFourModel implements FourModel {

    @Override
    public void showfour(final int pid, final XqPresent xqPresent) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Api.ProductUrl)
                .build();

        Apiservier apiservier = retrofit.create(Apiservier.class);
        apiservier.getShop(pid,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopDetailBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ShopDetailBean shopDetailBean) {
                        if (xqPresent!=null){
                            Log.d("==", "onNext: "+shopDetailBean.getMsg().toString());
                            xqPresent.getfourWl(shopDetailBean);
                        }

                    }
                });


    }
}
