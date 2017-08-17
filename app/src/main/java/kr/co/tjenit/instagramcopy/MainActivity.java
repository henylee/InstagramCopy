package kr.co.tjenit.instagramcopy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import kr.co.tjenit.instagramcopy.adapter.NotificationAdapter;
import kr.co.tjenit.instagramcopy.adapter.PostingAdapter;
import kr.co.tjenit.instagramcopy.util.ContextUtil;
import kr.co.tjenit.instagramcopy.util.GlobalData;

public class MainActivity extends BaseActivity {

    private android.widget.Button logoutBtn;
    private android.widget.ImageView tabBtn1;
    private ImageView tabBtn2;
    private ImageView tabBtn3;
    private ImageView tabBtn4;
    private ImageView tabBtn5;
    private ListView myPhotoListView;
    private ListView newsfeedListView;
    private LinearLayout newsfeedLayout;
    private ListView myPostListView;
    private LinearLayout myProfileLayout;
    private ImageView titleImg;
    private android.widget.TextView myProfileTitleTxt;
    private TextView followingsBtn;
    private TextView newsBtn;
    private LinearLayout notificationLayout;

    PostingAdapter mAdapter;
    NotificationAdapter mNotificationAdapter;
    private ListView notificListView;
    private TextView notificationTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        followingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tabBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1번 탭이 눌리면
                // 집 모양의 그림을 검정색으로 꽉차게
                // 2~4번 탭이 눌리면 집 모양의 그림을 흰색으로

                titleImg.setVisibility(View.VISIBLE);
                myProfileTitleTxt.setVisibility(View.GONE);
                notificationTxt.setVisibility(View.GONE);

                tabBtn1.setImageResource(R.drawable.home_fill);
                tabBtn2.setImageResource(R.drawable.home_empty);
                tabBtn3.setImageResource(R.drawable.home_empty);
                tabBtn4.setImageResource(R.drawable.home_empty);
                tabBtn5.setImageResource(R.drawable.home_empty);

                newsfeedLayout.setVisibility(View.VISIBLE);
                myProfileLayout.setVisibility(View.GONE);
                notificationLayout.setVisibility(View.GONE);

            }
        });

        tabBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                titleImg.setVisibility(View.VISIBLE);
                myProfileTitleTxt.setVisibility(View.GONE);
                notificationTxt.setVisibility(View.GONE);

                newsfeedLayout.setVisibility(View.GONE);
                myProfileLayout.setVisibility(View.GONE);
                notificationLayout.setVisibility(View.GONE);

                tabBtn1.setImageResource(R.drawable.home_empty);
                tabBtn2.setImageResource(R.drawable.home_fill);
                tabBtn3.setImageResource(R.drawable.home_empty);
                tabBtn4.setImageResource(R.drawable.home_empty);
                tabBtn5.setImageResource(R.drawable.home_empty);
            }
        });
        tabBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                titleImg.setVisibility(View.VISIBLE);
                myProfileTitleTxt.setVisibility(View.GONE);
                notificationTxt.setVisibility(View.GONE);

                newsfeedLayout.setVisibility(View.GONE);
                myProfileLayout.setVisibility(View.GONE);
                notificationLayout.setVisibility(View.GONE);

                tabBtn1.setImageResource(R.drawable.home_empty);
                tabBtn2.setImageResource(R.drawable.home_empty);
                tabBtn3.setImageResource(R.drawable.home_fill);
                tabBtn4.setImageResource(R.drawable.home_empty);
                tabBtn5.setImageResource(R.drawable.home_empty);
            }
        });

        tabBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                titleImg.setVisibility(View.GONE);
                myProfileTitleTxt.setVisibility(View.GONE);
                notificationTxt.setVisibility(View.VISIBLE);

                newsfeedLayout.setVisibility(View.GONE);
                myProfileLayout.setVisibility(View.GONE);
                notificationLayout.setVisibility(View.VISIBLE);

                tabBtn1.setImageResource(R.drawable.home_empty);
                tabBtn2.setImageResource(R.drawable.home_empty);
                tabBtn3.setImageResource(R.drawable.home_empty);
                tabBtn4.setImageResource(R.drawable.home_fill);
                tabBtn5.setImageResource(R.drawable.home_empty);
            }
        });

        tabBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                titleImg.setVisibility(View.GONE);
                myProfileTitleTxt.setVisibility(View.VISIBLE);
                notificationTxt.setVisibility(View.GONE);

                newsfeedLayout.setVisibility(View.GONE);
                myProfileLayout.setVisibility(View.VISIBLE);
                notificationLayout.setVisibility(View.GONE);

                tabBtn1.setImageResource(R.drawable.home_empty);
                tabBtn2.setImageResource(R.drawable.home_empty);
                tabBtn3.setImageResource(R.drawable.home_empty);
                tabBtn4.setImageResource(R.drawable.home_empty);
                tabBtn5.setImageResource(R.drawable.home_fill);

            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 로그아웃 기능을 구현
                // 로그인 처리를 contextutil 데이터세팅
                // 로그아웃도 contextutil 데이터세팅
                ContextUtil.logoutProcess(mContext);
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void setValues() {

        mAdapter = new PostingAdapter(mContext, GlobalData.postingDataList);
        newsfeedListView.setAdapter(mAdapter);

        mNotificationAdapter = new NotificationAdapter(mContext, GlobalData.notificationDataList);
        notificListView.setAdapter(mNotificationAdapter);

    }

    @Override
    public void bindViews() {
        this.tabBtn5 = (ImageView) findViewById(R.id.tabBtn5);
        this.tabBtn4 = (ImageView) findViewById(R.id.tabBtn4);
        this.tabBtn3 = (ImageView) findViewById(R.id.tabBtn3);
        this.tabBtn2 = (ImageView) findViewById(R.id.tabBtn2);
        this.tabBtn1 = (ImageView) findViewById(R.id.tabBtn1);
        this.myProfileLayout = (LinearLayout) findViewById(R.id.myProfileLayout);
        this.myPostListView = (ListView) findViewById(R.id.myPostListView);
        this.notificationLayout = (LinearLayout) findViewById(R.id.notificationLayout);
        this.notificListView = (ListView) findViewById(R.id.notificListView);
        this.newsBtn = (TextView) findViewById(R.id.newsBtn);
        this.followingsBtn = (TextView) findViewById(R.id.followingsBtn);
        this.newsfeedLayout = (LinearLayout) findViewById(R.id.newsfeedLayout);
        this.newsfeedListView = (ListView) findViewById(R.id.newsfeedListView);
        this.notificationTxt = (TextView) findViewById(R.id.notificationTxt);
        this.myProfileTitleTxt = (TextView) findViewById(R.id.myProfileTitleTxt);
        this.titleImg = (ImageView) findViewById(R.id.titleImg);
        this.logoutBtn = (Button) findViewById(R.id.logoutBtn);
    }
}
