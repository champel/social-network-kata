package cat.champel.social.runtime;

import cat.champel.social.infrastructure.clock.Clock;

public class SocialModel {

	private SocialModel(
		Clock clock
		//TODO Add repository implementations when created
	) {
		//TODO Build Model
	}
	
	public static SocialModel build(
		Clock clock
		//TODO Add repository implementations when created
	) {
		return new SocialModel(clock);
	}
	
	//TODO Serve Model
}
