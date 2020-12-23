package cat.champel.social.delivery.console;

import java.util.Optional;

import cat.champel.console.Command;
import cat.champel.console.CommandBuilder;
import cat.champel.social.actions.ReadUserMessages;

public class ReadMessagesCommandBuilder implements CommandBuilder {

	private final ReadUserMessages readUserMessages;

	public ReadMessagesCommandBuilder(ReadUserMessages readUserMessages) {
		this.readUserMessages = readUserMessages;
	}

	public Optional<Command> build(String readCommand) {
		String[] components = readCommand.split(" ");
		if (components.length > 1) return Optional.empty();
		String userName = components[0];
		return Optional.of(() -> Optional.of(readUserMessages.execute(userName)));
	}

}
