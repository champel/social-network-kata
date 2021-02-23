package cat.champel.social.actions.at;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:/actions", glue= { "cat.champel.social.actions" } )
public class SocialActionsAT {
}