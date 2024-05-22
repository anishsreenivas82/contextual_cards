package com.example.contextualcards.Interfaces;
import com.example.contextualcards.models.APIRes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface APIInterface {
    @GET("famapp/feed/home_section/?slugs=famx-paypage")
    Call<List<APIRes>> getHomeSection();
}
