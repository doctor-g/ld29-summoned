package edu.bsu.pvgestwicki.ld29.core;

import react.Slot;
import tripleplay.game.ScreenStack;
import tripleplay.ui.Button;

public class LighthouseScreen extends AbstractStoryScreen {

	public LighthouseScreen(final ScreenStack screenStack) {
		super(screenStack, GameImage.LIGHTHOUSE.image);
		root.add(new Button("Walk to the docks.")//
				.onClick(new Slot<Button>() {
					@Override
					public void onEmit(Button event) {
						transitionTo(new SloopScreen(screenStack));
					}
				}));
	}

	@Override
	public String text() {
		if (isStupid()) {
			return "IT IS SHINY!";
		} else if (Attribute.FATE.asInt() >= 6) {
			return "The beacon offers the illusion of choice. Should the ship sail where the light shines, it will end up in the same place. You will end up in the same place.";
		} else {
			return "From here, you can see the shape of the town as well as the docks, the bay, and the great ocean beyond. The smell of saltwater is strong here, and you feel drawn to the waters.";
		}
	}

}
