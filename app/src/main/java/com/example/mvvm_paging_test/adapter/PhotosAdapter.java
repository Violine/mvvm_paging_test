package com.example.mvvm_paging_test.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvm_paging_test.R;
import com.example.mvvm_paging_test.model.Photos;

public class PhotosAdapter extends PagedListAdapter<Photos,PhotosAdapter.PhotoViewHolder> {

    public PhotosAdapter() {
        super(Photos.CALLBACK);
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_photoes,viewGroup,false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder photoViewHolder, int i) {

        Glide.with(photoViewHolder.itemView.getContext()).load(getItem(i).getUrl()).into(photoViewHolder.ivPhoto);
    }


    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.imageView);
        }
    }
}
