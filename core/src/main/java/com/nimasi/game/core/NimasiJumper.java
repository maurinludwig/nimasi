package com.nimasi.game.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(0.01f);
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
