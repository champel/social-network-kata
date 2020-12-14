package cat.champel.social.model.posts;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class PostCollectionShould {

	private static final Instant INSTANT_1 = Instant.parse("2020-01-01T10:00:00Z");
	private static final Instant INSTANT_2 = INSTANT_1.plusSeconds(10);
	private static final Instant INSTANT_3 = INSTANT_2.plusSeconds(10);
	private static final String USER_NAME = "USER_NAME";
	private static final String USER_NAME_2 = "USER_NAME_2";
	private static final Set<String> USER_NAMES = Set.of(USER_NAME, USER_NAME_2);
	private static final Post POST_1 = Post.create(USER_NAME, "MESSAGE 1", INSTANT_1);
	private static final Post POST_2 = Post.create(USER_NAME_2, "MESSAGE 2", INSTANT_2);
	private static final Post POST_3 = Post.create(USER_NAME, "MESSAGE 3", INSTANT_3);
	
	private PostCollection postCollection;

	protected abstract PostCollection postCollection();
	
	@BeforeEach
	void setUp() throws Exception {
		postCollection = postCollection();
	}
	
	@Test
	void returns_and_empty_list_if_user_is_not_found_when_by_user_requested() {
		assertThat(postCollection.by(USER_NAME)).isEqualTo(List.of());
	}
	
	@Test
	void returns_the_list_of_user_posts_reverse_ordered_by_timestamp_when_by_user_requested() {
		postCollection.store(POST_1);
		postCollection.store(POST_2);
		postCollection.store(POST_3);
		assertThat(postCollection.by(USER_NAME)).isEqualTo(List.of(POST_3, POST_1));
	}
	
	@Test
	void returns_and_empty_list_if_user_is_not_found_when_by_users_requested() {
		postCollection.store(POST_1);
		postCollection.store(POST_2);
		postCollection.store(POST_3);
		assertThat(postCollection.by(USER_NAMES)).isEqualTo(List.of(POST_3, POST_2, POST_1));
	}
}
