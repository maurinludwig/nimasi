package com.nimasi.game.play.world;

import java.util.HashMap;

/**
 * Defines TileTypes
 */
public enum TileType {

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
     * @param int     id: Tile type id
     * @param boolean collidable: True if collidable
     * @param str     name: TileType Name
     */
    TileType(int id, boolean collidable, String name) {
        this(id, collidable, name, 0);
    }

    /**
     * Setting values for Tile Type
     *
     * @param int     id: Tile type id
     * @param boolean collidable: True if collidable
     * @param str     name: TileType Name
     * @param float   damage: Damage of tile
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
     * Gets collidable boolean
     *
     * @return bool: True if collidable
     */
    public boolean isCollidable() {
        return collidable;
    }

    /**
     * Gets name
     * @return str: Name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets damage
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
     * @param int id: Tile id
     * @return str: Tile type
     */
    public static TileType getTileTypeByID(int id) {
        return tileMap.get(id);
    }

}