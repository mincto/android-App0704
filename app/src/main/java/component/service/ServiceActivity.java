/*
* 서비스 객체를 메모리에 올리고 사용해본다!
* 서비스는 눈에 보이지 않고, 백그라운드에서 실행된다.
* 서비스는 4대컴포넌트이므로, 사용전 AndroidManifest.xml에 등록해야 한다
* */
package component.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.study.app0704.R;

public class ServiceActivity extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_layout);
    }

    /*서비스를 가동하는 메서드 정의 */
    public void createService(){
        Intent intent = new Intent(this , MyService.class);
        this.startService(intent);/*액티비티에서 가동!!*/
    }

    public void btnClick(View view){
        createService();
    }
}













