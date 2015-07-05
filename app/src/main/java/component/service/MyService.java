/*
* 안드로이드 4대 주요 컴포넌트 중 서비스를 사용해본다!
* 서비스란?  UI가 없이 계속 실행주인 프로세스를 의미
*             예) 앱을 꺼도 나오는 배경음악
*                  앱을 꺼도 기타 게속 실행해야 되는 것들...
* */
package component.service;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service{
    String TAG;

    /*
    * 하나의 프로세스내에서 독립적으로 수행할 수 있는 세부실행단위!!
    * */
    Thread thread;
    int count; //0

    public MyService() {
        TAG=this.getClass().getName(); /*클래스 이름을 반환하는 메서드*/
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG ,  "onCreate() 호출!!");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG ,  "onStartCommand() 호출!!");

        /*0.5초 간격으로 카운트를 증가시키는 쓰레드 실행~*/
        thread = new Thread(){
            /*개발자가 독립수행하고 싶은 코드는 여기에 작성!*/
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    Log.d(TAG, "count=" + count);
                }
            }
        };
        thread.start();/*쓰레드 작동 시작!!*/

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestory() 호출!!");
    }
}










