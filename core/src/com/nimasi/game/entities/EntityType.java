package com.nimasi.game.entities;

/**
 * Declares EntityType
 */
public enum EntityType {

    PLAYER("player", 14, 32, 40);

    private String id;
    private int width, height;
    private float weight;

    /**
     * Constructor
     *
     * @param id:     Entity ID
     * @param width:  Width from Entity
     * @param height: Height from Entity
     * @param weight: Width from Entity
     */
    EntityType(String id, int width, int height, float weight) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.weight = weight;
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
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets Weight
     * @return weight
     */
    public float getWeight() {
        return weight;
    }
}
