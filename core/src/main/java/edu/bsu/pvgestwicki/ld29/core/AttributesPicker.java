package edu.bsu.pvgestwicki.ld29.core;

import react.Slot;
import react.Value;
import react.ValueView.Listener;
import tripleplay.ui.Background;
import tripleplay.ui.Button;
import tripleplay.ui.Constraints;
import tripleplay.ui.Element;
import tripleplay.ui.Group;
import tripleplay.ui.Label;
import tripleplay.ui.Style;
import tripleplay.ui.layout.AxisLayout;
import tripleplay.ui.layout.FlowLayout;
import tripleplay.util.Colors;

public final class AttributesPicker extends Group {

	public final Value<Integer> availablePoints = Value.create(2);

	public AttributesPicker() {
		super(AxisLayout.vertical());
		add(createAvailablePointsWidget());
		for (Attribute att : Attribute.values()) {
			add(new Group(new FlowLayout())//
					.add(new Label(att.name).setConstraint(
							Constraints.fixedWidth(135)).addStyles(
							Style.HALIGN.left),//
							new SpinnerWidget(att.value)));
		}
	}

	private Element<?> createAvailablePointsWidget() {
		final Label points = new Label(availablePoints.get().toString())//
				.setConstraint(Constraints.fixedWidth(30));
		availablePoints.connect(new Listener<Integer>() {
			@Override
			public void onChange(Integer value, Integer oldValue) {
				points.text.update(value.toString());
			}
		});
		return new Group(AxisLayout.horizontal())//
				.add(new Label("Available points: "), points);
	}

	private final class SpinnerWidget extends Group {

		SpinnerWidget(final Value<Integer> value) {
			super(AxisLayout.horizontal());
			addStyles(Style.BACKGROUND.is(Background.solid(Colors.BLACK)));
			final Label valueField = new Label(value.get().toString())//
					.setConstraint(Constraints.fixedWidth(30));
			final Button plusButton = new Button("+")//
					.onClick(new Slot<Button>() {
						@Override
						public void onEmit(Button event) {
							value.update(value.get() + 1);
							availablePoints.update(availablePoints.get() - 1);
						}
					});
			final Button minusButton = new Button("-")//
					.onClick(new Slot<Button>() {
						@Override
						public void onEmit(Button event) {
							value.update(value.get() - 1);
							availablePoints.update(availablePoints.get() + 1);
						}
					});
			add(minusButton, valueField, plusButton);
			value.connect(new Listener<Integer>() {
				@Override
				public void onChange(Integer newValue, Integer oldValue) {
					valueField.text.update(newValue.toString());
					minusButton.setEnabled(newValue > 0);
				}
			});
			availablePoints.connect(new Listener<Integer>() {
				@Override
				public void onChange(Integer value, Integer oldValue) {
					plusButton.setEnabled(value > 0);
				}
			});
		}
	}

}
