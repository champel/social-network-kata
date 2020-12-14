package cat.champel.social.model.network;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class NetworkCollectionShould {
	
	private static final String USER_NAME = "USER_NAME";
	private static final String FOLLOWED_USER_NAME = "FOLLOWED_USER";
	
	private NetworkCollection networkCollection;
	
	protected abstract NetworkCollection networkCollection();

	@BeforeEach
	void setUp() throws Exception {
		networkCollection = networkCollection();
	}
	
	@Test
	void returns_and_empty_set_if_user_is_not_found_when_followed_by_requested() {
		assertThat(networkCollection.followedBy(USER_NAME)).isEqualTo(Set.of());
	}
	
	@Test
	void returns_a_set_with_the_followed_users_when_followed_by_requested() {
		networkCollection.storeFollowRelation(USER_NAME, FOLLOWED_USER_NAME);
		assertThat(networkCollection.followedBy(USER_NAME)).isEqualTo(Set.of(FOLLOWED_USER_NAME));
	}
}
