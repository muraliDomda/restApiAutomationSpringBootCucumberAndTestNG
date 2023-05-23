package com.sa.demo.runner;

import io.cucumber.testng.*;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/java/com/sa/demo/features/"},
        plugin = {"json:target/CucumberTestReport.json", "pretty"},
        glue = "com.sa.demo.steps"

)
public class TestRunner extends AbstractTestNGCucumberTests {

    //Single execution
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
