package org.hk.doghub.data.content.loader.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.loader.EntityContentLoader;
import org.hk.doghub.data.content.provider.EntityProvider;
import org.hk.doghub.data.content.provider.EntityProviderConfiguration;
import org.hk.doghub.data.service.EntityService;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubUserContentLoader implements EntityContentLoader<DogHubUser> {

    private final EntityProvider<DogHubUser> entityProvider;

    private final EntityProviderConfiguration<DogHubUser> providerConfiguration;

    private final EntityService<DogHubUser> entityService;

    public long load() {
        List<DogHubUser> content = entityProvider.get(providerConfiguration.getNumberOfItems());
        long savedUsersCounter = 0;
        for(DogHubUser user : content) {
            try {
                entityService.save(user);
                savedUsersCounter++;
            }
            catch (Exception e) {
                log.warn("Failed to save doghub user named: '{}'", user.getName());
            }
        }
        log.info("{} doghub users loaded", savedUsersCounter);
        return savedUsersCounter;
    }
}
