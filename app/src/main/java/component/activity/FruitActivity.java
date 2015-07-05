/*
* 액티비티간 데이터 주고받기 실습!!
* 데이터를 보내고, 다시 받아오는 방법을 익힌다
* */
package component.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.study.app0704.R;

public class FruitActivity extends Activity {
    /*개발자가 단어의 의미를 부여하여 임의로 정해놓은 요청코드*/
    private static final int FROM_FRUIT=1;

    Spinner sp; /*스피너는 단순히 껍데기일 뿐이므로, 자체적으로 데이터를
    제어할 능력이 없다!! 이때 필요한 객체가 바로 어댑터이다!!*/

    /*실제적으로 데이터 정보를 가지고, 스피너에게 정보를 제공할 객체인
    * 어댑터를 생성한다!!*/
    ArrayAdapter<CharSequence>  adapter;
    TextView resultScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruit_layout);

        sp=(Spinner)findViewById(R.id.sp);
        resultScore= (TextView)findViewById(R.id.result_score);

        /*
        * 인수1: context 이므로 액티비티
        * 인수2 : 사용할 데이터
        * 인수3 : 데이터를 어떤 레이아웃 스타일로 보여줄지.. xml이 와야함
        * */
        adapter= ArrayAdapter.createFromResource(this
                , R.array.planets_array , android.R.layout.simple_spinner_item);

        /*어댑터와 스피너 연결!!!*/
        sp.setAdapter(adapter);
    }

    /*
    * 전달한 데이터를, 다시 받아올때 사용되는 메서드를 재정의!!
    * 호출시점은? 데이터를 다시 넘겨받을 때 호출됨!!
    * 인수1 - 내가 보낸 코드!! FROM_FRUIT
    * 인수2 - 긍정인지 , 부정인지 판단하기 위한!!
    * 인수3 - 응답자가 보낸 데이터를 담아놓인 인텐트
    * */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        /*아까 내가 보낸 그 요청에 대한 응답임을 확신!!*/
        if(requestCode==FROM_FRUIT){
            if(resultCode == RESULT_OK){ /*처리에 문제가 없었다면..*/
                String score=intent.getStringExtra("score");
                resultScore.setText(score);
            }
        }
    }

    public void sendClick(View view){
        /*스피너에서 유저가 선택한 아이템의 index*/
        int position=sp.getSelectedItemPosition();

        /*유저가 선택한 index를 인수로 넣어야 데이터반환*/
        String item=(String)adapter.getItem(position);

        Toast.makeText(this,item+"를 선택하셨군요", Toast.LENGTH_LONG).show();

        /*나 아닌 다른 액티비티로 데이터를 가지고 가자!!
           액티비티와 같이, 개발자가 아닌 시스템이 관리하는 4대컴포넌트들은
           서로 알아들을 수 있는 형태로 데이터를 주고 받아야 하는데, 이때 사용되는
           데이터 형식을 보유한 객체가 바로 인텐트이다 Intent
        * */
        Intent intent  = new Intent(this, ResultActivity.class);

        /* 스피너에서 선택한 데이터를 인텐트에 탑재하여 보내자!!*/
        intent.putExtra("data", item);

        //this.startActivity(intent);
        /*요청시 , 내가 보낸 요청이라는 표시를 하자!! requestCode*/
        this.startActivityForResult(intent, FROM_FRUIT);
    }

}










