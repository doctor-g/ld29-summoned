package edu.bsu.pvgestwicki.ld29.core;

import react.Slot;
import tripleplay.game.ScreenStack;
import tripleplay.ui.Button;

public class SloopScreen extends AbstractStoryScreen {

	public SloopScreen(final ScreenStack screenStack) {
		super(screenStack, GameImage.SLOOP.image);
		root.add(new Button("Climb aboard.")//
				.onClick(new Slot<Button>() {
					@Override
					public void onEmit(Button event) {
						transitionTo(new FarOutScreen(screenStack));
					}
				}));
		if (Attribute.PHYSIQUE.asInt() >= 4
				&& Attribute.PHYSIQUE.asInt() < 6) {
			root.add(new Button("Push the sailor away and take his boat.")//
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
			return "OOH, BOATS ARE NICE.";
		} else if (Attribute.FATE.asInt() >= 6) {
			return "The old sailor at the docks knows you, and you know him. Though the tides come and go, the ocean remains the same. Did he beckon you? Did you summon him? It does not matter.";
		} else if (Attribute.PHYSIQUE.asInt() >= 6) {
			return "A grizzled old sailor rests by his boat, but the water summons you. You push the old man away and cast off in his boat.";
		} else {
			return "At the docks, you meet a grizzled old sailor who offers to take you out to sea. How did he know that you were heeding the summons of the water? It doesn't matter: you must get to the ocean.";
		}
	}
}
