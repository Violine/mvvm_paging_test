package com.example.mvvm_paging_test.network;

import com.example.mvvm_paging_test.model.Photos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET ("/photos")
    Call<List<Photos>> getAllPhotos(@Query ("albumId") long albumId);
}