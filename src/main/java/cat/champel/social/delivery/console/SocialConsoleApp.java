package cat.champel.social.delivery.console;

import java.util.List;
import java.util.Map;

import cat.champel.console.ConsoleApp;
import cat.champel.social.model.posts.Post;
import cat.champel.social.runtime.SocialActions;
import cat.champel.social.runtime.SocialInMemoryRuntime;

public class SocialConsoleApp extends ConsoleApp {
	public SocialConsoleApp() {
		this(SocialInMemoryRuntime.build());
	}

	public SocialConsoleApp(SocialActions socialActions) {
		super(List.of(
				new PostCommandBuilder(socialActions.postMessage()),
				new FollowCommandBuilder(socialActions.followUser()),
				new WallMessagesCommandBuilder(socialActions.readWallMessages()),
				new ReadMessagesCommandBuilder(socialActions.readUserMessages())
			), Map.of(
				Post.class, new PostFormatter()
			));
	}
	
	public static void main(String[] args) {
		new SocialConsoleApp().run();
	}
}
