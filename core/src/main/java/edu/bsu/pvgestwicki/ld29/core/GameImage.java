package edu.bsu.pvgestwicki.ld29.core;

import static playn.core.PlayN.assets;
import playn.core.Image;

public enum GameImage {

	TOWN("town.jpg"), //
	LIGHTHOUSE("lighthouse.jpg"), //
	SLOOP("sloop.jpg"), //
	FAR_OUT("far_out.jpg");

	public final Image image;

	private GameImage(String name) {
		this.image = assets().getImage("images/" + name);
	}

}
