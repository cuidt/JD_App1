package bwie.com.jd_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zqg.dialogviewpager.DepthPageTransformer;
import com.zqg.dialogviewpager.StepDialog;
import com.zqg.dialogviewpager.ZoomOutPageTransformer;

public class WelcomeActivity extends AppCompatActivity {
    private ZoomOutPageTransformer zoomOutPageTransformer;
    private DepthPageTransformer depthPageTransformer;
    protected static final String tag = "WelcomeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome);
        final SharedPreferences sharedPreferences = getSharedPreferences("config", Context.MODE_PRIVATE);
       // zoomOutPageTransformer = new ZoomOutPageTransformer();
        depthPageTransformer = new DepthPageTransformer();

        StepDialog.getInstance()
                .setImages(new int[]{
                        R.mipmap.jdhome,
                        R.mipmap.t2,
                        R.mipmap.t3,
                        R.mipmap.t4})
                .setCanceledOnTouchOutside(false)
                .setOutsideIsTransparent(false)
                .setPageTransformer(depthPageTransformer)  //分为：DepthPageTransformer方式  ZoomOutPageTransformer方式
                .show(getFragmentManager());
        /*Intent intent =new Intent(WelcomeActivity.this,MainActivity.class);
        startActivity(intent);
        */
        //发送一个颜色的消息
        new Handler(){
            public void handleMessage(android.os.Message msg) {
                //接受到消息后的处理
                boolean b = sharedPreferences.getBoolean("is_first",true);
                if(b){
                    //第一次进入应用，进入导航界面
                    sharedPreferences.edit().putBoolean("is_first", false).commit();
                    Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                    startActivity(intent);
                    Log.i(tag, "是第一次进入");
                }else{
                    //不是第一次进入应用,直接跳转到主界面
                    Log.i(tag, "是第二次进入");
                    Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                    startActivity(intent);
                }

                finish();
            }
        }.sendEmptyMessageDelayed(0, 4000);

    }
}
