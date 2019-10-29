package com.nimasi.game.core.screens;

import com.badlogic.gdx.graphics.Texture;

import static com.nimasi.game.core.NimasiJumper.WIDTH;

/**
 * Types of GameButtons
 */
public enum MenuButtonTypes {
    PLAY(
            WIDTH / 2 - Constants.PLAY_WIDTH / 2, // Calculating the middle of the screen minus offset
            400,
            Constants.PLAY_WIDTH,
            50,
            new Texture("play_highlighted.png"),
            new Texture("play.png")
    ),
    HIGHSCORE(
            WIDTH / 2 - Constants.HIGHSCORE_WIDTH / 2, // Calculating the middle of the screen minus offset
            300,
            Constants.HIGHSCORE_WIDTH,
            50,
            new Texture("highscore_highlighted.png"),
            new Texture("highscore.png")
    ),
    SETTINGS(
            WIDTH / 2 - Constants.SETTINGS_WIDTH / 2, // Calculating the middle of the screen minus offset
            200,
            Constants.SETTINGS_WIDTH,
            50,
            new Texture("settings_highlighted.png"),
            new Texture("settings.png")
    ),
    QUIT(
            WIDTH / 2 - Constants.QUIT_WIDTH / 2, // Calculating the middle of the screen minus offset
            100,
            Constants.QUIT_WIDTH,
            50,
            new Texture("quit_highlighted.png"),
            new Texture("quit.png")
    );

    private Integer positionX;
    private Integer positionY;
    private Integer width;
    private Integer height;
    Texture activeTexture;
    Texture inactiveTexture;

    private static class Constants {
        static final int PLAY_WIDTH = 150;
        static final int HIGHSCORE_WIDTH = 250;
        static final int SETTINGS_WIDTH = 250;
        static final int QUIT_WIDTH = 100;
    }

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
    MenuButtonTypes(Integer posX, Integer posY, Integer width, Integer height, Texture activeTexture, Texture inactiveTexture) {
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
