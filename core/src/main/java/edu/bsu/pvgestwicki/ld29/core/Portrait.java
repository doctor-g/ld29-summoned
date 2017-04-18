package edu.bsu.pvgestwicki.ld29.core;

import static playn.core.PlayN.assets;
import playn.core.Image;

public enum Portrait {

	MUSTACHE_GUY("mustache.jpg"), //
	AMYLEVY("amylevy.jpg"), //
	BEARDO("beardo.jpg"), //
	BOOK_WOMAN("book_woman.jpg"), //
	GLASSES("glasses.jpg"), //
	HANDS_LADY("hands_lady.jpg"), //
	BOOK_MAN("book_man.jpg"), //
	SEPIA("sepia.jpg"), //
	HAT("hat.jpg"), //
	WOMAN("woman.png");

	public final Image image;

	private Portrait(String path) {
		image = assets().getImage("images/portraits/" + path);
	}

}
