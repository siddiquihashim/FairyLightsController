package com.unisys.fairylights.controller;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.unisys.fairylights.light.Light;
import com.unisys.fairylights.strategy.AbstractDisplayStrategy;

public class FairyLightsControllerTest {

	FairyLightsController controller = new FairyLightsController();

	private class MockDisplayStrategy extends AbstractDisplayStrategy {

		public boolean executed = false;
		
		@Override
		public void execute(List<Light> fairyLights) {
			executed = true;
			
		}
	}
	
	@Test
	public void shouldGetAndExecuteStrategyFromFactory() {
		// setup
		MockDisplayStrategy mockDisplayStrategy = new MockDisplayStrategy();
		
		// act
		controller.run(mockDisplayStrategy, 20);
		
		// assert
		assertTrue(mockDisplayStrategy.executed);
	}
}
