package cat.champel.social.runtime;

import cat.champel.social.infrastructure.clock.Clock;
import cat.champel.social.infrastructure.inmemory.InMemoryNetworkCollection;
import cat.champel.social.infrastructure.inmemory.InMemoryPostCollection;

public class SocialInMemoryRuntime {
	private SocialInMemoryRuntime() {}
	
	public static SocialActions build() {
		return SocialActions.build(SocialModel.build(
			new Clock(),
			new InMemoryPostCollection(),
			new InMemoryNetworkCollection()
		));
	}
}
