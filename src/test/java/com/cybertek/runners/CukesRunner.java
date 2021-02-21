package com.cybertek.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //       type:  where:
        plugin = "html:target/dataTables-report.html", //plugins-to generate reports
        features = "src/test/resources/features",
        glue = "com/cybertek/step_definitions",
        dryRun = false, //true - allows to run the feature files to get the snippets //true checks if there are any unimplemented steps, and will have them in the bottom window
        tags = "@scenarioOutline" //grouping Scenarios for smoke or regression or.. test (for reusability) //from Cucumber
        //no tags will run ALL the Features!!
        //To run all the Scenarios: use 1 tag on top of the Feature or the same tag on top of all the Scenarios
        // in tags: Or/ And/ And Not
)


public class CukesRunner {
}

