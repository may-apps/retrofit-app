package com.aula2.retrofit.model;

public class Foto {
    private String albumId;
    private String id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public String getAlbumId() {
        return albumId;
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getUrl() {
        return url;
    }
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public String toString() {
        return "Foto [albumId=" + albumId + ", id=" + id + ", title=" + title + ", url=" + url
                + ", thumbnailUrl=" + thumbnailUrl + "]";
    }
}
