package com.sa.demo.steps;

import com.sa.demo.utils.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;

import static java.time.temporal.ChronoUnit.MILLIS;

public class Hooks {

    private LocalDateTime scenarioStartTime;
    private String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return LocalDateTime.now().format(formatter);
    }

    @Autowired
    private ScenarioContext scenarioContext;

    @Before
    public void InitializeTest(Scenario scenario) throws InterruptedException {
//        Thread.sleep(7000);
        System.out.println("Scenario " + scenario.getName() + " started at " + getCurrentTime());
        scenarioStartTime = LocalDateTime.now();
        scenario.log(""+scenarioStartTime);

    }


    @BeforeTest
    public void beforeTest(ITestContext context) {
        System.out.println("DataProviderThreadCount: " + context.getCurrentXmlTest().getThreadCount());
    }


    @After
    public void TearDownTest(Scenario scenario) {
        LocalDateTime scenarioEndTime = LocalDateTime.now();
        long scenarioDuration = scenarioStartTime.until(scenarioEndTime, MILLIS);
        scenario.log("Scenario " + scenario.getName() + " ended at " + getCurrentTime());
        scenario.log("Scenario " + scenario.getName() + " took " + scenarioDuration + "ms to execute");
//        if (scenario.isFailed()) {
        if (scenarioContext.containsContext("response")){
            Response response = (Response) scenarioContext.getContext("response");
            scenario.log(response.prettyPrint());
        }
    }
}
