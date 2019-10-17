package com.nimasi.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.nimasi.game.NimasiJumper;
import com.nimasi.game.world.GameMap;
import com.nimasi.game.world.TiledGameMap;

/**
 * Game Screen Class
 */
public class GameScreen implements Screen {

    OrthographicCamera cam;
    GameMap gameMap;
    NimasiJumper game;

    public GameScreen(NimasiJumper game) {
        this.game = game;
    }

    /**
     * Sets cam and map
     */
    @Override
    public void show() {
        cam = new OrthographicCamera();
        cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.update();

        gameMap = new TiledGameMap();
    }

    /**
     * Renders input and map
     *
     * @param delta: Delta time
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        gameMap.update(Gdx.graphics.getDeltaTime());
        gameMap.render(cam, game.batch);
    }

    /**
     * Resizes screen
     *
     * @param width:  Width of window
     * @param height: Height of window
     */
    @Override
    public void resize(int width, int height) {

    }

    /**
     * Pauses screen
     */
    @Override
    public void pause() {

    }

    /**
     * Resumes screen
     */
    @Override
    public void resume() {

    }

    /**
     * Hides Screen
     */
    @Override
    public void hide() {

    }

    /**
     * Disposes Screen
     */
    @Override
    public void dispose() {

    }
}
