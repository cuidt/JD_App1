package bwie.com.jd_app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import bwie.com.jd_app.R;
import bwie.com.jd_app.adapter.XqAdapter;
import bwie.com.jd_app.bean.ShopDetailBean;
import bwie.com.jd_app.presenter.FourPresent;
import bwie.com.jd_app.view.FourView;

public class ProductActivity extends AppCompatActivity implements FourView {
    private RecyclerView rcvKind;
    private int pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        rcvKind = (RecyclerView) findViewById(R.id.rcv_kind);
        //获取到传过来的商品id
        Intent  intent = getIntent();
        pid = intent.getIntExtra("pid", 12);
        Log.d("pid++++",pid+"");

        Toast.makeText(this, pid +" ", Toast.LENGTH_SHORT).show();
        FourPresent fourPresent =new FourPresent(this);
        fourPresent.getXqPresenter(pid);

    }

    @Override
    public void getFourView(ShopDetailBean.DataBean dataBeans) {

        Toast.makeText(this, dataBeans.getTitle(), Toast.LENGTH_SHORT).show();
        //Log.d("++++++",dataBeans.getTitle());
        XqAdapter xqAdapter =new XqAdapter(ProductActivity.this,dataBeans);
        rcvKind.setAdapter(xqAdapter);
        rcvKind.setLayoutManager(new LinearLayoutManager(this));


    }



}
