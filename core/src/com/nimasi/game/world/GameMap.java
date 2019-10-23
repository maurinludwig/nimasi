package com.nimasi.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nimasi.game.entities.*;

import java.util.ArrayList;

/**
 * Nimasi Game Map
 */
public abstract class GameMap {

    private ArrayList<Entity> entities;
    public Player player;
    private int cloudsUsed = 0;

    GameMap() {
        entities = new ArrayList<>();
        player = new Player(220, 100, this);
        entities.add(player);
    }

    /**
     * Rendering game map with given cam
     * <
     *
     * @param camera: Orthographic Camera
     */
    public void render(OrthographicCamera camera, SpriteBatch batch) {
        camera.position.set(player.getX(), player.getY(), 0);
        camera.update();
        for (Entity entity : entities) {
            entity.render(batch);
        }

        BoundingRect playerRect = new BoundingRectImpl(
                player.getX(),
                player.getY() - 32f,
                player.getWidth(),
                player.getHeight()
        );

        if (Gdx.input.isKeyJustPressed(Input.Keys.F) && !doesRectCollideWithMap(playerRect) && cloudsUsed < 3) {
            cloudsUsed = cloudsUsed + 1;
            Cloud cloud = new Cloud(player.getX(), player.getY() - 32, this);
            entities.add(cloud);
        }
    }

    /**
     * Updates game map
     *
     * @param delta: Changes
     */
    public void update(float delta) {
        for (Entity entity : entities) {
            entity.update(delta, -15f);
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

    /**
     * Checks if rectangle collides with map.
     *
     * @param x:      X Position
     * @param y:      Y Position
     * @param width:  Width of rect
     * @param height: Height of rect
     * @return boolean
     */
    public boolean doesRectCollideWithMap(BoundingRect r) {
        float rightX = r.getX() + r.getWidth();
        float topY = r.getY() + r.getHeight();

        if (r.getX() <= 0 || r.getY() <= 0 || rightX >= getPixelWidth() || topY >= getPixelHeight()) {
            return true;
        }

        int leftOuterTileIndex = (int) (r.getX() / TileType.TILE_SIZE);
        int rightOuterTileIndex = (int) (rightX / TileType.TILE_SIZE);

        int bottomOuterTileIndex = (int) (r.getY() / TileType.TILE_SIZE);
        int topOuterTileIndex = (int) (topY / TileType.TILE_SIZE);

        for (int row = bottomOuterTileIndex; row <= topOuterTileIndex; row++) {
            for (int col = leftOuterTileIndex; col <= rightOuterTileIndex; col++) {
                TileType tile = getTileTypeByCoordinate(1, col, row);
                if (tile != null && tile.isCollidable()) {
                    return true;
                } else if (willRectCollideWithClouds(r)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean willRectCollideWithClouds(BoundingRect r) {
        return entities
                .stream()
                .filter(e -> e.getType().equals(EntityType.CLOUD))
                .anyMatch(r::isCollidingWithBoundingRect);
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

    /**
     * Gets pixel width
     *
     * @return int: width in pixel
     */
    public int getPixelWidth() {
        return this.getWidth() * TileType.TILE_SIZE;
    }

    /**
     * Gets pixel height
     *
     * @return int: height in pixel
     */
    public int getPixelHeight() {
        return this.getHeight() * TileType.TILE_SIZE;
    }

}
