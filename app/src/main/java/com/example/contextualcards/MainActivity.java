package com.example.contextualcards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contextualcards.Interfaces.APIInterface;
import com.example.contextualcards.models.APIRes;
import com.example.contextualcards.models.Card;
import com.example.contextualcards.models.CardGroup;
import com.example.contextualcards.repository.cardRepository;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getHomeSection("famx-paypage");
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this::refreshList);
    }

    private void refreshList() {
        getHomeSection("famx-paypage");
        swipeRefreshLayout.setRefreshing(false);
    }

    public MutableLiveData<List<APIRes>> getHomeSection(String slugs) {
        APIInterface apiInterface = cardRepository.getInstance().getApiInterface();
        Call<List<APIRes>> call = apiInterface.getHomeSection();
        MutableLiveData<List<APIRes>> mutableLiveData = new MutableLiveData<>();
        call.enqueue(new Callback<List<APIRes>>() {
            List<APIRes> apiResList;
            @Override
            public void onResponse(Call<List<APIRes>> call, Response<List<APIRes>> response) {
                apiResList = response.body();
                mutableLiveData.postValue(apiResList);
                handleApiResponse(apiResList);
            }

            @Override
            public void onFailure(Call<List<APIRes>> call, Throwable t) {
                System.out.println("Response Failure: "+t.toString());
                mutableLiveData.postValue(null);
            }
        });
        return mutableLiveData;
    }

    private void handleApiResponse(List<APIRes> apiResponses) {
        // Assuming the first API response contains the card groups
        List<CardGroup> cardGroups = apiResponses.get(0).getHcGroups();
        CardAdapter adapter = new CardAdapter(cardGroups);
        recyclerView.setAdapter(adapter);
    }
}