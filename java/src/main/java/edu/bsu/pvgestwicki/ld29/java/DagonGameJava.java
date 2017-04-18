package edu.bsu.pvgestwicki.ld29.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;
import playn.java.JavaPlatform.Config;
import edu.bsu.pvgestwicki.ld29.core.DagonGame;
import edu.bsu.pvgestwicki.ld29.core.GameFont;

public class DagonGameJava {

	private static JavaPlatform platform;

	public static void main(String[] args) {
		platform = JavaPlatform.register(createConfig());
		registerFonts();
		PlayN.run(new DagonGame());
	}

	private static Config createConfig() {
		JavaPlatform.Config config = new JavaPlatform.Config();
		config.width = 800;
		config.height = 600;
		return config;
	}

	private static void registerFonts() {
		for (GameFont font : GameFont.values()) {
			platform.graphics().registerFont(font.name, font.path);
		}
	}
}
