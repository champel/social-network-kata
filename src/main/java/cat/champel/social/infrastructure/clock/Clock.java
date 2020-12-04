package cat.champel.social.infrastructure.clock;

import java.time.Instant;

public class Clock {
	public Instant currentTime() {
		return java.time.Clock.systemDefaultZone().instant();
	}
}
