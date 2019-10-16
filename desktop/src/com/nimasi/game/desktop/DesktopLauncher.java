package com.nimasi.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nimasi.game.NimasiJumper;

/**
 * Starts NimasiJumper
 */
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.width = 800;
		config.height = 480;
		config.resizable = true;
		new LwjglApplication(new NimasiJumper(), config);
	}
}
