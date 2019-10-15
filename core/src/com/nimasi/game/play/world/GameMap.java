package com.nimasi.game.play.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nimasi.game.play.entities.Entity;
import com.nimasi.game.play.entities.Player;

import java.util.ArrayList;

/**
 * Nimasi Game Map
 */
public abstract class GameMap {

    protected ArrayList<Entity> entities;

    public GameMap() {
        entities = new ArrayList<Entity>();
        entities.add(new Player(40, 700, this));
    }

    /**
     * Rendering game map with given cam
     *
     * @param camera: Orthographic Camera
     */
    public void render(OrthographicCamera camera, SpriteBatch batch) {
        for (Entity entity : entities) {
            entity.render(batch);
        }
    }

    /**
     * Updates game map
     *
     * @param delta: Changes
     */
    public void update(float delta) {
        for (Entity entity : entities) {
            entity.update(delta, -9.8f);
        }
    }

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

    public boolean doesRectCollideWithMap(float x, float y, int width, int height) {
        if (x < 0 || y < 0 || x + width > getPixelWidth() || y + height > getPixelHeight()) {
            return true;
        }

        for (int row = (int) (y / TileType.TILE_SIZE); row < Math.ceil((y + height) / TileType.TILE_SIZE); row++) {
            for (int col = (int) (x / TileType.TILE_SIZE); col < Math.ceil((x + width) / TileType.TILE_SIZE); col++) {
                for (int layer = 0; layer < getLayers(); layer++) {
                    TileType type = getTileTypeByCoordinate(layer, col, row);
                    if (type != null && type.isCollidable())
                        return true;
                }
            }
        }
        return false;
    }

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

    public int getPixelWidth() {
        return this.getWidth() * TileType.TILE_SIZE;
    }

    public int getPixelHeight() {
        return this.getHeight() * TileType.TILE_SIZE;
    }

}
