package bwie.com.jd_app.Api;

/**
 * Created by 崔 on 2017/12/17.
 */

public interface OnNetLisenter<T> {
    public void OnSuccess(T t);

    public void OnFailure(Exception e);
}
