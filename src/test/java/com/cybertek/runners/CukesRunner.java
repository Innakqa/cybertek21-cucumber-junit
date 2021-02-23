package com.cybertek.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //type(plugin):  where:
        plugin = {
                "html:target/dataTables-report.html", //plugins-to generate reports
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"         //failed tests scenarios only in file // to run: use 'another' runner class
        },
        features = "src/test/resources/features",
        glue = "com/cybertek/step_definitions",
        dryRun = false,           //true - allows to run the feature files to get the snippets //true checks if there are any unimplemented steps, and will have them in the bottom window
        tags = "@scenarioOutline" //grouping Scenarios for smoke or regression or.. test (for reusability) //from Cucumber
        //no tags will run ALL the Features!!
        //To run all the Scenarios: use 1 tag on top of the Feature or the same tag on top of all the Scenarios
        // in tags: Or/ And/ And Not
)

//public class FailedTestRunner {
//
//}

public class CukesRunner {
}








//JSON stands for JavaScript Object Notation. It is used to transfer data between a server and a client on the web.
// JSON Wire Protocol is a REST API that transfers the information between HTTP server.
// Each BrowserDriver (such as FirefoxDriver, ChromeDriver, etc.) has its own HTTP server