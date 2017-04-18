package edu.bsu.pvgestwicki.ld29.core;

import playn.core.Font;
import tripleplay.ui.Button;
import tripleplay.ui.Label;
import tripleplay.ui.SimpleStyles;
import tripleplay.ui.Style;
import tripleplay.ui.Stylesheet;
import tripleplay.util.Colors;

public class DagonStyle {

	public static final Stylesheet SHEET;
	static {
		Font font = GameFont.REGULAR.atSize(16);

		SHEET = SimpleStyles
				.newSheetBuilder()
				.add(Label.class, Style.FONT.is(font),
						Style.COLOR.is(Colors.LIGHT_GRAY))//
				.add(Button.class, Style.FONT.is(font))//
				.create();
	}

}
