package com.nimasi.game.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.nimasi.game.core.NimasiJumper;
import com.nimasi.game.core.entities.BoundingRectImpl;
import com.nimasi.game.core.highscore.Highscore;
import com.nimasi.game.core.highscore.HighscoreManager;
import com.nimasi.game.core.world.GameMap;
import com.nimasi.game.core.world.TileType;
import com.nimasi.game.core.world.TiledGameMap;

/**
 * Game Screen Class
 */
public class GameScreen implements Screen {

    OrthographicCamera cam;
    GameMap gameMap;
    NimasiJumper game;
    private HighscoreManager manager;



    public GameScreen(NimasiJumper game, HighscoreManager manager) {
        this.game = game;
        this.manager = manager;
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

        if (gameMap.doesRectCollideWithMap(new BoundingRectImpl(
                gameMap.player.getX(),
                gameMap.player.getY() - 5,
                gameMap.player.getWidth(),
                gameMap.player.getHeight()
        ))) {
            if (gameMap.getTileTypeByLocation(1, gameMap.player.getX() + (gameMap.player.getWidth() / 2), gameMap.player.getY() - 10) == TileType.LAVA) {
                Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                cam.update();
                manager.saveHighscore(new Highscore((int) gameMap.player.getY(), "Maurin", 60));
                game.setScreen(new MenuScreen(game));
            }
        }

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