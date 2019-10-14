package com.nimasi.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Nimasi Game Map
 */
public abstract class GameMap {

    /**
     * Rendering game map with given cam
     *
     * @param camera: Orthographic Camera
     */
    public abstract void render(OrthographicCamera camera);

    /**
     * Updates game map
     *
     * @param delta: Changes
     */
    public abstract void update(float delta);

    /**
     * Dispose game map
     */
    public abstract void dispose();

    /**
     * Gets a tile by pixel position within the game world at a specified layer.
     *
     * @param layer: Layer of the map
     * @param x:     Location of tile horizontally
     * @param y:     Location of tile vertically
     * @return str: Tile type
     */
    public TileType getTileTypeByLocation(int layer, float x, float y) {
        return this.getTileTypeByCoordinate(layer, (int) (x / TileType.TILE_SIZE), (int) (y / TileType.TILE_SIZE));
    }

    /**
     * Gets a tile at its coordinate within the map at a specified layer.
     *
     * @param layer: Layer of the map
     * @param col:   Location of tile horizontally
     * @param row:   Location of tile vertically
     * @return str: Tile type
     */
    public abstract TileType getTileTypeByCoordinate(int layer, int col, int row);

    /**
     * Gets width of the layer
     *
     * @return int: Width of layer
     */
    public abstract int getWidth();

    /**
     * Gets height of the layer
     *
     * @return int: Height of layer
     */
    public abstract int getHeight();

    /**
     * Gets amount of layers in map
     *
     * @return int: Amount of layers
     */
    public abstract int getLayers();

}
