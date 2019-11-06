package com.nimasi.game.core.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nimasi.game.core.world.GameMap;

import java.time.temporal.JulianFields;

/**
 * Player Entity
 */
public class Player extends Entity {

    private static final int SPEED = 95;
    private static final int JUMP_VELOCITY = 7;

    private Texture image;
    private boolean isJumping = false;
    private boolean jetpack = false;

    /**
     * Player Constructor
     *
     * @param x:   Player position x
     * @param y:   Player position y
     * @param map: Map
     */
    public Player(float x, float y, GameMap map) {
        super(x, y, EntityType.PLAYER, map);
        image = new Texture("player.png");
    }

    /**
     * Updates the game
     *
     * @param deltaTime: Time since last game update
     * @param gravity:   Gravity factor
     */
    @Override
    public void update(float deltaTime, float gravity) {
        // Handle gravity
        boolean collidesWithMap = map.doesRectCollideWithMap(this);

        if (collidesWithMap && !isJumping) {
            velocityY = 0;
            grounded = true;
        } else if (!grounded) {
            isJumping = false;
        } else if (!collidesWithMap) {
            grounded = false;
        }

        // Apply gravity or move if velocity is not 0
        if (!grounded || velocityY != 0) {
            if (!jetpack) {
                velocityY += gravity * deltaTime * getWeight();
                moveY(pos.y + (velocityY * deltaTime));
            }
        }

        // Handle Jumps
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && grounded && !jetpack) {
            velocityY += JUMP_VELOCITY * getWeight();
            isJumping = true;
            grounded = false;
        } else if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !grounded && this.velocityY > 0) {
            this.velocityY += JUMP_VELOCITY * getWeight() * deltaTime;
        }

        // Handle horizontal movement
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveX(pos.x + (-SPEED * deltaTime));
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveX(pos.x + (SPEED * deltaTime));
        }

        if (grounded)
            velocityY = 0;


        if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT) && Gdx.input.isKeyJustPressed(Input.Keys.J) && !jetpack) {
            System.out.println("JETPACK MODE ON");
            jetpack = true;
        } else if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT) && Gdx.input.isKeyJustPressed(Input.Keys.J) && jetpack) {
            System.out.println("JETPACK MODE OFF");
            jetpack = false;
        }

        if (jetpack) {
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                moveY(pos.y + JUMP_VELOCITY);
                isJumping = true;
                grounded = false;
                this.velocityY += JUMP_VELOCITY * getWeight() * deltaTime;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                moveY(pos.y - JUMP_VELOCITY);
                isJumping = true;
                grounded = false;
                this.velocityY -= JUMP_VELOCITY * getWeight() * deltaTime;
            }
        }

    }

    /**
     * Renders the game
     *
     * @param batch: Sprite Batch
     */
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());

    }

    /**
     * Converts player coordinates to a string (used for debug)
     *
     * @return String: Player coordinates
     */
    @Override
    public String toString() {
        return String.format("<Player X=%.0f Y=%.0f W=%.0f H=%.0f>", getX(), getY(), getWidth(), getHeight());
    }
}
