package bwie.com.jd_app.Api;

import bwie.com.jd_app.bean.HomeBean;
import bwie.com.jd_app.bean.LeftBean;
import bwie.com.jd_app.bean.RightBean;
import bwie.com.jd_app.bean.ShopDetailBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 崔 on 2017/12/13.
 */

public interface Apiservier {

    @GET("ad/getAd")
    Observable<HomeBean> getUser();

    @GET("product/getCatagory")
    Observable<LeftBean> getLeft();

    @FormUrlEncoded
    @POST("product/getProductCatagory")
    Observable<RightBean> getRight(@Field("cid") String cid);

    @GET("product/getProductDetail")
    Observable<ShopDetailBean> getShop (@Query("pid") int pid,@Query("source") String source);


}
