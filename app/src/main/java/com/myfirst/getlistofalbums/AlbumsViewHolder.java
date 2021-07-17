package com.myfirst.getlistofalbums;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AlbumsViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvShowId,mTvShowTitle;

    public AlbumsViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews();
    }

    private void initViews() {
        mTvShowId = itemView.findViewById(R.id.tvShowId);
        mTvShowTitle = itemView.findViewById(R.id.tvShowTitle);
    }

    public void setData(ResponseAlbums responseAlbums){
        mTvShowId.setText(responseAlbums.getId() + "");
        mTvShowTitle.setText(responseAlbums.getTitle());
    }

}
