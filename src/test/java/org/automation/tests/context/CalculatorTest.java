package org.automation.tests.context;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import static org.testng.Assert.assertEquals;

public class CalculatorTest extends BaseTestWithContext{
    @Test(priority = 1)
    public void testAdditionFail(ITestContext context, Method m) {
        context.setAttribute("env","DEV");
        System.out.println(m.getName());
        assertEquals(35.0, aCalculator.add(10.0, 15.0), 0.01);

    }

    @Test(priority = 3)
    public void testAddition(ITestContext context) {
        assertEquals(25.0, aCalculator.add(10.0, 15.0), 0.01);
        System.out.println(context.getAttribute("env"));//you should see printout of DEV

    }
    @Test
    public void testAdditionForText(ITestContext context) {
        assertEquals(25.0, aCalculator.add(10.0, 15.0), 0.01);

    }
}
