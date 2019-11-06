package com.nimasi.game.core.screens;

import com.badlogic.gdx.Input;
import com.nimasi.game.core.config.Config;
import com.nimasi.game.core.config.ConfigManager;

public class TextInputListener implements Input.TextInputListener {

    private ConfigManager manager = new ConfigManager();

    @Override
    public void input(String text) {
        Config currentConfig = manager.readConfig();
        manager.saveConfig(new Config(text, currentConfig.getSoundVol(), currentConfig.getMusicVol()));
    }

    @Override
    public void canceled() {

    }

}
