package com.unisys.fairylights.strategy;

import java.util.HashMap;
import java.util.Map;

import com.unisys.fairylights.util.Messages;

/**
 * Factory class to return Display Strategy singleton objects.
 */
public class DisplayStrategyFactory {

	private static final Map<String, DisplayStrategy> SUPPORTED_STRATEGIES;
	private static final String NOT_SUPPORTED = "Exception.UnknownStrategy";
	
	//build a map of available algorithms
	static {
		SUPPORTED_STRATEGIES = new HashMap<String, DisplayStrategy>();
		SUPPORTED_STRATEGIES.put(SequenceDisplayStrategy.NAME, new SequenceDisplayStrategy());
		SUPPORTED_STRATEGIES.put(ColourDisplayStrategy.NAME, new ColourDisplayStrategy());
		/* Sample code demonstrating as how to add new strategies 
		 * SUPPORTED_STRATEGIES.put(RandomDisplayStrategy.NAME, new RandomDisplayStrategy());*/
	}

	/**
	 * Returns instance of {@link DisplayStrategy}
	 * @param name the name of the strategy
	 * @return instance of {@link DisplayStrategy}
	 * @throws IllegalArgumentException if the strategy with the given name doesn't exist. 
	 */
	public static DisplayStrategy getStrategy(String name) {
		if (name == null || !SUPPORTED_STRATEGIES.containsKey(name.trim().toUpperCase())) {
			throw new IllegalArgumentException(Messages.getString(NOT_SUPPORTED) + " : " + name) ;
		}
		return SUPPORTED_STRATEGIES.get(name.trim().toUpperCase());
	}

}
