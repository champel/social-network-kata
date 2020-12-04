package cat.champel.social.delivery.console.ujat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.io.IOException;

import cat.champel.console.Console;
import cat.champel.console.ConsoleAppTester;
import cat.champel.social.delivery.console.SocialConsoleApp;
import cat.champel.social.runtime.SocialActions;
import io.cucumber.java8.En;

public class ConsoleAppUserJourneyATStepsDef extends ConsoleAppTester implements En {
	public ConsoleAppUserJourneyATStepsDef() {
		Before(() -> {
			//TODO Create action mocks

			SocialActions socialActions = mock(SocialActions.class);
			//TODO Mock social actions
			
			setup(new SocialConsoleApp(socialActions));
		});
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