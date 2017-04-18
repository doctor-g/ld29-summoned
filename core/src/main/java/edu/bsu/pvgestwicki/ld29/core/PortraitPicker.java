package edu.bsu.pvgestwicki.ld29.core;

import react.Slot;
import tripleplay.ui.Button;
import tripleplay.ui.Group;
import tripleplay.ui.Icons;
import tripleplay.ui.Label;
import tripleplay.ui.Shim;
import tripleplay.ui.Style;
import tripleplay.ui.Styles;
import tripleplay.ui.layout.AxisLayout;

public class PortraitPicker extends Group {

	private static int index = 0;
	private Label imageLabel = new Label();

	public PortraitPicker() {
		super(AxisLayout.vertical());

		updateImageForIndex();
		add(imageLabel, //
				new Shim(0, 6f), //
				controlGroup());
	}

	private void updateImageForIndex() {
		imageLabel.icon.update(Icons.image(Portrait.values()[index].image));
	}

	private Group controlGroup() {
		Styles buttonStyle = Styles.make(//
				Style.FONT.is(GameFont.REGULAR.atSize(32)));
		return new Group(AxisLayout.horizontal())//
				.add(new Button("\u261c")//
						.addStyles(buttonStyle)//
						.onClick(new Slot<Button>() {
							@Override
							public void onEmit(Button event) {
								index--;
								if (index < 0)
									index = Portrait.values().length - 1;
								updateImageForIndex();
							}
						}), //
						new Shim(6f, 0),//
						new Button("\u261e")//
								.addStyles(buttonStyle)//
								.onClick(new Slot<Button>() {
									@Override
									public void onEmit(Button event) {
										index = (index + 1)
												% Portrait.values().length;
										updateImageForIndex();
									}
								}));
	}
}
