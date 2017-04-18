package edu.bsu.pvgestwicki.ld29.core;

import static com.google.common.base.Preconditions.checkNotNull;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.keyboard;
import playn.core.Key;
import playn.core.Keyboard.Adapter;
import playn.core.Keyboard.Event;
import react.Slot;
import react.ValueView.Listener;
import tripleplay.game.ScreenStack;
import tripleplay.game.UIScreen;
import tripleplay.game.trans.FadeTransition;
import tripleplay.ui.Background;
import tripleplay.ui.Button;
import tripleplay.ui.Constraints;
import tripleplay.ui.Element;
import tripleplay.ui.Field;
import tripleplay.ui.Group;
import tripleplay.ui.Label;
import tripleplay.ui.Shim;
import tripleplay.ui.SimpleStyles;
import tripleplay.ui.Style;
import tripleplay.ui.Style.Binding;
import tripleplay.ui.Styles;
import tripleplay.ui.Stylesheet;
import tripleplay.ui.layout.AxisLayout;
import tripleplay.util.Colors;

public class CharacterCreationScreen extends UIScreen {

	private static String previousName = null;
	private static final Binding<?> UI_FONT = Style.FONT.is(GameFont.REGULAR
			.atSize(32f));

	private static final Stylesheet STYLESHEET = SimpleStyles
			.newSheetBuilder()
			.add(Label.class,
					Styles.make(UI_FONT, Style.COLOR.is(Colors.LIGHT_GRAY)))//
			.add(Button.class, UI_FONT) //
			.add(Field.class, UI_FONT)//
			.create();

	private final ScreenStack screenStack;
	private Field nameField = new Field(previousName == null ? ""
			: previousName)//
			.setPopupLabel("Enter your character's name");
	private PortraitPicker portraitPicker = new PortraitPicker();
	private AttributesPicker attributePicker = new AttributesPicker();
	private Button startButton;

	public CharacterCreationScreen(final ScreenStack screenStack) {
		Attribute.reset();
		this.screenStack = checkNotNull(screenStack);
		initUI();
		keyboard().setListener(new Adapter() {
			@Override
			public void onKeyDown(Event event) {
				if (event.key() == Key.NP_ADD) {
					nameField.text.update("Johnny Secret");
				}
			}
		});
	}

	private void initUI() {
		iface.createRoot(AxisLayout.vertical(), STYLESHEET, layer)
				.setSize(graphics().width(), graphics().height())
				.addStyles(Style.BACKGROUND.is(Background.solid(Colors.BLACK)))
				.add(new Label("Character Creation")//
						.addStyles(Style.FONT.is(GameFont.TITLE.atSize(48))), //
						new Shim(0, 24),//
						new Group(AxisLayout.horizontal())//
								.add(makeLeftPanel().setConstraint(
										Constraints.fixedWidth(450)), //
										makeRightPanel().setConstraint(
												Constraints.fixedWidth(250))),//
						new Shim(0, 24),//
						makeStartButtonGroup());
	}

	private Group makeLeftPanel() {
		return new Group(AxisLayout.vertical())//
				.add(new Group(AxisLayout.horizontal())//
						.add(new Label("Name: "), //
								nameField.setConstraint(Constraints
										.minWidth(300f))), //
						attributePicker);
	}

	private Group makeRightPanel() {
		return new Group(AxisLayout.vertical())//
				.add(portraitPicker);
	}

	private void startGame() {
		previousName = nameField.text.get();
		screenStack.replace(new TownScreen(screenStack), new FadeTransition(
				screenStack));
	}

	private Element<?> makeStartButtonGroup() {
		startButton = new Button("Begin")//
				.onClick(new Slot<Button>() {
					@Override
					public void onEmit(Button event) {
						startGame();
					}
				})//
				.setEnabled(false);
		attributePicker.availablePoints.connect(new Listener<Integer>() {
			@Override
			public void onChange(Integer value, Integer oldValue) {
				updateStartButtonStatus();
			}
		});
		nameField.text.connect(new Listener<String>() {
			@Override
			public void onChange(String value, String oldValue) {
				updateStartButtonStatus();
			}
		});
		return startButton;
	}

	private void updateStartButtonStatus() {
		startButton
				.setEnabled(attributePicker.availablePoints.get().intValue() == 0
						&& !nameField.text.get().trim().isEmpty());
	}

}
