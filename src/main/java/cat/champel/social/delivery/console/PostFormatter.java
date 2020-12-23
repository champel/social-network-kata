package cat.champel.social.delivery.console;

import java.util.function.Function;

import cat.champel.social.model.posts.Post;

public class PostFormatter implements Function<Object, String> {

	@Override
	public String apply(Object object) {
		Post post = (Post) object;
		return post.getUserName() + " - " + post.getMessage();
	}
	
}
