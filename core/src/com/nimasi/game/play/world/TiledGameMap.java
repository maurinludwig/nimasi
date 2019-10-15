package com.nimasi.game.play.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Sets up game map for NimasiJumper
 */
public class TiledGameMap extends GameMap {

    TiledMap tiledMap;
    OrthogonalTiledMapRenderer tiledMapRenderer;

    /**
     * Sets map from tiled file.
     */
    public TiledGameMap() {
        tiledMap = new TmxMapLoader().load("map.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    /**
     * Map rendering with set view.
     *
     * @param camera: View of the game
     */
    @Override
    public void render(OrthographicCamera camera, SpriteBatch batch) {
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        super.render(camera, batch);
        batch.end();
    }

    /**
     * Updates the map
     *
     * @param delta: What to update
     */
    @Override
    public void update(float delta) {
        super.update(delta);
    }

    /**
     * Disposes tiled map
     */
    @Override
    public void dispose() {
        tiledMap.dispose();

    }

    /**
     * Gets a tile at its coordinate within the map at a specified layer.
     *
     * @param layer: Layer on map
     * @param col:   Col on map
     * @param row:   Row on map
     * @return string: Tile type
     */
    @Override
    public TileType getTileTypeByCoordinate(int layer, int col, int row) {
        TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) tiledMap.getLayers().get(layer)).getCell(col, row);

        if (cell != null) {
            TiledMapTile tile = cell.getTile();

            if (tile != null) {
                int id = tile.getId();
                return TileType.getTileTypeByID(id);
            }
        }
        return null;
    }

    /**
     * Gets width of the layer
     *
     * @return int: Width of layer
     */
    @Override
    public int getWidth() {
        return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getWidth();
    }

    /**
     * Gets height of the layer
     *
     * @return int: Height of layer
     */
    @Override
    public int getHeight() {
        return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getHeight();
    }

    /**
     * Gets amount of layers in map
     *
     * @return int: Amount of layers
     */
    @Override
    public int getLayers() {
        return tiledMap.getLayers().getCount();
    }
}
