package com.nimasi.game.core.config;

public class Config {

    private String username;
    private float musicVol;
    private float soundVol;

    public Config() {
    }

    public Config(String name, float soundVol, float musicVol) {
        this.username = name;
        this.soundVol = soundVol;
        this.musicVol = musicVol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getMusicVol() {
        return musicVol;
    }

    public void setMusicVol(float musicVol) {
        this.musicVol = musicVol;
    }

    public float getSoundVol() {
        return soundVol;
    }

    public void setSoundVol(float soundVol) {
        this.soundVol = soundVol;
    }
}
