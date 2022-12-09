package com.cookandroid.schoolpointfinishedversion;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BoardViewHollder extends RecyclerView.ViewHolder {

    TextView title, content, type, userid;

    public BoardViewHollder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.tv_board_title);
        content = itemView.findViewById(R.id.tv_board_content);
        type = itemView.findViewById(R.id.tv_board_type);
        userid = itemView.findViewById(R.id.tv_board_userid);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void onBind(BoarditemModel boarditemModel){
        title.setText(boarditemModel.getTitle());
        content.setText(boarditemModel.getContent());
        type.setText(boarditemModel.getType());
        userid.setText(boarditemModel.getUserid());
    }
}
