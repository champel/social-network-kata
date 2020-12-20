package cat.champel.social.actions;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cat.champel.social.model.network.NetworkService;
import cat.champel.social.model.posts.PostsService;

@ExtendWith(MockitoExtension.class)
class ReadWallMessagesShould {
	
	private static final String USER_NAME = "userName";

	@Mock PostsService postsService;
	@Mock NetworkService networkService;
	
	private ReadWallMessages readWallMessages;

	@BeforeEach
	void setUp() throws Exception {
		readWallMessages = new ReadWallMessages(networkService, postsService);
	}

	@Test
	void read_wall_users_from_network_service_when_executed() {
		readWallMessages.execute(USER_NAME);
		verify(networkService).wallUsersBy(USER_NAME);
	}

	@Test
	void read_wall_users_posts_from_posts_servicee_when_executed() {
		Set<String> userNames = mock(Set.class);
		given(networkService.wallUsersBy(USER_NAME)).willReturn(userNames);
		readWallMessages.execute(USER_NAME);
		verify(postsService).byUserNames(userNames);
	}
}
