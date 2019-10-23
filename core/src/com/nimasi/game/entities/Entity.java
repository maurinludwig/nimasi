package com.nimasi.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.nimasi.game.world.GameMap;

/**
 * Entity Methods
 */
public abstract class Entity implements BoundingRect {

    protected Vector2 pos;
    protected EntityType type;
    protected float velocityY = 0;
    protected GameMap map;
    protected boolean grounded = false;

    /**
     * Constructor
     *
     * @param x    :    Vertical location
     * @param y    :    Horizontal location
     * @param type : Entity Type
     * @param map  :  Game Map
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
    public void update(float deltaTime, float gravity) {}
//    public void update(float deltaTime, float gravity) {
//        float newY = pos.y;
//
//        this.velocityY += gravity * deltaTime * getWeight();
//        newY += this.velocityY * deltaTime;
//
//        boolean collidesWithCloud = map.willRectCollideWithClouds(new BoundingRectImpl(
//                pos.x,
//                newY,
//                getWidth(),
//                getHeight()
//        ));
//
//        boolean collidesWithMap = map.doesRectCollideWithMap(pos.x, newY, getWidth(), getHeight());
//
//        if (collidesWithMap || collidesWithCloud) {
//            velocityY = 0;
//            grounded = true;
//            pos.y = (float) Math.floor(pos.y);
//        } else {
//            this.pos.y = newY;
//            grounded = false;
//
//        }
//    }

    public abstract void render(SpriteBatch batch);

    /**
     * Check if new theoretical position is not colliding. If not colliding set new position.
     *
     * @param amount: Amount of pixels to move
     */
//    void moveX(float amount) {
//        float newX = pos.x + amount;
//        boolean collidesWithCloud = map.willRectCollideWithClouds(new BoundingRectImpl(
//                newX,
//                pos.y,
//                getWidth(),
//                getHeight()
//        ));
//        if (!map.doesRectCollideWithMap(newX, pos.y, getWidth(), getHeight()) && !collidesWithCloud) {
//            this.pos.x = newX;
//        }
//    }

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
    public float getWidth() {
        return type.getWidth();
    }

    /**
     * Gets Height
     *
     * @return int: height
     */
    public float getHeight() {
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

    public boolean isCollidingWithBoundingRect(BoundingRect r) {
        return BoundingRectImpl.doBoundingRectsCollide(this, r);
    }

    public void moveX(float newX) {

        if (type.isCollidable() && map.doesRectCollideWithMap(new BoundingRectImpl(newX, getY(), getWidth(), getHeight()))) {
            System.out.println(newX + " " + getY() + " " + getWidth() + " " + getHeight());
            System.out.println(String.format("[%s] cannot move X, would collide", this));
            return;
        }

        pos.x = newX;
    }

    public void moveY(float newY) {
        if (type.isCollidable() && map.doesRectCollideWithMap(new BoundingRectImpl(getX(), newY, getWidth(), getHeight()))) {
            System.out.println(getX() + " " + newY + " " + getWidth() + " " + getHeight());
            System.out.println(String.format("[%s] cannot move Y, would collide", this));
            grounded = true;
            return;
        }

        pos.y = newY;
    }
}
