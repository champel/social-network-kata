package cat.champel.social.model.posts;

import java.util.List;
import java.util.Set;

import cat.champel.social.infrastructure.clock.Clock;

public class PostsService {

	private final Clock clock;
	private final PostCollection postCollection;

	public PostsService(Clock clock, PostCollection postCollection) {
		this.clock = clock;
		this.postCollection = postCollection;
	}

	public void submit(String userName, String postMessage) {
		postCollection.store(Post.create(userName, postMessage, clock.currentTime()));
	}

	public List<Post> byUserName(String userName) {
		return postCollection.by(userName);
	}

	public List<Post> byUserNames(Set<String> userNames) {
		return postCollection.by(userNames);
	}
}
