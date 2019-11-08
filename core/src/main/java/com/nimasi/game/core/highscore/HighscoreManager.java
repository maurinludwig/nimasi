package com.nimasi.game.core.highscore;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

import java.util.*;

/**
 * Manages Highscores and highscore file
 */
public class HighscoreManager {

    private Json json = new Json();

    /**
     * Reads highscores from file
     *
     * @return List: List of all saved highscores
     */
    public List<Highscore> readHighscores() {
        List<Highscore> highscores = new ArrayList<>();
        if (Gdx.files.local("highscores.json").exists()) {
            FileHandle file = Gdx.files.local("highscores.json");
            highscores = json.fromJson(ArrayList.class, Highscore.class, file);
            Collections.sort(highscores);
        }
        return highscores;
    }

    /**
     * Reads highscores, adds the new score to the list and saves it into a file
     *
     * @param highscore: New highscore to save
     */
    public void saveHighscore(Highscore highscore) {
        List<Highscore> highscores = readHighscores();
        highscores.add(highscore);
        json.setOutputType(JsonWriter.OutputType.json);
        FileHandle file = Gdx.files.local("highscores.json");
        file.writeString(json.prettyPrint(highscores), false);
    }

}
