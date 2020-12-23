package cat.champel.social.delivery.console;

import static cat.champel.social.delivery.console.FollowCommandBuilder.FOLLOWS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cat.champel.social.actions.FollowUser;

@ExtendWith(MockitoExtension.class)
public class FollowsCommandBuilderShould {
	
	private static final String USER_NAME = "Alice";
	private static final String FOLLOWED_USER = "Bob";
	private static final String FOLLOWS_COMMAND = USER_NAME + FOLLOWS + FOLLOWED_USER;
	private static final String OTHER_COMMAND = "other command"; 

	@Mock FollowUser followUser;
	
	FollowCommandBuilder followCommandbuilder;
	
	@BeforeEach
	void setup() {
		followCommandbuilder = new FollowCommandBuilder(followUser);
	}
	
	@Test
	void do_not_return_command_if_no_follows_is_present() {
		assertThat(followCommandbuilder.build(OTHER_COMMAND)).isEmpty();
	}

	@Test
	void build_a_command_if_follows_is_present() {
		assertThat(followCommandbuilder.build(FOLLOWS_COMMAND)).isPresent();
	}


	@Test
	void call_follow_action_on_command_execution() {
		followCommandbuilder.build(FOLLOWS_COMMAND).get().execute();
		verify(followUser).execute(USER_NAME,FOLLOWED_USER);
	}

	@Test
	void return_empty_on_command_execution() {
		assertThat(followCommandbuilder.build(FOLLOWS_COMMAND).get().execute()).isEmpty();
	}
}
