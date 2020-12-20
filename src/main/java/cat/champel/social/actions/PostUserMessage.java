package cat.champel.social.actions;

import cat.champel.social.model.posts.PostsService;

public class PostUserMessage {

	private final PostsService posts;

	public PostUserMessage(PostsService posts) {
		this.posts = posts;
	}

	public void execute(String userName, String postMessage) {
		posts.submit(userName, postMessage);
	}

}
