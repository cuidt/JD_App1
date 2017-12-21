package bwie.com.jd_app.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwie.com.jd_app.R;
import bwie.com.jd_app.adapter.MyAdapter;
import bwie.com.jd_app.fragment.SayFragment;
import bwie.com.jd_app.fragment.ShopFragment;
import bwie.com.jd_app.fragment.XiangqingFragment;

public class XqActivity extends AppCompatActivity {
    private static final String TAG ="AppCompatActivity";
    @BindView(R.id.iv_back_shop)
    ImageView ivBackShop;
    @BindView(R.id.tab_shop)
    TabLayout tabShop;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.iv_pop_menu)
    ImageView ivPopMenu;
    @BindView(R.id.ll_shop_top)
    LinearLayout llShopTop;
    @BindView(R.id.vp_tab_shop)
    ViewPager vpTabShop;
    @BindView(R.id.ll_lingdang)
    LinearLayout llLingdang;
    @BindView(R.id.ll_dianpu)
    LinearLayout llDianpu;
    @BindView(R.id.iv_guanzhu)
    ImageView ivGuanzhu;
    @BindView(R.id.ll_guanzhu)
    LinearLayout llGuanzhu;
    @BindView(R.id.ll_shopcar)
    LinearLayout llShopcar;
    @BindView(R.id.tv_addshop)
    TextView tvAddshop;
    @BindView(R.id.ll_shop_bottom)
    LinearLayout llShopBottom;

    private List<Fragment> list_fragment;
    private List<String> list_shoptitle;
    private String pid;

    private List<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xq);

        ButterKnife.bind(this);
  String d =" 1";
        Intent intent = getIntent();
        String pid = intent.getStringExtra("pid");
        Toast.makeText(this, pid, Toast.LENGTH_SHORT).show();
       int id = 4 ;
        initDataa();

        vpTabShop.setAdapter(new MyAdapter(getSupportFragmentManager(),fragmentList));
        tabShop.setupWithViewPager(vpTabShop);


    }


   // 初始化数据
    private void initDataa() {

        fragmentList.add(new ShopFragment());
        fragmentList.add(new XiangqingFragment());
        fragmentList.add(new SayFragment());

    }


/*
    private void initData() {


        pid = getIntent().getStringExtra("pid");
        //存储fragment
        list_fragment = new ArrayList<>();
        //存储fragment
        Bundle bundle = new Bundle();
        bundle.putString("shopid", pid);

       // Fragment_detail fragment_detail = new Fragment_detail();
      //  fragment_detail.setArguments(bundle);
       // list_fragment.add(fragment_detail);
       // Fragment_say fragment_say = new Fragment_say();
       // fragment_say.setArguments(bundle);
      //  list_fragment.add(fragment_say);
//        fragment_shop
        //设置适配器
       // vpTabShop.setAdapter(new ShopvpAdapter(getSupportFragmentManager()));
       // Toast.makeText(this, pid, Toast.LENGTH_SHORT).show();
       // tabShop.setupWithViewPager(vpTabShop);
       // addCarPresenter = new AddCarPresenter(this,this);

    }*/
}
