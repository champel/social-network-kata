package cat.champel.social.delivery.console;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cat.champel.social.actions.ReadUserMessages;
import cat.champel.social.model.posts.Post;

@ExtendWith(MockitoExtension.class)
public class ReadCommandBuilderShould {
	
	private static final String USER_NAME = "Alice";
	private static final String READ_COMMAND = USER_NAME;
	private static final String NO_COMMAND = USER_NAME + " something";

	@Mock ReadUserMessages readUserMessages;
	
	ReadMessagesCommandBuilder postCommandbuilder;
	
	@BeforeEach
	void setup() {
		postCommandbuilder = new ReadMessagesCommandBuilder(readUserMessages);
	}
	
	@Test
	void build_a_command_when_user_command_is_a_single_word() {
		assertThat(postCommandbuilder.build(READ_COMMAND)).isPresent();
	}

	@Test
	void do_not_build_a_command_when_user_command_has_different_words() {
		assertThat(postCommandbuilder.build(NO_COMMAND)).isEmpty();
	}

	@Test
	void call_read_command_on_command_execution() {
		List<Post> posts = mock(List.class);
		given(readUserMessages.execute(USER_NAME)).willReturn(posts);
		postCommandbuilder.build(USER_NAME).get().execute();
		verify(readUserMessages).execute(USER_NAME);
	}

	@Test
	void return_posts_readed_on_command_execution() {
		List<Post> posts = mock(List.class);
		given(readUserMessages.execute(USER_NAME)).willReturn(posts);
		assertThat(postCommandbuilder.build(READ_COMMAND).get().execute()).contains(posts);
	}
}
