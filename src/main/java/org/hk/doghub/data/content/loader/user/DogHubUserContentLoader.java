package org.hk.doghub.data.content.loader.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.provider.user.DogHubUserContentProvider;
import org.hk.doghub.data.content.provider.user.DogHubUserContentProviderConfiguration;
import org.hk.doghub.data.service.user.DogHubUserService;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubUserContentLoader {

    private final DogHubUserContentProvider contentProvider;

    private final DogHubUserContentProviderConfiguration contentProviderConfiguration;

    private final DogHubUserService dogHubUserService;

    public long load() {
        List<DogHubUser> content = contentProvider.get(contentProviderConfiguration.getNumberOfItems());
        long savedUsersCounter = 0;
        for(DogHubUser user : content) {
            try {
                dogHubUserService.save(user);
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
