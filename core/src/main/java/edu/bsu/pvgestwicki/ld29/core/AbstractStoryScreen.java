package edu.bsu.pvgestwicki.ld29.core;

import static com.google.common.base.Preconditions.checkNotNull;
import static playn.core.PlayN.graphics;
import playn.core.CanvasImage;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;
import tripleplay.game.UIAnimScreen;
import tripleplay.game.trans.FadeTransition;
import tripleplay.ui.Background;
import tripleplay.ui.Label;
import tripleplay.ui.Root;
import tripleplay.ui.Style;
import tripleplay.ui.layout.AxisLayout;
import tripleplay.util.Colors;

public abstract class AbstractStoryScreen extends UIAnimScreen {

	protected static final CanvasImage BLACK_IMAGE = graphics().createImage(
			graphics().width(), graphics().height());
	static {
		BLACK_IMAGE.canvas().setFillColor(Colors.BLACK)//
				.fillRect(0, 0, BLACK_IMAGE.width(), BLACK_IMAGE.height());
	}

	protected Root root;
	protected ScreenStack screenStack;

	public AbstractStoryScreen(ScreenStack screenStack, Image image) {
		this.screenStack = checkNotNull(screenStack);

		ImageLayer bg = graphics().createImageLayer(BLACK_IMAGE);
		layer.add(bg);

		ImageLayer imageLayer = graphics().createImageLayer(image);
		layer.add(imageLayer);

		GroupLayer.Clipped bottomLayer = graphics().createGroupLayer(700, 150);
		bottomLayer.setTranslation(25, 425);
		layer.add(bottomLayer);

		root = iface
				.createRoot(AxisLayout.vertical().offStretch(),
						DagonStyle.SHEET, bottomLayer)
				.setSize(bottomLayer.width(), bottomLayer.height())//
				.addStyles(Style.BACKGROUND.is(Background.solid(Colors.BLACK)))//
				.add(new Label(text())//
						.addStyles(Style.COLOR.is(Colors.LIGHT_GRAY),//
								Style.HALIGN.left,//
								Style.TEXT_WRAP.on));
	}

	public abstract String text();

	protected void transitionTo(Screen screen) {
		screenStack.replace(screen, new FadeTransition(screenStack));
	}

	protected boolean isStupid() {
		return Attribute.INTELLECT.asInt() == 0;
	}
}
