package cat.champel.social.delivery.console.e2e;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:delivery/console/end-2-end", glue= { "cat.champel.social.delivery.console.e2e" } )
public class ConsoleAppE2EAT {
}