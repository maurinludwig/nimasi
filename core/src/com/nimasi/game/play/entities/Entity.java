package com.nimasi.game.play.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.nimasi.game.play.world.GameMap;

/**
 * Entity Methods
 */
public abstract class Entity {

    protected Vector2 pos;
    protected EntityType type;
    protected float velocityY = 0;
    protected GameMap map;
    protected boolean grounded = false;

    /**
     * Constructor
     *
     * @param x:    Vertical location
     * @param y:    Horizontal location
     * @param type: Entity Type
     * @param map:  Game Map
     */
    public Entity(float x, float y, EntityType type, GameMap map) {
        this.pos = new Vector2(x, y);
        this.type = type;
        this.map = map;
    }

    /**
     * Updates Entities
     *
     * @param deltaTime: Time since last game update
     * @param gravity:   Gravity factor
     */
    public void update(float deltaTime, float gravity) {
        float newY = pos.y;

        this.velocityY += gravity * deltaTime * getHeight();
        newY += this.velocityY * deltaTime;

        if (map.doesRectCollideWithMap(pos.x, newY, getWidth(), getHeight())) {
            if (velocityY < 0) {
                this.pos.y = (float) Math.floor(pos.y);
                grounded = true;
            }
            this.velocityY = 0;
        } else {
            this.pos.y = newY;
            grounded = false;
        }
    }

    public abstract void render(SpriteBatch batch);

    /**
     * Check if new theoretical position is not colliding. If not colliding set new position.
     *
     * @param amount: Amount of pixels to move
     */
    protected void moveX(float amount) {
        float newX = pos.x + amount;
        if (!map.doesRectCollideWithMap(newX, pos.y, getWidth(), getHeight())) {
            this.pos.x = newX;
        }
    }

    /**
     * Gets Postition
     *
     * @return Vector2: Position
     */
    public Vector2 getPos() {
        return pos;
    }

    /**
     * Gets X Location
     *
     * @return float: X Location
     */
    public float getX() {
        return pos.x;
    }

    /**
     * Gets Y Location
     *
     * @return float: Y Location
     */
    public float getY() {
        return pos.y;
    }

    /**
     * Gets Entity Type
     *
     * @return string: Entity Type
     */
    public EntityType getType() {
        return type;
    }

    /**
     * Checks if is Grounded
     *
     * @return boolean
     */
    public boolean isGrounded() {
        return grounded;
    }

    /**
     * Gets Width
     *
     * @return float: width
     */
    public int getWidth() {
        return type.getWidth();
    }

    /**
     * Gets Height
     *
     * @return int: height
     */
    public int getHeight() {
        return type.getHeight();
    }

    /**
     * Gets Weight
     *
     * @return int: weight
     */
    public float getWeight() {
        return type.getWeight();
    }
}
