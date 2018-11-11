package com.mumu.jsrecyclerview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_test)
    RecyclerView rvTest;
    private TestAdapter mTestAdapter;
    private ArrayList<TestEntity.ResultBean.ListBean> mTestList;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        //添加临时数据，一般直接从接口获取
        mTestList = new ArrayList<>();
        mTestList.add(new TestEntity.ResultBean.ListBean("我有一个小狗", "我有一个小狗我有一个小狗我有一个小狗我有一个小狗我有一个小狗"));
        mTestList.add(new TestEntity.ResultBean.ListBean("我有一个小狗", "我有一个小狗我有一个小狗我有一个小狗我有一个小狗我有一个小狗"));
        mTestList.add(new TestEntity.ResultBean.ListBean("我有一个小狗", "我有一个小狗我有一个小狗我有一个小狗我有一个小狗我有一个小狗"));
        mTestList.add(new TestEntity.ResultBean.ListBean("我有一个小狗", "我有一个小狗我有一个小狗我有一个小狗我有一个小狗我有一个小狗"));
        mTestList.add(new TestEntity.ResultBean.ListBean("我有一个小狗", "我有一个小狗我有一个小狗我有一个小狗我有一个小狗我有一个小狗"));
        mTestList.add(new TestEntity.ResultBean.ListBean("我有一个小狗", "我有一个小狗我有一个小狗我有一个小狗我有一个小狗我有一个小狗"));
        mTestList.add(new TestEntity.ResultBean.ListBean("我有一个小狗", "我有一个小狗我有一个小狗我有一个小狗我有一个小狗我有一个小狗"));
        mTestList.add(new TestEntity.ResultBean.ListBean("我有一个小狗", "我有一个小狗我有一个小狗我有一个小狗我有一个小狗我有一个小狗"));
        refreshView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    /**
     * 刷新消息列表
     */
    private void refreshView() {
        //1，设置LayoutManager,LinearLayoutManager表示竖直向下
        rvTest.setLayoutManager(new LinearLayoutManager(this));
        //2，初始化适配器
        mTestAdapter = new TestAdapter(mTestList);
        //3，绑定recyclerView和适配器
        rvTest.setAdapter(mTestAdapter);
        //4，给recyclerView的每一个子列表添加点击事件
        mTestAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MainActivity.this, "我点击了第" + position + "个子view",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
