package cat.champel.social.model.network;

import java.util.Set;

public interface NetworkCollection {

	void storeFollowRelation(String userName, String followedUserName);
	Set<String> followedBy(String userName);

}
