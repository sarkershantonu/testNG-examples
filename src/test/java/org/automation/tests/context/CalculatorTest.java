package org.automation.tests.context;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest extends BaseTestWithContext{
    @Test
    public void testAdditionFail(ITestContext context) {
        context.setAttribute("env","DEV");
        assertEquals(35.0, aCalculator.add(10.0, 15.0), 0.01);

    }

    @Test
    public void testAddition(ITestContext context) {
        assertEquals(25.0, aCalculator.add(10.0, 15.0), 0.01);
        System.out.println(context.getAttribute("env"));

    }
    @Test
    public void testAdditionForText(ITestContext context) {
        assertEquals(25.0, aCalculator.add(10.0, 15.0), 0.01);

    }
}
