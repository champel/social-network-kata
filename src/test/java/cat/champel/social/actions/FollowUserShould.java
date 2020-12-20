package cat.champel.social.actions;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cat.champel.social.model.network.NetworkService;

@ExtendWith(MockitoExtension.class)
class FollowUserShould {
	
	private static final String USER_NAME = "userName";
	private static final String FOLLOWED_USER_NAME = "followedUserName";

	@Mock NetworkService networkService;
	
	private FollowUser followUser;

	@BeforeEach
	void setUp() throws Exception {
		followUser = new FollowUser(networkService);
	}

	@Test
	void call_follow_on_network_service_when_executed() {
		followUser.execute(USER_NAME, FOLLOWED_USER_NAME);
		verify(networkService).follow(USER_NAME, FOLLOWED_USER_NAME);
	}
}
