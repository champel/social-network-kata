package cat.champel.social.actions;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cat.champel.social.model.posts.PostsService;

@ExtendWith(MockitoExtension.class)
class PostUserMessageShould {
	
	private static final String USER_NAME = "userName";
	private static final String POST_MESSAGE = "postMessage";

	@Mock PostsService postsService;
	
	private PostUserMessage postUserMessage;

	@BeforeEach
	void setUp() throws Exception {
		postUserMessage = new PostUserMessage(postsService);
	}

	@Test
	void call_new_post_on_posts_servicee_when_executed() {
		postUserMessage.execute(USER_NAME, POST_MESSAGE);
		verify(postsService).submit(USER_NAME, POST_MESSAGE);
	}
}
