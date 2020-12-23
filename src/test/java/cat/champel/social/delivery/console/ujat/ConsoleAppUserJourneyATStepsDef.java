package cat.champel.social.delivery.console.ujat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

import cat.champel.console.Console;
import cat.champel.console.ConsoleAppTester;
import cat.champel.social.actions.FollowUser;
import cat.champel.social.actions.PostUserMessage;
import cat.champel.social.actions.ReadUserMessages;
import cat.champel.social.actions.ReadWallMessages;
import cat.champel.social.delivery.console.SocialConsoleApp;
import cat.champel.social.model.posts.Post;
import cat.champel.social.runtime.SocialActions;
import io.cucumber.java8.En;

public class ConsoleAppUserJourneyATStepsDef extends ConsoleAppTester implements En {
	public ConsoleAppUserJourneyATStepsDef() {
		Before(() -> {
			PostUserMessage postMessage = mock(PostUserMessage.class);
			ReadUserMessages readUserMessages = mock(ReadUserMessages.class);
			given(readUserMessages.execute("Alice")).willReturn(List.of(
				Post.create("Alice", "It's a lovely day today", Instant.now()),
				Post.create("Alice", "Hello, my name is Alice", Instant.now())));
			ReadWallMessages readWallMessages = mock(ReadWallMessages.class);
			given(readWallMessages.execute("Charlie")).willReturn(List.of(
				Post.create("Alice", "It's a lovely day today", Instant.now()),
				Post.create("Charlie", "I'm in London today. Anyone up for a drink?", Instant.now()),
				Post.create("Alice", "Hello, my name is Alice", Instant.now()),
				Post.create("Bob", "Hi, I'm Bob", Instant.now())));
			FollowUser followUser = mock(FollowUser.class);

			SocialActions socialActions = mock(SocialActions.class);
			given(socialActions.postMessage()).willReturn(postMessage);
			given(socialActions.readUserMessages()).willReturn(readUserMessages);
			given(socialActions.readWallMessages()).willReturn(readWallMessages);
			given(socialActions.followUser()).willReturn(followUser);
			
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