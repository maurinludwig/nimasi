package com.nimasi.game.core.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.nimasi.game.core.world.GameMap;

/**
 * Entity Methods
 */
public abstract class Entity implements BoundingRect {

    Vector2 pos;
    private EntityType type;
    float velocityY = 0;
    GameMap map;
    boolean grounded = false;

    /**
     * Constructor
     *
     * @param x    :    Vertical location
     * @param y    :    Horizontal location
     * @param type : Entity Type
     * @param map  :  Game Map
     */
    Entity(float x, float y, EntityType type, GameMap map) {
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
    }

    /**
     * Renders entities
     *
     * @param batch: Sprite Batch of game
     */
    public abstract void render(SpriteBatch batch);


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
    float getWeight() {
        return type.getWeight();
    }

    /**
     * Gets boolean if given bounding rect is colliding with a bounding rect.
     *
     * @return boolean: collides with bounding rect
     */
    public boolean isCollidingWithBoundingRect(BoundingRect r) {
        return BoundingRectImpl.doBoundingRectsCollide(this, r);
    }

    /**
     * Checks if new X would collide with something, if it doesn't collides with something, sets new X as x.
     *
     * @param newX float: new X axis to check/set
     */
    void moveX(float newX) {

        if (type.isCollidable() && map.doesRectCollideWithMap(new BoundingRectImpl(newX, getY(), getWidth(), getHeight()))) {
            return;
        }

        pos.x = newX;
    }

    /**
     * Checks if new Y would collide with something, if it doesn't collides with something, sets new Y as y.
     *
     * @param newY float: new Y axis to check/set
     */
    void moveY(float newY) {
        if (type.isCollidable() && map.doesRectCollideWithMap(new BoundingRectImpl(getX(), newY, getWidth(), getHeight()))) {
            grounded = true;
            return;
        }

        pos.y = newY;
    }
}
