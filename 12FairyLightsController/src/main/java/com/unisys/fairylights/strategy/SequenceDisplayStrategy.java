package com.unisys.fairylights.strategy;

import java.util.List;

import com.unisys.fairylights.light.Light;

/**
 * This class provides display strategy as described in the assignment document.
 * <p/>
 * <b>sequence : each light is turned on for 0.5 seconds then off in turn from first to last. As soon as the algorithm completes, it should start again.</b>
 * <p/>
 * 
 */
public class SequenceDisplayStrategy extends AbstractDisplayStrategy {

	public static final String NAME = "SEQUENCE";

	private static final int WAIT_TIME = 500;

	private boolean continuous = true;

	@Override
	public void execute(List<Light> fairyLights) {
		do {
			displayLights(fairyLights);
		} while (continuous);
	}

	private void displayLights(List<Light> fairyLights) {
		for (Light light : fairyLights) {
			blink(light, WAIT_TIME);
		}
	}

	// only to be used by subclasses for testing
	void setContinuous(boolean cont) {
		this.continuous = cont;
	}
}
