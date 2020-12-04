package cat.champel.social.delivery.console.e2e;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import cat.champel.console.Console;
import cat.champel.console.ConsoleAppTester;
import cat.champel.social.delivery.console.SocialConsoleApp;
import io.cucumber.java8.En;

public class ConsoleAppE2EATStepsDef extends ConsoleAppTester implements En {

	public ConsoleAppE2EATStepsDef() {
		Before(() -> setup(new SocialConsoleApp()));
		Given("in:  > {string}", (String command) -> processInput(command));
		Then( "out: {string}", (String chars) -> assertOutput(chars.replace("\\n","\n")));
	}

	private void processInput(String command) throws Exception, IOException {
		assertOutput(Console.PROMPT);
		writeCommand(command);
	}
	
	private void assertOutput(String expected) throws Exception {
		assertThat(readOutput(expected)).isEqualTo(expected);
	}
}