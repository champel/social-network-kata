package cat.champel.social.runtime;

import cat.champel.social.infrastructure.clock.Clock;
import cat.champel.social.model.network.NetworkCollection;
import cat.champel.social.model.network.NetworkService;
import cat.champel.social.model.posts.PostCollection;
import cat.champel.social.model.posts.PostsService;

public class SocialModel {
	private final PostsService postsService;
	private final NetworkService networkService;

	private SocialModel(
		Clock clock,
		PostCollection postCollection,
		NetworkCollection networkCollection)
	{
		this.postsService = new PostsService(clock, postCollection);
		this.networkService = new NetworkService(networkCollection);
	}
	
	public static SocialModel build(
		Clock clock,
		PostCollection postCollection,
		NetworkCollection networkCollection)
	{
		return new SocialModel(clock, postCollection, networkCollection);
	}
	
	public PostsService postsService() {
		return postsService;
	}

	public NetworkService networkService() {
		return networkService;
	}
}
