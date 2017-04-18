package edu.bsu.pvgestwicki.ld29.core;

import static playn.core.PlayN.assets;
import playn.core.Sound;

public enum GameMusic {

	PLAYING("rachmaninoff");

	public final Sound sound;

	private GameMusic(String path) {
		sound = assets().getSound("music/" + path);
		sound.setLooping(true);
	}
}
