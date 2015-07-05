/*
* 다른 외부의 액티비티가 현재 액티비티로 전달한 데이터가 있다면,
* 받아서 처리해보자!!
* */
package component.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.study.app0704.R;

public class ResultActivity extends Activity {
    EditText send_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.result_layout);

        /*전송된 데이터는 Intent 에 들어있으므로, Intent을 얻어와서
        * 결과를 화면에 출력*/
        Intent intent=getIntent(); /*전달된 인텐트 얻기!!*/

        /*전송시 data라 키값으로 데이터를 심어서 넘겼기 때문에....*/
        String item=intent.getStringExtra("data");

        TextView txt_received=(TextView)findViewById(R.id.txt_received);
        txt_received.setText(item);

        send_score= (EditText)findViewById(R.id.send_score);
    }

    public void back(View view){
        /*
        * 데이터를 송신한 측인 FruitActivity에게 전달할 데이터를 구성한 후
        * 결과를 보내주자!!
        * */
        Intent intent=new Intent(this, FruitActivity.class);
        String score=send_score.getText().toString();
        intent.putExtra("score", score);
        /*안드로이드가 이미 긍정의 의미로 지정해 놓은 것뿐이지,
        * 반드시 써야 하는 것은 아니다!! 만일 개발자가 이 상수를 사용하기 싫다면
        * 그냥 임의로 성공을 의미하는 데이터와, 그렇지 않은 데이터를 정하면 그만!!
        * */
        setResult(this.RESULT_OK, intent);
        this.finish();
    }
}






