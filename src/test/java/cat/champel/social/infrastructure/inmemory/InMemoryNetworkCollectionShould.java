package cat.champel.social.infrastructure.inmemory;

import cat.champel.social.model.network.NetworkCollection;
import cat.champel.social.model.network.NetworkCollectionShould;

public class InMemoryNetworkCollectionShould extends NetworkCollectionShould {

	@Override
	protected NetworkCollection networkCollection() {
		return new InMemoryNetworkCollection();
	}

}
