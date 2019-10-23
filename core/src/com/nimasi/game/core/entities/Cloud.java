package com.nimasi.game.core.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nimasi.game.core.world.GameMap;

/**
 * Player Entity
 */
public class Cloud extends Entity {

    private Texture image;

    /**
     * Player Constructor
     *
     * @param x:   Player position x
     * @param y:   Player position y
     * @param map: Map
     */
    public Cloud(float x, float y, GameMap map) {
        super(x, y, EntityType.CLOUD, map);
        image = new Texture("cloud.png");
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

    @Override
    public String toString() {
        return String.format("<Cloud X=%.0f Y=%.0f W=%.0f H=%.0f>", getX(), getY(), getWidth(), getHeight());
    }
}
