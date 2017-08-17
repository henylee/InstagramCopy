package kr.co.tjenit.instagramcopy;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.tjenit.instagramcopy.data.UserData;
import kr.co.tjenit.instagramcopy.util.ContextUtil;

public class LoginActivity extends BaseActivity {

    private android.widget.Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData mData = new UserData(542, "아이유", "iu", "아이유사진경로");
                ContextUtil.setLoginUser(mContext, mData);
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
    }
}
