package edu.bsu.pvgestwicki.ld29.core;

import playn.core.Game;
import playn.core.util.Clock;
import react.UnitSlot;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;

public class DagonGame extends Game.Default {
	private static final int UPDATE_RATE = 33;

	private final Clock.Source clock = new Clock.Source(UPDATE_RATE);
	private final ScreenStack screenStack = new ScreenStack();

	public DagonGame() {
		super(UPDATE_RATE); // call update every 33ms (30 times per second)
	}

	@Override
	public void init() {
		LoadingScreen loading = new LoadingScreen();
		loading.onFinished(new UnitSlot() {
			@Override
			public void onEmit() {
				Screen screen = new CharacterCreationScreen(screenStack);
				screenStack.replace(screen);
				GameMusic.PLAYING.sound.play();
			}
		});
		screenStack.push(loading);
	}

	@Override
	public void update(int deltaMS) {
		clock.update(deltaMS);
		screenStack.update(deltaMS);
	}

	@Override
	public void paint(float alpha) {
		clock.paint(alpha);
		screenStack.paint(clock);
	}
}
