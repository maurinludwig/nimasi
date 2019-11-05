package com.nimasi.game.core.screens;

import com.badlogic.gdx.graphics.Texture;

import static com.nimasi.game.core.NimasiJumper.WIDTH;

/**
 * Types of GameButtons
 */
public enum HighscoreButtonTypes {
    BACK(
            20,
            700 - 35,
            75,
            35,
            new Texture("back_highlighted.png"),
            new Texture("back.png")
    );

    private Integer positionX;
    private Integer positionY;
    private Integer width;
    private Integer height;
    Texture activeTexture;
    Texture inactiveTexture;

    /**
     * GameButton-types Constructor
     *
     * @param posX:            X position of button
     * @param posY:            Y position of button
     * @param width:           Width of button
     * @param height:          Height of button
     * @param activeTexture:   Texture of button when hovered
     * @param inactiveTexture: Texture of button when not hovered
     */
    HighscoreButtonTypes(Integer posX, Integer posY, Integer width, Integer height, Texture activeTexture, Texture inactiveTexture) {
        this.positionX = posX;
        this.positionY = posY;
        this.width = width;
        this.height = height;
        this.activeTexture = activeTexture;
        this.inactiveTexture = inactiveTexture;
    }

    /**
     * Gets x position of button
     *
     * @return int: X position of button
     */
    public Integer getPositionX() {
        return positionX;
    }

    /**
     * Gets y position of button
     *
     * @return int: Y position of button
     */
    public Integer getPositionY() {
        return positionY;
    }

    /**
     * Gets width of button
     *
     * @return int: Width of button
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Gets height of button
     *
     * @return int: Height of button
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Gets active texture of button
     *
     * @return Texture: Texture of button when hovered
     */
    public Texture getActiveTexture() {
        return activeTexture;
    }

    /**
     * Gets inactive texture of button
     *
     * @return Texture: Texture of button when not hovered
     */
    public Texture getInactiveTexture() {
        return inactiveTexture;
    }
}
