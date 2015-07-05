package com.study.app0704;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ViewPagerActivity extends FragmentActivity{
    ViewPager viewPager;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        /*
        * ViewPager는 단순히 디자인만 처리하기 때문에, 어떤 데이터를 보여줄지
        * 여부는 어댑터라는 중간의 객체가 관리한다!!
        * 따라서 ViewPager와 어댑터를 연결해보자!!
        * */
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        /* ViewPager와 어댑터 연결!!*/
        MyAdapter adapter = new MyAdapter(manager=getSupportFragmentManager());
        viewPager.setAdapter(adapter); //연결!!
    }

    /*선택한 페이지 보여주기!!*/
    public void showPage(int position){
        viewPager.setCurrentItem(position);
    }

    public void btnClick(View view){
        switch(view.getId()){
            case R.id.bt1:showPage(0);break;
            case R.id.bt2:showPage(1);break;
            case R.id.bt3:showPage(2);break;
        }

    }
}












