package com.nimasi.game.core.config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

public class ConfigManager {

    private Json json = new Json();


    public Config readConfig() {
        if (Gdx.files.local("config.json").exists()) {
            FileHandle file = Gdx.files.local("config.json");
            return json.fromJson(Config.class, file);
        }
        return null;
    }

    public void saveConfig(Config config) {
        json.setOutputType(JsonWriter.OutputType.json);
        FileHandle file = Gdx.files.local("config.json");
        file.writeString(json.prettyPrint(config), false);
    }


}
