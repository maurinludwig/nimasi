package com.nimasi.game.core.screens;

import com.badlogic.gdx.graphics.Texture;

import static com.nimasi.game.core.NimasiJumper.WIDTH;

/**
 * Types of GameButtons
 */
public enum SettingsButtonTypes {
    MUSIC(
            WIDTH / 2 - Constants.MUSIC_WIDTH / 2, // Calculating the middle of the screen minus offset
            400,
            Constants.MUSIC_WIDTH,
            50,
            new Texture("play_highlighted.png"),
            new Texture("play.png")
    ),
    MUSIC_LOUDER(
            WIDTH / 2 - Constants.ARROW_WIDTH / 2, // Calculating the middle of the screen minus offset
            300,
            Constants.ARROW_WIDTH,
            50,
            new Texture("highscore_highlighted.png"),
            new Texture("highscore.png")
    ),
    MUSIC_QUIETER(
            WIDTH / 2 - Constants.ARROW_WIDTH / 2, // Calculating the middle of the screen minus offset
            200,
            Constants.ARROW_WIDTH,
            50,
            new Texture("settings_highlighted.png"),
            new Texture("settings.png")
    ),
    SOUNDS(
            WIDTH / 2 - Constants.SOUNDS_WIDTH / 2, // Calculating the middle of the screen minus offset
            100,
            Constants.SOUNDS_WIDTH,
            50,
            new Texture("quit_highlighted.png"),
            new Texture("quit.png")
    ),
    SOUNDS_LOUDER(
            WIDTH / 2 - Constants.ARROW_WIDTH / 2, // Calculating the middle of the screen minus offset
            100,
            Constants.ARROW_WIDTH,
            50,
            new Texture("quit_highlighted.png"),
            new Texture("quit.png")
    ),
    SOUNDS_QUIETER(
            WIDTH / 2 - Constants.ARROW_WIDTH / 2, // Calculating the middle of the screen minus offset
            100,
            Constants.ARROW_WIDTH,
            50,
            new Texture("quit_highlighted.png"),
            new Texture("quit.png")
    ),
    UPDATE_NAME(
            WIDTH / 2 - Constants.UPDATE_NAME_WIDTH / 2, // Calculating the middle of the screen minus offset
            100,
            Constants.UPDATE_NAME_WIDTH,
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
        static final int MUSIC_WIDTH = 150;
        static final int SOUNDS_WIDTH = 150;
        static final int ARROW_WIDTH = 50;
        static final int UPDATE_NAME_WIDTH = 350;
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
    SettingsButtonTypes(Integer posX, Integer posY, Integer width, Integer height, Texture activeTexture, Texture inactiveTexture) {
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
