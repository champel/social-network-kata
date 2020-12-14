package cat.champel.social.infrastructure.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import cat.champel.social.model.network.NetworkCollection;

public class InMemoryNetworkCollection implements NetworkCollection {
	
	private final HashMap<String, Set<String>> following;

	public InMemoryNetworkCollection() {
		this.following = new HashMap<String, Set<String>>();
	}

	@Override
	public Set<String> followedBy(String userName) {
		return following.getOrDefault(userName, new HashSet<>());
	}

	@Override
	public void storeFollowRelation(String userName, String followedUserName) {
		Set<String> followed = followedBy(userName);
		followed.add(followedUserName);
		following.put(userName, followed);
	}

}
