package org.automation.tests.context;

import org.automation.app.calculator.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;

public abstract class BaseTestWithContext {
    protected final static Logger log = LoggerFactory.getLogger(BaseTestWithContext.class);
    protected Calculator aCalculator;
    @BeforeTest
    public void initCalculator(){
        aCalculator = new Calculator();
    }
}
