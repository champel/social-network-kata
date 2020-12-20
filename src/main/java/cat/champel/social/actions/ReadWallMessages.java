package cat.champel.social.actions;

import java.util.List;

import cat.champel.social.model.network.NetworkService;
import cat.champel.social.model.posts.Post;
import cat.champel.social.model.posts.PostsService;

public class ReadWallMessages {

	private final PostsService postsService;
	private final NetworkService networkService;

	public ReadWallMessages(NetworkService networkService, PostsService postsService) {
		this.networkService = networkService;
		this.postsService = postsService;
	}

	public List<Post> execute(String userName) {
		return postsService.byUserNames(networkService.wallUsersBy(userName));
	}
}