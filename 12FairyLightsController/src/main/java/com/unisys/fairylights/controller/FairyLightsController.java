package com.unisys.fairylights.controller;

import com.unisys.fairylights.light.FairyLightsFactory;
import com.unisys.fairylights.strategy.DisplayStrategy;
import com.unisys.fairylights.strategy.DisplayStrategyFactory;

/**
 * FairyLightsController responsible for displaying fairy lights as per the {@link DisplayStrategy}.
 * 
 * @see DisplayStrategy
 */
public class FairyLightsController {

	/**
	 * Execute the given strategy for displaying fairy lights
	 * 
	 * @param displayStrategyName
	 *            the name of the strategy
	 */
	public void run(String displayStrategyName, int numberOfLights) {
		run(DisplayStrategyFactory.getStrategy(displayStrategyName), numberOfLights);
	}

	/**
	 * 
	 * @param displayStrategy
	 * @param numberOfLights
	 *            length of fairy lights
	 */
	public void run(DisplayStrategy displayStrategy, int numberOfLights) {
		displayStrategy.execute(FairyLightsFactory.buildFairyLights(numberOfLights));
	}
}
