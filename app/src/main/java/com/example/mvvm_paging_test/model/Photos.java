package com.example.mvvm_paging_test.model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.SerializedName;

public class Photos {
    @SerializedName ("albumId")
    private Integer albumId;
    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

    public Photos(Integer albumId, Integer id, String title, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public static final DiffUtil.ItemCallback<Photos> CALLBACK = new DiffUtil.ItemCallback<Photos>() {
        @Override
        public boolean areItemsTheSame(@NonNull Photos photos, @NonNull Photos t1) {
            return photos.id == t1.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Photos photos, @NonNull Photos t1) {
            return true;
        }
    };
}