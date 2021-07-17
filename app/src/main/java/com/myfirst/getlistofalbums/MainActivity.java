package com.myfirst.getlistofalbums;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<ResponseAlbums> arrayList;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        apiCall();
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mProgressBar = findViewById(R.id.progressBar);
    }

    public void setRecyclerView() {
        AlbumsAdapter albumsAdapter = new AlbumsAdapter(arrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setAdapter(albumsAdapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    public void apiCall() {
        ApiCall apiCall = Network.getInstance().create(ApiCall.class);
        apiCall.getPosts().enqueue(new Callback<ArrayList<ResponseAlbums>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseAlbums>> call, Response<ArrayList<ResponseAlbums>> response) {
                arrayList = response.body();
                setRecyclerView();
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseAlbums>> call, Throwable t) {

            }
        });
    }
}