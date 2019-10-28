package com.nimasi.game.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.nimasi.game.core.NimasiJumper;
import com.nimasi.game.core.highscore.Highscore;
import com.nimasi.game.core.highscore.HighscoreManager;

import java.util.List;

import static com.nimasi.game.core.NimasiJumper.HEIGHT;
import static com.nimasi.game.core.NimasiJumper.WIDTH;

public class HighscoreScreen implements Screen {

    private HighscoreManager manager;

    private final List<HighscoreButtonTypes> buttons;
    private NimasiJumper game;
    private static final int LOGO_WIDTH = 400;
    private static final int LOGO_HEIGHT = 100;
    private static final int LOGO_Y = 550;
    private Texture logo;
    private static GlyphLayout glyphLayoutName;
    private static GlyphLayout glyphLayoutScore;
    private static GlyphLayout glyphLayoutTime;
    private BitmapFont font = new BitmapFont(Gdx.files.internal("NimasiFont.fnt"));
    private GlyphLayout glyphLayoutNumber;


    public HighscoreScreen(NimasiJumper game, HighscoreManager manager) {
        this.game = game;
        this.manager = manager;
        buttons = List.of(HighscoreButtonTypes.values());
        logo = new Texture("highscore.png");
    }

    /**
     * Shows the screen
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

            if (isButtonActive(button) && Gdx.input.isTouched()) {
                switch (button) {
                    case BACK: {
                        this.dispose();
                        game.setScreen(new MenuScreen(game));
                        break;
                    }
                    default:
                        throw new IllegalStateException("Button not found: " + button);
                }
            }

        });
        glyphLayoutName = new GlyphLayout();
        glyphLayoutTime = new GlyphLayout();
        glyphLayoutScore = new GlyphLayout();
        glyphLayoutNumber = new GlyphLayout();

        glyphLayoutTime.setText(font, "SCORE", font.getColor(), 0, Align.right, false);

        font.draw(game.batch, "#", 50, 530);
        font.draw(game.batch, "NAME", 80, 530);
        font.draw(game.batch, "TIME", WIDTH / 2, 530);
        font.draw(game.batch, glyphLayoutTime, WIDTH - 50, 530);


        List<Highscore> highscores = manager.readHighscores();
        for (int i = 0; i < highscores.size() && i < 10; i++) {
            String score = String.format("%s", highscores.get(i).getScore());
            String time = String.format("%s", highscores.get(i).getTime());
            String currentNumber = String.format("%s", i +1);

            glyphLayoutNumber.setText(font, currentNumber);
            glyphLayoutName.setText(font, highscores.get(i).getName());
            glyphLayoutTime.setText(font, time);
            glyphLayoutScore.setText(font, score, font.getColor(), 0, Align.right, false);
            font.draw(game.batch, glyphLayoutNumber, 50, 500 - 30 * i);
            font.draw(game.batch, glyphLayoutName, 80, 500 - 30 * i);
            font.draw(game.batch, glyphLayoutTime, WIDTH / 2, 500 - 30 * i);
            font.draw(game.batch, glyphLayoutScore, WIDTH - 50, 500 - 30 * i);
        }
        game.batch.end();
    }

    /**
     * Checks if mouse is hovering on a button.
     *
     * @param button: Button to check
     * @return boolean: True if mouse is on button
     */
    private static final boolean isButtonActive(HighscoreButtonTypes button) {
        return Gdx.input.getX() < button.getPositionX() + button.getWidth() && Gdx.input.getX() > button.getPositionX() && HEIGHT - Gdx.input.getY() < button.getPositionY() + button.getHeight() && HEIGHT - Gdx.input.getY() > button.getPositionY();
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
