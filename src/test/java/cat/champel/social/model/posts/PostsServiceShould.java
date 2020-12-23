package cat.champel.social.model.posts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import cat.champel.social.infrastructure.clock.Clock;

@ExtendWith(MockitoExtension.class)
class PostsServiceShould {

	private static final String USER_NAME = "USER_NAME";
	private static final Set<String> USER_NAMES = Set.of("USER_NAME_1", "USER_NAME_2");
	private static final String POST_MESSAGE = "POST_MESSAGE";
	private static final Instant TIMESTAMP = Instant.parse("2020-01-01T10:00:00Z");

	@Mock PostCollection postCollection;
	@Mock Clock clock;
	
	private PostsService postService;
	
	@BeforeEach
	void setUp() throws Exception {
		postService = new PostsService(clock, postCollection);
	}

	@Test
	void creates_post_with_a_new_timestamp_on_submit() {
		try (MockedStatic<Post> mock = Mockito.mockStatic(Post.class)) {
			given(clock.currentTime()).willReturn(TIMESTAMP);
			postService.submit(USER_NAME, POST_MESSAGE);
			mock.verify(() -> Post.create(USER_NAME, POST_MESSAGE, TIMESTAMP));
		}
	}

	@Test
	void store_post_in_post_collection_when_submit() {
		try (MockedStatic<Post> mock = Mockito.mockStatic(Post.class)) {
			Post post = mock(Post.class);
			given(clock.currentTime()).willReturn(TIMESTAMP);
			mock.when(() -> Post.create(USER_NAME, POST_MESSAGE, TIMESTAMP)).thenReturn(post);
			postService.submit(USER_NAME, POST_MESSAGE);
			verify(postCollection).store(post);
		}
	}
	
	@Test
	void return_user_posts_from_post_collection_when_accessing_by_user_name() {
		List<Post> posts = mock(List.class);
		given(postCollection.by(USER_NAME)).willReturn(posts);
		assertThat(postService.byUserName(USER_NAME)).isEqualTo(posts);
	}

	@Test
	void return_users_posts_from_post_collection_when_accessing_by_user_names() {
		List<Post> posts = mock(List.class);
		given(postCollection.by(USER_NAMES)).willReturn(posts);
		assertThat(postService.byUserNames(USER_NAMES)).isEqualTo(posts);
	}
}
