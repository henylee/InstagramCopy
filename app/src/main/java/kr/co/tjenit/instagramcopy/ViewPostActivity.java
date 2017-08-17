package kr.co.tjenit.instagramcopy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewPostActivity extends BaseActivity {

    private android.widget.ImageView backBtn;
    private android.widget.ImageView refreshBtn;
    private android.widget.TextView textView;
    private android.widget.ImageView replyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        replyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReplyListActivity.class);
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "댓글을 새로 읽어옵니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.replyBtn = (ImageView) findViewById(R.id.replyBtn);
        this.textView = (TextView) findViewById(R.id.textView);
        this.refreshBtn = (ImageView) findViewById(R.id.refreshBtn);
        this.backBtn = (ImageView) findViewById(R.id.backBtn);

    }
}
