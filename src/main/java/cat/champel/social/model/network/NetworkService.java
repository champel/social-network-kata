package cat.champel.social.model.network;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.stream.Stream;

public class NetworkService {
	private final NetworkCollection networkCollection;

	public NetworkService(NetworkCollection networkCollection) {
		this.networkCollection = networkCollection;
	}

	public void follow(String userName, String followedUserName) {
		networkCollection.storeFollowRelation(userName, followedUserName);
	}

	public Set<String> wallUsersBy(String userName) {
		return Stream.concat(
				Stream.of(userName), 
				networkCollection.followedBy(userName).stream()
		).collect(toSet());
	}
}
