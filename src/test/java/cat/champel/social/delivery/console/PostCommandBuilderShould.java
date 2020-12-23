package cat.champel.social.delivery.console;

import static cat.champel.social.delivery.console.PostCommandBuilder.ARROW;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cat.champel.social.actions.PostUserMessage;

@ExtendWith(MockitoExtension.class)
public class PostCommandBuilderShould {
	
	private static final String USER_MESSAGE = "Hello!";
	private static final String USER_NAME = "Alice";
	private static final String POST_COMMAND = USER_NAME + ARROW + USER_MESSAGE;
	private static final String OTHER_COMMAND = "other command"; 

	@Mock PostUserMessage postAction;
	
	PostCommandBuilder postCommandbuilder;
	
	@BeforeEach
	void setup() {
		postCommandbuilder = new PostCommandBuilder(postAction);
	}
	
	@Test
	void do_not_return_command_if_no_arrow_is_present() {
		assertThat(postCommandbuilder.build(OTHER_COMMAND)).isEmpty();
	}

	@Test
	void build_a_command_if_arrow_is_present() {
		assertThat(postCommandbuilder.build(POST_COMMAND)).isPresent();
	}


	@Test
	void call_post_action_on_command_execution() {
		postCommandbuilder.build(POST_COMMAND).get().execute();
		verify(postAction).execute(USER_NAME,USER_MESSAGE);
	}

	@Test
	void return_empty_on_command_execution() {
		assertThat(postCommandbuilder.build(POST_COMMAND).get().execute()).isEmpty();
	}
}
