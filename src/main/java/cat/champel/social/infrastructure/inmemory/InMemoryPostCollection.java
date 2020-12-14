package cat.champel.social.infrastructure.inmemory;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import cat.champel.social.model.posts.Post;
import cat.champel.social.model.posts.PostCollection;

public class InMemoryPostCollection implements PostCollection {
	
	private static final Comparator<? super Post> REVERSE_TIMESTAMP_COMPARATOR = (post1, post2) -> post2.getTimestamp().compareTo(post1.getTimestamp());

	private final Map<String, List<Post>> postsByUser;

	public InMemoryPostCollection() {
		this.postsByUser = new HashMap<String, List<Post>>();
	}

	@Override
	public void store(Post post) {
		List<Post> posts = by(post.getUserName());
		posts.add(post);
		postsByUser.put(post.getUserName(), posts);
	}

	@Override
	public List<Post> by(String userName) {
		return postsBy(userName).stream()
				.sorted(REVERSE_TIMESTAMP_COMPARATOR)
				.collect(toList());
	}

	@Override
	public List<Post> by(Set<String> userNames) {
		return userNames.stream()
				.flatMap((userName) -> postsBy(userName).stream())
				.sorted(REVERSE_TIMESTAMP_COMPARATOR)
				.collect(Collectors.toList());
	}

	private List<Post> postsBy(String userName) {
		return postsByUser.getOrDefault(userName, new LinkedList<>());
	}

}
