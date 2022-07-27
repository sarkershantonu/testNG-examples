package org.automation.tests.context;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest extends BaseTestWithContext{
    @Test
    public void testAdditionFail() {
        assertEquals(35.0, aCalculator.add(10.0, 15.0), 0.01);

    }

    @Test
    public void testAddition() {
        assertEquals(25.0, aCalculator.add(10.0, 15.0), 0.01);

    }
    @Test
    public void testAdditionForText() {
        assertEquals(25.0, aCalculator.add(10.0, 15.0), 0.01);

    }
}
