package v4.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.app0704.R;

/**
 * Created by Administrator on 2015-07-04.
 */
public class FragmentC extends Fragment {
    /*Fragmenet와 Activity 는 유사하기 때문에 둘다 생명주기 메서드가 있다*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /*프레그먼트가 사용할 레이아웃 파일을 인플레이션 시켜 , 반환하자!!*/
        View view = inflater.inflate(R.layout.fragment_c, container, false);
        return view;
    }
}
