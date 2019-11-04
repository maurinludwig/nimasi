package com.nimasi.game.core.world;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTile;

import java.util.HashMap;

/**
 * Defines TileTypes
 * A Tile is a 16 x 16 pixel block. Used to build the map.
 */
public enum TileType implements TiledMapTile {

    GRASS(1, true, "Grass"),
    DIRT(2, true, "Dirt"),
    SKY(3, false, "Sky"),
    LAVA(4, true, "Lava"),
    CLOUD(5, true, "Cloud"),
    STONES(6, true, "Stones");

    public static final int TILE_SIZE = 16;

    private int id;
    private boolean collidable;
    private String name;
    private float damage;

    /**
     * Constructor for Tile Type
     *
     * @param id:         Tile type id
     * @param collidable: True if collidable
     * @param name:       TileType Name
     */
    TileType(int id, boolean collidable, String name) {
        this(id, collidable, name, 0);
    }

    /**
     * Setting values for Tile Type
     *
     * @param id:         Tile type id
     * @param collidable: True if collidable
     * @param name:       TileType Name
     * @param damage:     Damage of tile
     */
    TileType(int id, boolean collidable, String name, float damage) {
        this.id = id;
        this.collidable = collidable;
        this.name = name;
        this.damage = damage;
    }

    /**
     * Gets id
     *
     * @return int: id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id
     *
     * @param id: id to set
     */
    @Override
    public void setId(int id) {

    }

    /**
     * @return the {@link BlendMode} to use for rendering the tile (not used)
     */
    @Override
    public BlendMode getBlendMode() {
        return null;
    }

    /**
     * Sets the {@link BlendMode} to use for rendering the tile (not used)
     *
     * @param blendMode the blend mode to use for rendering the tile
     */
    @Override
    public void setBlendMode(BlendMode blendMode) {

    }

    /**
     * Gets texture region (not used)
     *
     * @return texture region used to render the tile
     */
    @Override
    public TextureRegion getTextureRegion() {
        return null;
    }

    /**
     * Sets texture region (not used)
     *
     * @param textureRegion TextureRegion: used to render the tile
     */
    @Override
    public void setTextureRegion(TextureRegion textureRegion) {

    }

    /**
     * Gets x offset (not used)
     *
     * @return the amount to offset the x position when rendering the tile
     */
    @Override
    public float getOffsetX() {
        return 0;
    }

    /**
     * Set the amount to offset the x position when rendering the tile (not used)
     *
     * @param offsetX float: X axis offset
     */
    @Override
    public void setOffsetX(float offsetX) {

    }

    /**
     * Gets y offset (not used)
     *
     * @return the amount to offset the y position when rendering the tile
     */
    @Override
    public float getOffsetY() {
        return 0;
    }

    /**
     * Set the amount to offset the y position when rendering the tile (not used)
     *
     * @param offsetY float: Y axis offset
     */
    @Override
    public void setOffsetY(float offsetY) {

    }

    /**
     * Gets properties (not used)
     *
     * @return tile's properties set
     */
    @Override
    public MapProperties getProperties() {
        return null;
    }

    /**
     * Gets collidable boolean
     *
     * @return bool: True if collidable
     */
    public boolean isCollidable() {
        return collidable;
    }

    /**
     * Gets name
     *
     * @return str: Name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets damage
     *
     * @return float: Damage
     */
    public float getDamage() {
        return damage;
    }

    /**
     * Initializing HashMap
     */
    private static HashMap<Integer, TileType> tileMap;

    static {
        tileMap = new HashMap<Integer, TileType>();
        for (TileType tileType : TileType.values()) {
            tileMap.put(tileType.getId(), tileType);
        }
    }

    /**
     * Gets tile type.
     *
     * @param id: Tile id
     * @return str: Tile type
     */
    public static TileType getTileTypeByID(int id) {
        return tileMap.get(id);
    }

}