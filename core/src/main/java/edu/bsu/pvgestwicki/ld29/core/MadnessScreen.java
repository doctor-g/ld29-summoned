package edu.bsu.pvgestwicki.ld29.core;

import react.Slot;
import tripleplay.game.ScreenStack;
import tripleplay.ui.Button;

public class MadnessScreen extends AbstractStoryScreen {

	public MadnessScreen(final ScreenStack screenStack) {
		super(screenStack, BLACK_IMAGE);

		final Button button = new Button("Embrace madness")//
				.setEnabled(false)//
				.onClick(new Slot<Button>() {
					@Override
					public void onEmit(Button event) {
						anim.tweenAlpha(layer)//
								.to(0)//
								.then()//
								.delay(5000f)// .
								.then()//
								.action(new Runnable() {
									public void run() {
										transitionTo(new CharacterCreationScreen(
												screenStack));
									}
								});
					}
				});
		button.layer.setAlpha(0);
		root.add(button);

		anim.delay(2000f)//
				.then()//
				.tweenAlpha(button.layer)//
				.to(1)//
				.easeIn()//
				.then()//
				.action(new Runnable() {
					@Override
					public void run() {
						button.setEnabled(true);
					}
				});
	}

	@Override
	public String text() {
		if (isStupid()) {
			return "MY BRAIN HURTS.";
		} else if (Attribute.FATE.asInt() >= 6) {
			return "There is no turning away from fate, no ignoring the beckons. The well-worn path is always before you, whether you see it or not. Yet, what force drives you forward? Is it still possible to hope?";
		} else {
			return "What you see, it cannot be unseen. Why would you want to return to the old ways now that you have glanced at eternity? It is not for the rest to understand.";
		}
	}

}
