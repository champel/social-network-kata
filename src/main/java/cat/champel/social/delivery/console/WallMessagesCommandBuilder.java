package cat.champel.social.delivery.console;

import java.util.Optional;

import cat.champel.console.Command;
import cat.champel.console.CommandBuilder;
import cat.champel.social.actions.ReadWallMessages;

public class WallMessagesCommandBuilder implements CommandBuilder {

	public static final String WALL = " wall";
	private final ReadWallMessages readWallMessages;

	public WallMessagesCommandBuilder(ReadWallMessages readWallMessages) {
		this.readWallMessages = readWallMessages;
	}

	public Optional<Command> build(String userCommand) {
		if (!userCommand.endsWith(WALL)) return Optional.empty();
		String[] components = userCommand.split(WALL);
		String userName = components[0];
		return Optional.of(() -> {
			return Optional.of(readWallMessages.execute(userName));
		});
	}

}
