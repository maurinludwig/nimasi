package com.nimasi.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nimasi.game.screens.MenuScreen;

/**
 * NimasiJumper Game Application
 */
public class NimasiJumper extends Game {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 720;

    public SpriteBatch batch;


    /**
     * Creates game window.
     */
    @Override
    public void create() {
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
