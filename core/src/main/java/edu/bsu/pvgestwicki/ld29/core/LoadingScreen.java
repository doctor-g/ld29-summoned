package edu.bsu.pvgestwicki.ld29.core;

import static playn.core.PlayN.graphics;
import playn.core.AssetWatcher;
import playn.core.AssetWatcher.Listener;
import react.UnitSignal;
import react.UnitSlot;
import tripleplay.game.UIScreen;
import tripleplay.ui.Label;
import tripleplay.ui.Root;
import tripleplay.ui.Style;
import tripleplay.ui.layout.AxisLayout;
import tripleplay.util.Colors;

public class LoadingScreen extends UIScreen {

	private final UnitSignal onFinished = new UnitSignal();
	private final AssetWatcher watcher;

	public LoadingScreen() {
		watcher = new AssetWatcher(new Listener() {
			@Override
			public void error(Throwable e) {
				throw new IllegalStateException(e);
			}

			@Override
			public void done() {
				onFinished.emit();
			}
		});
		for (GameImage gi : GameImage.values()) {
			watcher.add(gi.image);
		}
		for (Portrait p : Portrait.values()) {
			watcher.add(p.image);
		}
		for (GameMusic m : GameMusic.values()) {
			watcher.add(m.sound);
		}

		initUI();
	}

	private void initUI() {
		Root root = iface.createRoot(AxisLayout.vertical(), DagonStyle.SHEET,
				layer)//
				.setSize(graphics().width(), graphics().height());
		root.add(new Label("Loading...")//
				.addStyles(Style.COLOR.is(Colors.LIGHT_GRAY),//
						Style.FONT.is(GameFont.REGULAR.atSize(32))));
	}

	@Override
	public void wasAdded() {
		watcher.start();
	}

	public LoadingScreen onFinished(UnitSlot slot) {
		onFinished.connect(slot);
		return this;
	}

}
