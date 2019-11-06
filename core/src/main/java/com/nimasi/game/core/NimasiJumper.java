package com.nimasi.game.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nimasi.game.core.config.Config;
import com.nimasi.game.core.config.ConfigManager;
import com.nimasi.game.core.screens.MenuScreen;

/**
 * NimasiJumper Game Application
 */
public class NimasiJumper extends Game {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 720;

    public SpriteBatch batch;
    public Music backgroundMusic;


    /**
     * Creates game window.
     */
    @Override
    public void create() {

        ConfigManager configManager = new ConfigManager();

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        backgroundMusic.setLooping(true);
        // QuickWin Solution -> Will be changed if game has a Welcome Screen
        if (Gdx.files.local("config.json").exists()) {
            Config currentConfig = configManager.readConfig();
            backgroundMusic.setVolume(currentConfig.getMusicVol());
        } else {
            backgroundMusic.setVolume(0.5f);
            configManager.saveConfig(new Config("no name set", 0.5f, 0.5f));
        }

        backgroundMusic.play();
        batch = new SpriteBatch();
        this.setScreen(new MenuScreen(this));

    }

    /**
     * Nimasi game renderer
     */
    @Override
    public void render() {
        super.render();
    }

    /**
     * Closes Nimasi
     */
    @Override
    public void dispose() {
        batch.dispose();
    }
}
