package cat.champel.social.actions;

import java.util.List;

import cat.champel.social.model.posts.Post;
import cat.champel.social.model.posts.PostsService;

public class ReadUserMessages {
	private final PostsService postsService;

	public ReadUserMessages(PostsService postsService) {
		this.postsService = postsService;
	}

	public List<Post> execute(String userName) {
		return postsService.byUserName(userName);
	}

}
