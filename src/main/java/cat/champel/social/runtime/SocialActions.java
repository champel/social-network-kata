package cat.champel.social.runtime;

public class SocialActions {
	//TODO Create actions as final fields

	private SocialActions(SocialModel socialModel) {
		//TODO Build actions
	}
	
	public static SocialActions build(SocialModel socialModel) {
		return new SocialActions(socialModel);
	}
	

	//TODO Publish actions
	
}
