package cat.champel.social.runtime;

import cat.champel.social.actions.FollowUser;
import cat.champel.social.actions.PostUserMessage;
import cat.champel.social.actions.ReadUserMessages;
import cat.champel.social.actions.ReadWallMessages;

public class SocialActions {
	private final PostUserMessage postMessage;
	private final ReadUserMessages readUserMessages;
	private final ReadWallMessages readWallMessages;
	private final FollowUser followUser;

	private SocialActions(SocialModel socialModel) {
		this.postMessage = new PostUserMessage();
		this.readUserMessages = new ReadUserMessages();
		this.readWallMessages = new ReadWallMessages();
		this.followUser = new FollowUser();
	}
	
	public static SocialActions build(SocialModel socialModel) {
		return new SocialActions(socialModel);
	}
	

	public PostUserMessage postMessage() {
		return postMessage;
	}

	public ReadUserMessages readUserMessages() {
		return readUserMessages;
	}

	public ReadWallMessages readWallMessages() {
		return readWallMessages;
	}

	public FollowUser followUser() {
		return followUser;
	}
	
}
