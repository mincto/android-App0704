/*
* 에니메이션을 적용한 프래그먼트 구현하기
*
 에니메이션의 종류
 크기 scale
 알파 alpha
 이동 translate
 각도 rotate

 적용대상 ( 모든 View , 개발자가 그리는 도형, 비트맵 이미지)
* */
package com.study.app0704;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import fragment.FragmentA;
import fragment.FragmentB;
import fragment.FragmentC;

/*액티비티를 포함하여, 개발자가 아닌 시스템이 관리하는 객체들은
* 대부분 생명주기 메서드가 지원된다. (jsp에서 Servlet은 init, service,destory
* 자바표준 Thread, start,run)
*/
public class PageActivity extends Activity{
    String TAG;
    Fragment[] fragments = new Fragment[3];/*공간만 만든거임*/
    FragmentManager manager;
    LinearLayout container;

    //액티비티가 생성될때 한번만 호출되는 메서드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName(); //현재 클래스이름반환

        /*  인플레이션 - 레이아웃 xml에 기재한 위젯의 자료형은 실제 안드로이드
                               클래스는 아니므로, 이 태그들을 실제 안드로이의 API  객체로
                               메모리에 생성시키는 과정을 말한다!!
                               ex) xml 에 기재한 버튼을 메모리에 올리는 작업
               화면에add
       */
        setContentView(R.layout.activity_page);

        /*프레그먼트 배열 생성 */
        fragments[0] = new FragmentA();
        fragments[1] = new FragmentB();
        fragments[2] = new FragmentC();

        manager=getFragmentManager();

        /*xml로 부터 인플레이션 되어 메모리에 올라온 리니어의 레퍼런스를 얻기*/
        container = (LinearLayout)findViewById(R.id.container);
    }

    /*
    * 페이지전환 메서드 정의
    * */
    public void showPage(int index){
        /*페이지 트랜잭션 시작~!!~*/
        FragmentTransaction transaction=manager.beginTransaction();

        /*원하는 레이아웃 위치에 프레그먼트 replace*/
        transaction.replace(R.id.container, fragments[index]);
        transaction.commit();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_left);
        container.startAnimation(animation);
    }

    public void btnClick(View view){

        switch(view.getId()){
            case R.id.bt1:showPage(0);break;
            case R.id.bt2:showPage(1);break;
            case R.id.bt3:showPage(2);break;
        }

    }
}







