package com.nimasi.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.nimasi.game.NimasiJumper;
import com.nimasi.game.world.GameMap;
import com.nimasi.game.world.TileType;
import com.nimasi.game.world.TiledGameMap;

public class GameScreen implements Screen {

    OrthographicCamera cam;

    GameMap gameMap;

    NimasiJumper game;

    public GameScreen(NimasiJumper game) {
        this.game = game;
    }

    @Override
    public void show() {
        cam = new OrthographicCamera();
        cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.update();

        gameMap = new TiledGameMap();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isTouched())
            cam.translate(-Gdx.input.getDeltaX(), Gdx.input.getDeltaY());
        cam.update();

        if (Gdx.input.justTouched()) {
//			Gets position in game world
            Vector3 pos = cam.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            TileType type = gameMap.getTileTypeByLocation(1, pos.x, pos.y);

            if (type != null) {
                System.out.println("You clicked on tile with id " + type.getId() + " " + type.getName() + " " + type.isCollidable() + " " + type.getName());
            }
        }

        gameMap.update(Gdx.graphics.getDeltaTime());
        gameMap.render(cam, game.batch);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
