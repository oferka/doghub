package org.hk.doghub.data.content.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContentLoader {

    private final DogHubUserContentLoader dogHubUserContentLoader;
//    private final DogHubUrlContentLoader dogHubUrlContentLoader;

    public void ensureContentLoaded() {
        long ensuredLoadedUsersCounter = dogHubUserContentLoader.ensureContentLoaded();
//        long ensuredLoadedUrlsCounter = dogHubUrlContentLoader.ensureContentLoaded();
//        long loadedEntitiesCounter = ensuredLoadedUsersCounter + ensuredLoadedUrlsCounter;
        long loadedEntitiesCounter = ensuredLoadedUsersCounter;
        log.info("{} entities ensured loaded", loadedEntitiesCounter);
    }
}
