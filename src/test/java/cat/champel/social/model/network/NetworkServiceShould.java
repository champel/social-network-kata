package cat.champel.social.model.network;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NetworkServiceShould {

	private static final String USER_NAME = "USER_NAME";
	private static final String FOLLOWED_USER_NAME = "FOLLOWED_USER_NAME";

	@Mock NetworkCollection networkCollection;
	
	private NetworkService networkService;
	
	@BeforeEach
	void setUp() throws Exception {
		networkService = new NetworkService(networkCollection);
	}

	@Test
	void store_follow_in_network_collection_when_follow() {
		networkService.follow(USER_NAME, FOLLOWED_USER_NAME);
		verify(networkCollection).storeFollowRelation(USER_NAME, FOLLOWED_USER_NAME);
	}

	@Test
	void retrieve_followed_users_by_the_user_when_wall_by_user_is_requested() {
		given(networkCollection.followedBy(USER_NAME)).willReturn(Set.of());
		networkService.wallUsersBy(USER_NAME)	;
		verify(networkCollection).followedBy(USER_NAME);
	}

	@Test
	void build_a_set_with_the_retrieved_followed_users_plus_the_user_when_wall_by_user_is_requested() {
		given(networkCollection.followedBy(USER_NAME)).willReturn(Set.of(FOLLOWED_USER_NAME));
		assertThat(networkService.wallUsersBy(USER_NAME)).isEqualTo(Set.of(FOLLOWED_USER_NAME, USER_NAME));
	}

}
