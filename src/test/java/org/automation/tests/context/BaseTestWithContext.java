package org.automation.tests.context;

import org.automation.app.calculator.Calculator;
import org.testng.annotations.BeforeTest;

public abstract class BaseTestWithContext {
    protected Calculator aCalculator;
    @BeforeTest
    public void initCalculator(){
        aCalculator = new Calculator();
    }
}
