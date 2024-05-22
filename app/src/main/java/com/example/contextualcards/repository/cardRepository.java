package com.example.contextualcards.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.contextualcards.Interfaces.APIInterface;
import com.example.contextualcards.models.APIRes;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class cardRepository {
    private static cardRepository instance;
    private List<APIRes> apiResList;
    private MutableLiveData<List<APIRes>> mutableLiveData = new MutableLiveData<>();
    private APIInterface apiInterface;

    public static cardRepository getInstance() {
        if (instance == null) {
            instance = new cardRepository();
        }
        return instance;
    }

    public APIInterface getApiInterface() {
        return apiInterface;
    }

    private cardRepository() {
        String baseURl = "https://polyjuice.kong.fampay.co/mock/";
        Retrofit APIClient = new Retrofit.Builder()
                .baseUrl(baseURl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = APIClient.create(APIInterface.class);
    }
}
