package org.hk.doghub.data.content.generator.user.randomme;

import static org.hk.doghub.data.content.generator.user.randomme.RandomMePaths.API_PATH;

public interface RandomMeUriComponents {

    String SCHEMA = "https";

    String HOST = "randomuser.me";

    String ROOT_URL = SCHEMA + "://" + HOST + "/";

    String API_ROOT_URL = ROOT_URL + API_PATH;
}
