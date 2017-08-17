package kr.co.tjenit.instagramcopy;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import kr.co.tjenit.instagramcopy.data.UserData;
import kr.co.tjenit.instagramcopy.util.ContextUtil;
import kr.co.tjenit.instagramcopy.util.GlobalData;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bindViews();
        setupEvents();
        setValues();

        UserData loginUserData = ContextUtil.getLoginUserData(mContext);
    }

    @Override
    public void setupEvents() {

        // postdelayed : 어떤 할 일을 재료1, 몇초후에 재료2
        // handler : 안드로이드의 쓰레드 개념
        //  시간에 관련된 특수한 동작을 실행
        //  백그라운드에서 돌아가야하는 일들 : 메인쓰레드 이외의 작업업
        // 할일=> new runnable
        // 재료2만큼의 시간이 지나면 할일을 실행 - 천분의 1초
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                UserData tempData = ContextUtil.getLoginUserData(mContext);
                if (tempData == null) {
                    // 로그인이 안되어있는 상황
                    intent = new Intent(mContext, LoginActivity.class);
                }
                else {
                    intent = new Intent(mContext, MainActivity.class);
                }

                startActivity(intent);
                finish();
            }
        }, 2000);

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

    }
}
