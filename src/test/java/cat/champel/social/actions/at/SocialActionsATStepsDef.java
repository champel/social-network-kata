package cat.champel.social.actions.at;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cat.champel.social.infrastructure.clock.Clock;
import cat.champel.social.model.network.NetworkCollection;
import cat.champel.social.model.posts.Post;
import cat.champel.social.model.posts.PostCollection;
import cat.champel.social.runtime.SocialActions;
import cat.champel.social.runtime.SocialModel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

public class SocialActionsATStepsDef implements En {
	private PostCollection postCollection;
	private NetworkCollection networkCollection;
	
	private SocialActions socialActions;

	private Clock clock;
	private List<Post> posts;

	public SocialActionsATStepsDef() {
		Before(() -> {
			clock = mock(Clock.class);
			postCollection = mock(PostCollection.class);
			networkCollection = mock(NetworkCollection.class);
			socialActions = SocialActions.build(SocialModel.build(clock, postCollection, networkCollection));
		});
		// Post collection mock
		Given("{string} posts in the posts collection are", (String filter, DataTable dataTable) -> {
			List<Post> returnedPosts = mapsToPosts(dataTable.asMaps());
			if (filter.contains(",")) {
				String[] userNames = filter.split(",");
				given(postCollection.by(Set.of(userNames))).willReturn(returnedPosts);
			} else {
				String userName = filter;
				given(postCollection.by(userName)).willReturn(returnedPosts);
			}
		});
		Then("Stored posts in the post collection are", (DataTable dataTable) -> {
			dataTable.asMaps().forEach((map) -> verify(postCollection).store(mapToPost(map)));
		});
		// Network collection mock
		Given("{string} follows {string} in the network collection", (String userName, String followed) -> {
			String followedUserNames[] = followed.split(",");
			given(networkCollection.followedBy(userName)).willReturn(Set.of(followedUserNames));
		});
		Then("Following relations in network collection are stored in the network collection", (DataTable dataTable) -> {
			dataTable.asMaps().forEach((map) -> verify(networkCollection).storeFollowRelation(map.get("user"), map.get("followed_user")));
		});
		// Actions behaviour
		Given("{string} posts {string} on {string}", (String userName, String postMessage, String timestamp) -> {
			given(clock.currentTime()).willReturn(Instant.parse(timestamp));
			socialActions.postMessage().execute(userName, postMessage);
		});
		Given("{string} follows {string}", (String userName, String followedUserName) -> {
			socialActions.followUser().execute(userName, followedUserName);
		});
		When("Read {string} posts", (String userName) -> {
			posts = socialActions.readUserMessages().execute(userName);
			assertThat(posts).isNotNull();
		});
		When("Read {string} wall", (String userName) -> {
			posts = socialActions.readWallMessages().execute(userName);
			assertThat(posts).isNotNull();
		});
		Then("Returned posts are", (DataTable dataTable) -> {
			assertThat(postsToMaps()).isEqualTo(dataTable.asMaps());
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