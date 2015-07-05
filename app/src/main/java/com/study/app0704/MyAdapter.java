/*
* ViewPager 가 정보를가져갈 수 있도록 지원하는 어댑터클래스로 정의!!
*
* */
package com.study.app0704;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import v4.fragment.FragmentA;
import v4.fragment.FragmentB;
import v4.fragment.FragmentC;

public class MyAdapter extends FragmentStatePagerAdapter {
    Fragment[] fragments = new Fragment[3];

    /*ViewPager를 사용하면, 개발자가 트랜잭션을 제어하지 않아도
    * 내부적으로 알아서 해준다!!
    * but FragmentManager를 어댑터에 넘겨줘야 한다!!
    * */
    public MyAdapter(FragmentManager fm) {
        super(fm);

        /*프레그먼트 배열생성 */
        fragments[0] = new FragmentA();
        fragments[1] = new FragmentB();
        fragments[2] = new FragmentC();
    }

    /*페이지 갯수!!*/
    @Override
    public int getCount() {
        return fragments.length;
    }


    /*각 포지션에 보여질 페이지 !!*/
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }
}





