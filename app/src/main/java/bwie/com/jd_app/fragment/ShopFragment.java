package bwie.com.jd_app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import bwie.com.jd_app.R;
import bwie.com.jd_app.bean.ShopDetailBean;
import bwie.com.jd_app.presenter.FourPresent;
import bwie.com.jd_app.util.GlideImageLoader;
import bwie.com.jd_app.view.FourView;

public class ShopFragment extends Fragment implements FourView {
    private Banner xqBanner;
    private TextView xqTitle;
    private int pid;
    private List<String> imageUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_shop_fragment2, container, false);

        xqBanner = (Banner)view.findViewById(R.id.xq_banner);
        xqTitle = (TextView) view.findViewById(R.id.xq_title);

        FourPresent fourPresent =new FourPresent(this);
        fourPresent.getXqPresenter(pid);
        //图片地址
        imageUrl = new ArrayList<>();
        imageUrl.add("https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg");
        imageUrl.add("https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg");
        imageUrl.add("https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg");

        initView();
        return view;
    }
    private void initView() {
        xqBanner.setImageLoader(new GlideImageLoader());
        xqBanner.setImages(imageUrl);
        xqBanner.setDelayTime(3000);
        xqBanner.start();
    }

    @Override
    public void getFourView(ShopDetailBean.DataBean dataBeans) {
        pid = dataBeans.getPid();
        Toast.makeText(getActivity(), pid, Toast.LENGTH_SHORT).show();

        String images = dataBeans.getImages();
        String[] split = images.split("\\|");
        String s = split[1];

       Log.d("++ssssss",dataBeans.getTitle());
       //imageUrl.add();

    }


   /* public class StringSplit {
        public static void main(String[] args) {
            String sourceStr = "1,2,3,4,5";//一个字符串
            String[] sourceStrArray = sourceStr.split(",");//分割出来的字符数组
            for (int i = 0; i < sourceStrArray.length; i++) {
                System.out.println(sourceStrArray[i]);
            }

            // 最多分割出3个字符串
            int maxSplit = 3;
            sourceStrArray = sourceStr.split(",", maxSplit);
            for (int i = 0; i < sourceStrArray.length; i++) {
                System.out.println(sourceStrArray[i]);
            }
        }
    }*/


}
