package org.hk.doghub.data.content.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.loader.tip.DogHubTipLoader;
import org.hk.doghub.data.content.loader.user.DogHubUserLoader;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContentLoader {

    private final DogHubUserLoader dogHubUserContentLoader;
    private final DogHubTipLoader dogHubTipContentLoader;

    public void ensureContentLoaded() {
        long ensuredLoadedUsersCounter = dogHubUserContentLoader.load();
        long ensuredLoadedTipsCounter = dogHubTipContentLoader.load();
        long loadedEntitiesCounter = ensuredLoadedUsersCounter + ensuredLoadedTipsCounter;
        log.info("{} entities ensured loaded", loadedEntitiesCounter);
    }
}
