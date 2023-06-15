package org.hk.doghub.data.content.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContentLoader {

    private final AbstractEntityLoader<DogHubUser> dogHubUserLoader;
    private final AbstractEntityLoader<DogHubTip> dogHubTipLoader;

    public void load() {
        List<EntityLoader> entityLoaders = asList(
                dogHubUserLoader,
                dogHubTipLoader
        );
        long loadedEntitiesCounter = 0;
        for(EntityLoader entityLoader : entityLoaders) {
            loadedEntitiesCounter += entityLoader.load();
        }
        log.info("{} entities loaded", loadedEntitiesCounter);
    }
}
