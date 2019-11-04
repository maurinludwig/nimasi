package com.nimasi.game.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.nimasi.game.core.NimasiJumper;
import com.nimasi.game.core.highscore.HighscoreManager;

import java.util.List;

import static com.nimasi.game.core.NimasiJumper.HEIGHT;
import static com.nimasi.game.core.NimasiJumper.WIDTH;

/**
 * Main menu screen
 */
public class MenuScreen implements Screen {

    private final List<MenuButtonTypes> buttons;

    private static final int LOGO_WIDTH = 400;
    private static final int LOGO_HEIGHT = 100;
    private static final int LOGO_Y = 550;


    private NimasiJumper game;
    private HighscoreManager manager;

    private Texture logo;

    /**
     * Main menu constructor
     *
     * @param game: NimasiJumper game
     */
    public MenuScreen(NimasiJumper game) {
        this.game = game;
        buttons = List.of(MenuButtonTypes.values());
        logo = new Texture("nimasijumper.png");
        manager = new HighscoreManager();
    }

    /**
     * Shows screen
     */
    @Override
    public void show() {

    }

    /**
     * Renders screen
     *
     * @param delta: Delta time
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        game.batch.draw(logo, WIDTH / 2 - LOGO_WIDTH / 2 - 8, LOGO_Y, LOGO_WIDTH, LOGO_HEIGHT);

        buttons.forEach((button) -> {
            game.batch.draw(
                    isButtonActive(button) ? button.getActiveTexture() : button.getInactiveTexture(),
                    button.getPositionX(),
                    button.getPositionY(),
                    button.getWidth(),
                    button.getHeight()
            );

            if (isButtonActive(button) && Gdx.input.justTouched()) {
                switch (button) {
                    case PLAY: {
                        this.dispose();
                        game.setScreen(new GameScreen(game, manager));
                        break;
                    }
                    case HIGHSCORE: {
                        this.dispose();
                        game.setScreen(new HighscoreScreen(game, manager));
                        break;
                    }
                    case SETTINGS: {
                        this.dispose();
                        game.setScreen(new SettingsScreen(game));
                        break;
                    }
                    case QUIT: {
                        Gdx.app.exit();
                        break;
                    }
                    default:
                        throw new IllegalStateException("Button not found: " + button);
                }
            }

        });

        game.batch.end();

    }

    /**
     * Checks if mouse is hovering on a button.
     *
     * @param button: Button to check
     * @return boolean: True if mouse is on button
     */
    private static final boolean isButtonActive(MenuButtonTypes button) {
        return (Gdx.input.getX() < button.getPositionX() + button.getWidth() && // Checks bottom right corner
                Gdx.input.getX() > button.getPositionX() && // Checks bottom left corner
                HEIGHT - Gdx.input.getY() < button.getPositionY() + button.getHeight() && // Checks top right corner
                HEIGHT - Gdx.input.getY() > button.getPositionY()); // Checks top left corner
    }

    /**
     * Resizes screen
     *
     * @param width:  Width of window
     * @param height: Height of window
     */
    @Override
    public void resize(int width, int height) {

    }

    /**
     * Pauses screen
     */
    @Override
    public void pause() {

    }

    /**
     * Resumes screen
     */
    @Override
    public void resume() {

    }

    /**
     * Hides Screen
     */
    @Override
    public void hide() {

    }

    /**
     * Disposes Screen
     */
    @Override
    public void dispose() {

    }
}