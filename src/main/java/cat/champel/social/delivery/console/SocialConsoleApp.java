package cat.champel.social.delivery.console;

import java.util.List;
import java.util.Map;

import cat.champel.console.ConsoleApp;
import cat.champel.social.runtime.SocialActions;
import cat.champel.social.runtime.SocialInMemoryRuntime;

public class SocialConsoleApp extends ConsoleApp {
	public SocialConsoleApp() {
		this(SocialInMemoryRuntime.build());
	}

	public SocialConsoleApp(SocialActions socialActions) {
		super(List.of(
				//TODO Assign command builders
			), Map.of(
				//TODO Assign command builders
			));
	}
	
	public static void main(String[] args) {
		new SocialConsoleApp().run();
	}
}
