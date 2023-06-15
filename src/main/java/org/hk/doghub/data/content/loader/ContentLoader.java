package org.hk.doghub.data.content.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.loader.tip.DogHubTipLoader;
import org.hk.doghub.data.content.loader.user.DogHubUserLoader;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContentLoader {

    private final EntityLoader<DogHubUser> dogHubUserLoader;
    private final EntityLoader<DogHubTip> dogHubTipLoader;

    public void load() {
        long ensuredLoadedUsersCounter = dogHubUserLoader.load();
        long ensuredLoadedTipsCounter = dogHubTipLoader.load();
        long loadedEntitiesCounter = ensuredLoadedUsersCounter + ensuredLoadedTipsCounter;
        log.info("{} entities loaded", loadedEntitiesCounter);
    }
}
