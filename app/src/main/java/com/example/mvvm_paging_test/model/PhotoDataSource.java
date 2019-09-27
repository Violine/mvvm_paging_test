package com.example.mvvm_paging_test.model;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.mvvm_paging_test.network.GetDataService;
import com.example.mvvm_paging_test.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoDataSource extends PageKeyedDataSource<Long,Photos> {

    GetDataService dataService;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull final LoadInitialCallback<Long, Photos> callback) {

        dataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Photos>> data = dataService.getAllPhotos(1);
        data.enqueue(new Callback<List<Photos>> () {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                List<Photos> photosList = response.body();
                callback.onResult(photosList,null,(long)2);
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {

            }
        });

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, Photos> callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Long> params, @NonNull final LoadCallback<Long, Photos> callback) {


        dataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Photos>> data = dataService.getAllPhotos(params.key);
        data.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                List<Photos> photosList = response.body();
                callback.onResult(photosList, params.key+1);
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {

            }
        });


    }
}