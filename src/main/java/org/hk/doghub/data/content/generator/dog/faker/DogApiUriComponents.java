package org.hk.doghub.data.content.generator.dog.faker;

import static org.hk.doghub.data.content.generator.dog.faker.DogApiPaths.*;

public interface DogApiUriComponents {

    String SCHEMA = "https";

    String HOST = "dog.ceo";

    String ROOT_URL = SCHEMA + "://" + HOST + "/";

    String API_ROOT_URL = ROOT_URL + API_PATH;

    String RANDOM_IMAGE_FROM_ALL_DOGS_COLLECTION_URL = API_ROOT_URL + "/" + RANDOM_IMAGE_FROM_ALL_DOGS_COLLECTION;

    String LIST_ALL_BREEDS_URL = API_ROOT_URL + "/" + LIST_ALL_BREEDS;
}
