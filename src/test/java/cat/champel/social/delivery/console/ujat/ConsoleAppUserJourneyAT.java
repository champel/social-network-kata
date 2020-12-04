package cat.champel.social.delivery.console.ujat;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:delivery/console/user-journey", glue= { "cat.champel.social.delivery.console.ujat" } )
public class ConsoleAppUserJourneyAT {
}