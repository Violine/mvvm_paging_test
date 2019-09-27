package com.example.mvvm_paging_test.model;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class PhotoDataSourceFactory extends DataSource.Factory {

    PhotoDataSource photoDataSource;
    MutableLiveData<PhotoDataSource> mutableLiveData;

    public PhotoDataSourceFactory() {
        mutableLiveData = new MutableLiveData<>();
    }

    @Override
    public DataSource create() {
        photoDataSource = new PhotoDataSource();
        mutableLiveData.postValue(photoDataSource);
        return photoDataSource;
    }

    public MutableLiveData<PhotoDataSource> getMutableLiveData() {
        return mutableLiveData;
    }
}
