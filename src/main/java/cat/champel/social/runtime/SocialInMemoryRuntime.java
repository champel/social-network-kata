package cat.champel.social.runtime;

import cat.champel.social.infrastructure.clock.Clock;

public class SocialInMemoryRuntime {
	private SocialInMemoryRuntime() {}
	
	public static SocialActions build() {
		return SocialActions.build(SocialModel.build(
			new Clock(),
			//TODO Inject repository implementations when created
			null,
			null
		));
	}
}
