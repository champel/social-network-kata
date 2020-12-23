package cat.champel.social.model.posts;

import java.time.Instant;

public class Post {

	private final String userName;
	private final String message;
	private final Instant timestamp;

	private Post(String userName, String message, Instant timestamp) {
		this.userName = userName;
		this.message = message;
		this.timestamp = timestamp;
	}

	public static Post create(String userName, String message, Instant timestamp) {
		return new Post(userName, message, timestamp);
	}

	public String getUserName() {
		return userName;
	}

	public String getMessage() {
		return message;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

}
