package cat.champel.social.infrastructure.inmemory;

import cat.champel.social.model.posts.PostCollection;
import cat.champel.social.model.posts.PostCollectionShould;

public class InMemoryPostCollectionShould extends PostCollectionShould {

	@Override
	public PostCollection postCollection() {
		return new InMemoryPostCollection();
	}

}
