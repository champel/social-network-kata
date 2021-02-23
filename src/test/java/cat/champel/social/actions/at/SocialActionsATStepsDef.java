package cat.champel.social.actions.at;

import cat.champel.social.infrastructure.clock.Clock;
import cat.champel.social.model.posts.Post;
import cat.champel.social.runtime.SocialActions;
import cat.champel.social.runtime.SocialModel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.assertj.core.api.Fail;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SocialActionsATStepsDef implements En {

	private SocialActions socialActions;

	private Clock clock;
	private List<Post> posts;

	public SocialActionsATStepsDef() {
		Before(() -> {
			clock = Mockito.mock(Clock.class);
			socialActions = SocialActions.build(SocialModel.build(clock));
		});
		// Post collection mock
		Given("{string} posts in the posts collection are", (String filter, DataTable dataTable) -> {
		});
		Then("Stored posts in the post collection are", (DataTable dataTable) -> {
			Fail.fail("Pending to implement");
		});
		// Network collection mock
		Given("{string} follows {string} in the network collection", (String userName, String followed) -> {
		});
		Then("Following relations in network collection are stored in the network collection", (DataTable dataTable) -> {
			Fail.fail("Pending to implement");
		});
		// Actions behaviour
		Given("{string} posts {string} on {string}", (String userName, String postMessage, String timestamp) -> {
		});
		Given("{string} follows {string}", (String userName, String followedUserName) -> {
		});
		When("Read {string} posts", (String userName) -> {
		});
		When("Read {string} wall", (String userName) -> {
		});
		Then("Returned posts are", (DataTable dataTable) -> {
			Fail.fail("Pending to implement");
		});
	}
	private Post mapToPost(Map<String, String> map) {
		return Post.create(map.get("user"), map.get("message"), Instant.parse(map.get("timestamp")));
	}

	private List<Post> mapsToPosts(List<Map<String, String>> asMaps) {
		return asMaps.stream()
				.map(this::mapToPost)
				.collect(toList());
	}

	private Map<String, String> postToMap(Post post) {
		return Map.of(
				"user", post.getUserName(),
				"message", post.getMessage(),
				"timestamp", post.getTimestamp().toString()
		);
	}

	private List<Map<String, String>> postsToMaps() {
		return posts.stream()
				.map(this::postToMap)
				.collect(toList());
	}
}