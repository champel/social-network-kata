package cat.champel.social.delivery.console;

import java.util.Optional;

import cat.champel.console.Command;
import cat.champel.console.CommandBuilder;
import cat.champel.social.actions.PostUserMessage;

public class PostCommandBuilder implements CommandBuilder {


	public static final String ARROW = " -> ";
	private final PostUserMessage postUserMessage;

	PostCommandBuilder(PostUserMessage postUserMessage) {
		this.postUserMessage = postUserMessage;
	}
	
	@Override
	public Optional<Command> build(String userCommand) {
		if (!userCommand.contains(ARROW)) return Optional.empty();
		String[] components = userCommand.split(ARROW);
		String userName = components[0];
		String message = components[1];
		return Optional.of(() -> {
			postUserMessage.execute(userName, message);
			return Optional.empty();
		});
	}
}
