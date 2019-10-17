package com.nimasi.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nimasi.game.NimasiJumper;

/**
 * Starts NimasiJumper with given config
 */
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.width = NimasiJumper.WIDTH;
		config.height = NimasiJumper.HEIGHT;
		config.resizable = false;
		new LwjglApplication(new NimasiJumper(), config);
	}
}
