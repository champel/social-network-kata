package cat.champel.social.delivery.console;

import java.util.Optional;

import cat.champel.console.Command;
import cat.champel.console.CommandBuilder;
import cat.champel.social.actions.FollowUser;

public class FollowCommandBuilder implements CommandBuilder {

	public static final String FOLLOWS = " follows ";

	private final FollowUser followUser;

	public FollowCommandBuilder(FollowUser followUser) {
		this.followUser = followUser;
	}

	public Optional<Command> build(String userCommand) {
		if (!userCommand.contains(FOLLOWS)) return Optional.empty();
		String[] components = userCommand.split(FOLLOWS);
		String userName = components[0];
		String followedUser = components[1];
		return Optional.of(() -> {
			followUser.execute(userName, followedUser);
			return Optional.empty();
		});
	}

}
