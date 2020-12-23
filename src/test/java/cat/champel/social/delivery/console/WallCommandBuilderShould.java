package cat.champel.social.delivery.console;

import static cat.champel.social.delivery.console.WallMessagesCommandBuilder.WALL;
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

import cat.champel.social.actions.ReadWallMessages;
import cat.champel.social.model.posts.Post;

@ExtendWith(MockitoExtension.class)
public class WallCommandBuilderShould {
	
	private static final String USER_NAME = "Alice";
	private static final String WALL_COMMAND = USER_NAME + WALL;
	private static final String OTHER_COMMAND = "other command"; 

	@Mock ReadWallMessages readWallMessages;
	
	WallMessagesCommandBuilder wallCommandbuilder;
	
	@BeforeEach
	void setup() {
		wallCommandbuilder = new WallMessagesCommandBuilder(readWallMessages);
	}

	@Test
	void do_not_build_a_command_when_wall_action_is_not_present() {
		assertThat(wallCommandbuilder.build(OTHER_COMMAND)).isEmpty();
	}

	@Test
	void build_a_command_when_wall_action_is_present() {
		assertThat(wallCommandbuilder.build(WALL_COMMAND)).isPresent();
	}


	@Test
	void call_wall_command_on_command_execution() {
		List<Post> posts = mock(List.class);
		given(readWallMessages.execute(USER_NAME)).willReturn(posts);
		wallCommandbuilder.build(WALL_COMMAND).get().execute();
		verify(readWallMessages).execute(USER_NAME);
	}

	@Test
	void return_empty_on_command_execution() {
		List<Post> posts = mock(List.class);
		given(readWallMessages.execute(USER_NAME)).willReturn(posts);
		assertThat(wallCommandbuilder.build(WALL_COMMAND).get().execute()).contains(posts);
	}
}
