package kr.co.tjenit.instagramcopy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.util.List;

import kr.co.tjenit.instagramcopy.R;
import kr.co.tjenit.instagramcopy.ViewPostActivity;
import kr.co.tjenit.instagramcopy.data.NotificationData;

/**
 * Created by the on 2017-08-17.
 */

public class NotificationAdapter extends ArrayAdapter<NotificationData> {

    Context mContext;
    List<NotificationData> mList;
    LayoutInflater inf;


    public NotificationAdapter(Context context, List<NotificationData> list) {
        super(context, R.layout.my_reply_list_item);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row==null) {
            row = inf.inflate(R.layout.my_reply_list_item, null);
        }

        LinearLayout notificationLLayout = (LinearLayout) row.findViewById(R.id.notificationLLayout);

        notificationLLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ViewPostActivity.class);
                mContext.startActivity(intent);
            }
        });

        return row;
    }

    @Override
    public int getCount() {
        return 25;
    }
}
