package com.nimasi.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nimasi.game.world.GameMap;

/**
 * Player Entity
 */
public class Player extends Entity {

    private static final int SPEED = 95;
    private static final int JUMP_VELOCITY = 7;

    Texture image;

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
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && grounded) {
            this.velocityY += JUMP_VELOCITY * getWeight();
        } else if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !grounded && this.velocityY > 0) {
            this.velocityY += JUMP_VELOCITY * getWeight() * deltaTime;
        }

        super.update(deltaTime, gravity);

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveX(-SPEED * deltaTime);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveX(SPEED * deltaTime);
        }
    }

    /**
     * Renders the game
     *
     * @param batch: Batch Var
     */
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());

    }
}
