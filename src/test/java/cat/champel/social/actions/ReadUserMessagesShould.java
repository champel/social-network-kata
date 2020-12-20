package cat.champel.social.actions;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cat.champel.social.model.posts.PostsService;

@ExtendWith(MockitoExtension.class)
class ReadUserMessagesShould {
	
	private static final String USER_NAME = "userName";

	@Mock PostsService postsService;
	
	private ReadUserMessages readUserMessages;

	@BeforeEach
	void setUp() throws Exception {
		readUserMessages = new ReadUserMessages(postsService);
	}

	@Test
	void read_wall_messages_from_posts_service() {
		readUserMessages.execute(USER_NAME);
		verify(postsService).byUserName(USER_NAME);
	}
}
