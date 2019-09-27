package com.example.mvvm_paging_test.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvm_paging_test.R;
import com.example.mvvm_paging_test.adapter.PhotosAdapter;
import com.example.mvvm_paging_test.model.Photos;
import com.example.mvvm_paging_test.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;
    RecyclerView photoRecylerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photoRecylerview = findViewById (R.id.recylerview);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        photoRecylerview.setLayoutManager(new GridLayoutManager (this,3));

        mainActivityViewModel.getPagedListLiveData().observe(this, new Observer<PagedList<Photos>> () {
            @Override
            public void onChanged(@Nullable PagedList<Photos> photos) {
                PhotosAdapter photosAdapter = new PhotosAdapter();
                photosAdapter.submitList(photos);
                photoRecylerview.setAdapter(photosAdapter);
            }
        });
    }
}