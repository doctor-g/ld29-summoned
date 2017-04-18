package edu.bsu.pvgestwicki.ld29.core;

import react.Slot;
import tripleplay.game.ScreenStack;
import tripleplay.ui.Button;

public class FarOutScreen extends AbstractStoryScreen {

	public FarOutScreen(final ScreenStack screenStack) {
		super(screenStack, GameImage.FAR_OUT.image);
		root.add(new Button("Peer into the depths.")//
				.onClick(new Slot<Button>() {
					@Override
					public void onEmit(Button b) {
						transitionTo(new MadnessScreen(screenStack));
					}
				}));
		if (Attribute.WILLPOWER.asInt() >= 4) {
			root.add(new Button("Resist temptation.")//
					.onClick(new Slot<Button>() {
						@Override
						public void onEmit(Button event) {
							transitionTo(new FarOutScreen(screenStack));
						}
					}));
		}
	}

	@Override
	public String text() {
		if (isStupid()) {
			return "THIS IS NICE, TOO.";
		} else if (Attribute.FATE.asInt() >= 6) {
			return "The vessel bobs and rocks, moving inexorably to deeper waters. The air is still and quiet, as if nature recognizes the inevitability of fate. The water beckons.";
		} else {
			return "Your vessel bobs to the rhythm of the sea. The town becomes distant, a mere memory. The ocean is all that matters. It is calling you, inviting you see what lies beneath it.";
		}
	}

}
