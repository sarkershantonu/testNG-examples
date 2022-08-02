package org.automation.tests.reporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;

public class MyReport implements IReporter {
    private final Logger log = LoggerFactory.getLogger(MyReport.class);

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        for(ISuite aSuite: suites){
            final String suiteName = aSuite.getName();
            Map<String, ISuiteResult> resultMap = aSuite.getResults();
            for(ISuiteResult aResult : resultMap.values()){
                ITestContext context = aResult.getTestContext();
                log.info(passText(suiteName,context));
                log.info(failedText(suiteName,context));
                log.info(skippedText(suiteName,context));
            }
        }
        
        IReporter.super.generateReport(xmlSuites, suites, outputDirectory);
    }

    private String skippedText(String suiteName, ITestContext context) {
        return  suiteName + " Skipped , total tests "+ context.getSkippedTests().getAllResults().size();
    }

    private String failedText(String suiteName, ITestContext context) {
        return suiteName + " failed , total tests "+ context.getFailedTests().getAllResults().size();
    }

    private String passText(String suiteName, ITestContext context) {
        return  suiteName + " PASSED , total tests "+ context.getPassedTests().getAllResults().size();
    }

}
