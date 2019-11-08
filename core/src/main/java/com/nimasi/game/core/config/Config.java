package com.nimasi.game.core.config;

/**
 * Defines Config Object
 */
public class Config {

    private String username;
    private float musicVol;
    private float soundVol;

    /**
     * Config Constructor
     *
     * @param name String: Username
     * @param soundVol float: Volume of sounds
     * @param musicVol float: Volume of music
     */
    public Config(String name, float soundVol, float musicVol) {
        this.username = name;
        this.soundVol = soundVol;
        this.musicVol = musicVol;
    }

    /**
     * Gets username
     *
     * @return String: Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username
     *
     * @param username String: Username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets music vol
     *
     * @return float: Current music volume
     */
    public float getMusicVol() {
        return musicVol;
    }

    /**
     * Sets music vol
     *
     * @param musicVol float: New music volume
     */
    public void setMusicVol(float musicVol) {
        this.musicVol = musicVol;
    }

    /**
     * Gets sound vol
     *
     * @return float: Current sound volume
     */
    public float getSoundVol() {
        return soundVol;
    }

    /**
     * Sets sound vol
     *
     * @param soundVol float: New sound volume
     */
    public void setSoundVol(float soundVol) {
        this.soundVol = soundVol;
    }
}
