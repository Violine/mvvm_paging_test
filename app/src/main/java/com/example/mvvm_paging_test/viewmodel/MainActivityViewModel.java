package com.example.mvvm_paging_test.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.mvvm_paging_test.model.PhotoDataSource;
import com.example.mvvm_paging_test.model.PhotoDataSourceFactory;
import com.example.mvvm_paging_test.model.PhotoRepository;
import com.example.mvvm_paging_test.model.Photos;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivityViewModel extends AndroidViewModel {

    PhotoRepository photoRepository;
    PhotoDataSourceFactory photoDataSourceFactory;
    MutableLiveData<PhotoDataSource> dataSourceMutableLiveData;
    Executor executor;
    LiveData<PagedList<Photos>> pagedListLiveData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        photoDataSourceFactory = new PhotoDataSourceFactory();
        dataSourceMutableLiveData = photoDataSourceFactory.getMutableLiveData();

        PagedList.Config config = (new PagedList.Config.Builder())
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(10)
            .setPageSize(20)
            .setPrefetchDistance(4)
            .build();
        executor = Executors.newFixedThreadPool(5);
        pagedListLiveData = (new LivePagedListBuilder<Long, Photos> (photoDataSourceFactory,config))
            .setFetchExecutor(executor)
            .build();


    }

    public LiveData<PagedList<Photos>> getPagedListLiveData() {
        return pagedListLiveData;
    }
}