package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\My\\eclipse-workspace\\IPC\\src\\main\\resources\\login.feature",
        glue = {"stepdefinition"}
        )

public class Runner {

}
