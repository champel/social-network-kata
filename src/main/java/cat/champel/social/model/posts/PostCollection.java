package cat.champel.social.model.posts;

import java.util.List;
import java.util.Set;

public interface PostCollection {

	void store(Post post);

	List<Post> by(String userName);
	List<Post> by(Set<String> userNames);

}
