package cat.champel.social.actions;

import cat.champel.social.model.network.NetworkService;

public class FollowUser {

	private final NetworkService networkService;

	public FollowUser(NetworkService networkService) {
		this.networkService = networkService;
	}

	public void execute(String userName, String followedUserName) {
		networkService.follow(userName, followedUserName);
	}

}
