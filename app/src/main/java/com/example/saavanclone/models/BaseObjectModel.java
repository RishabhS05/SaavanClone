package com.example.saavanclone.models;

public class BaseObjectModel {
    String songName;

    public BaseObjectModel(String songName) {
        this.songName = songName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}

