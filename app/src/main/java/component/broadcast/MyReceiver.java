/*
* SMS 문자, 밧데리에 경고 메세지등 시스템은 설치되어있는 앱들에게
* 수많은 방송을보내준다!!
* 이때 개발자는 이 방송 중 듣고싶은것을 골라서 들으면 되고,
 *방송을 수신하여 처리할 수 있는 객체가 바로 브로드케스트 리시버이다~!!
* */
package component.broadcast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver{
    /*방송을 수신하게 되면 호출되는 메서드....*/

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MyReceiver", "문자 날아왔네요~~^^");
    }
}











