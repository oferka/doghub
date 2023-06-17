package org.hk.doghub.data.content.generator.dog.faker;

import static org.hk.doghub.data.content.generator.dog.faker.DogApiPaths.API_PATH;
import static org.hk.doghub.data.content.generator.dog.faker.DogApiPaths.RANDOM_IMAGE_FROM_ALL_DOGS_COLLECTION;

public interface DogApiUriComponents {

    String SCHEMA = "https";

    String HOST = "dog.ceo";

    String ROOT_URL = SCHEMA + "://" + HOST + "/";

    String API_ROOT_URL = ROOT_URL + API_PATH;

    String RANDOM_IMAGE_FROM_ALL_DOGS_COLLECTION_URL = API_ROOT_URL + "/" + RANDOM_IMAGE_FROM_ALL_DOGS_COLLECTION;
}
