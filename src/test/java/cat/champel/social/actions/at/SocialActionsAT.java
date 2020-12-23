package cat.champel.social.actions.at;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:/actions", glue= { "cat.champel.social.actions" } )
public class SocialActionsAT {
}