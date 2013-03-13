package com.unisys.fairylights.strategy;

import java.util.List;

import com.unisys.fairylights.light.Light;
import com.unisys.fairylights.light.LightStatus;

/**
 * Provides basic functionality, such as delay, blink and change of status.
 * 
 * @author Basit
 *
 */
public abstract class AbstractDisplayStrategy implements DisplayStrategy  {

	/**
	 *  Wrapper around {@link Thread#sleep(long)} 
	 * @param time
	 */
	protected void delay(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			//No other thread exists - just restore the status
			Thread.currentThread().interrupt(); 
		}
	}

	/**
	 * Blinks all provided lights for the given time.
	 * @param lights 
	 * @param delay
	 */
	protected void blink(List<Light> lights, int delay) {
		changeStatus(lights, LightStatus.ON);
		this.delay(delay);
		changeStatus(lights, LightStatus.OFF);
	}

	/**
	 * Blinks the light for the given delay.
	 * @param light
	 * @param delay
	 */
	protected void blink(Light light, int delay) {
		changeStatus(light, LightStatus.ON);
		this.delay(delay);
		changeStatus(light, LightStatus.OFF);
	}

	//Change status of all lights to the given status
	private void changeStatus(List<Light> lights, LightStatus lightStatus) {
		for (Light light : lights) {
			changeStatus(light, lightStatus);
		}
	}

	//Change status fo the light to the given status
	private void changeStatus(Light light, LightStatus lightStatus) {
		light.changeLightStatus(lightStatus);
		System.out.print(light);
	}
	
}