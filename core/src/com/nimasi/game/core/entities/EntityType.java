package com.nimasi.game.core.entities;

/**
 * Declares EntityType
 */
public enum EntityType {

    CLOUD("cloud", 16, 16, 0, false),
    PLAYER("player", 20, 40, 50, true);
    private String id;
    private int width, height;
    private float weight;
    private boolean collidable;

    /**
     * Constructor
     *
     * @param id:     Entity ID
     * @param width:  Width from Entity
     * @param height: Height from Entity
     * @param weight: Width from Entity
     */
    EntityType(String id, int width, int height, float weight, boolean collidable) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.collidable = collidable;
    }

    /**
     * Gets ID
     *
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * Gets width
     *
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets height
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets Weight
     *
     * @return weight
     */
    public float getWeight() {
        return weight;
    }

    public boolean isCollidable() {
        return collidable;
    }
}
