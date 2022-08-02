package org.automation.tests.reporting;

import org.automation.tests.context.BaseTestWithContext;
import org.automation.tests.core.BaseTest;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class ReporterExample extends BaseTestWithContext {

    @Test(priority = 0)
    public void testAddition(ITestContext context, Method m) {
        Reporter.clear();
        Reporter.log("Running " + m.getName());
        assertEquals(25.0, aCalculator.add(10.0, 15.0), 0.01);

    }
}
