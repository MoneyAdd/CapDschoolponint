package com.cookandroid.schoolpointfinishedversion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BoardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<BoarditemModel> listdata = new ArrayList<>();
//    private ArrayList<BoardReq> listdata = new ArrayList<>();



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_board, parent, false);
        return new BoardViewHollder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((BoardViewHollder)holder).onBind(listdata.get(position));
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }
    void additem(BoarditemModel boarmodel){
        listdata.add(boarmodel);
    }
}
