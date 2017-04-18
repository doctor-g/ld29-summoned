package edu.bsu.pvgestwicki.ld29.core;

import react.Slot;
import tripleplay.game.ScreenStack;
import tripleplay.ui.Button;

public class TownScreen extends AbstractStoryScreen {

	public TownScreen(final ScreenStack screenStack) {
		super(screenStack, GameImage.TOWN.image);

		if (Attribute.PHYSIQUE.asInt() == 0) {
			root.add(new Button("Collapse.")//
					.onClick(new Slot<Button>() {
						@Override
						public void onEmit(Button event) {
							transitionTo(new MadnessScreen(screenStack));
						}
					}));
		} else if (Attribute.WILLPOWER.asInt() == 0) {
			root.add(new Button("Close your eyes.")//
					.onClick(new Slot<Button>() {
						@Override
						public void onEmit(Button event) {
							transitionTo(new MadnessScreen(screenStack));
						}
					}));
		} else {
			root.add(new Button("Go toward the lighthouse.")//
					.onClick(new Slot<Button>() {
						@Override
						public void onEmit(Button event) {
							transitionTo(new LighthouseScreen(screenStack));
						}
					}));
		}
		if (Attribute.WILLPOWER.asInt() >= 4) {
			root.add(new Button("Head to the docks.")//
					.onClick(new Slot<Button>() {
						@Override
						public void onEmit(Button event) {
							transitionTo(new SloopScreen(screenStack));
						}
					}));
		}
	}

	@Override
	public String text() {
		if (isStupid()) {
			return "THIS PLACE IS NICE.";
		} else if (Attribute.FATE.asInt() >= 6) {
			return "The town is a constant: it is always the same. The people, their stories, the workaday life. The path must lead to the source of the light.";
		} else if (Attribute.FATE.asInt() >= 4) {
			return "The people of this quiet New England town seem unaware of the ancient evils that happened here, but it has left indelible marks upon their souls. You know the answer lies at the lighthouse.";
		} else {
			return "The denizens of this quiet New England town ignore you as they complete their daily chores, not unfriendly but not entirely welcoming. There is something eerie here. You feel compelled to walk to the lighthouse at the edge of town, from which you can survey the area.";
		}
	}
}
