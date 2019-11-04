package com.nimasi.game.core.highscore;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;

import java.util.*;

public class HighscoreManager {

    private Json json = new Json();


    public List<Highscore> readHighscores() {
        List<Highscore> highscores = new ArrayList<>();
        if (Gdx.files.local("highscores.json").exists()) {
            FileHandle file = Gdx.files.local("highscores.json");
            highscores = json.fromJson(ArrayList.class, Highscore.class, file);
            Collections.sort(highscores);
        }
        return highscores;
    }

    public void saveHighscore(Highscore highscore) {
        List<Highscore> highscores = readHighscores();
        highscores.add(highscore);
        json.setOutputType(JsonWriter.OutputType.json);
        FileHandle file = Gdx.files.local("highscores.json");
        file.writeString(json.prettyPrint(highscores), false);
    }

}
