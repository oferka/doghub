package org.hk.doghub.data.content.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.provider.AdminDogHubUserContentProvider;
import org.hk.doghub.data.service.DogHubUserService;
import org.hk.doghub.model.DogHubUser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminDogHubUserContentLoader {

    private final AdminDogHubUserContentProvider contentProvider;

    private final DogHubUserService usaUserService;

    public void ensureContentLoaded() {
        DogHubUser adminUsaUser = contentProvider.get();
        if(!usaUserService.exists(adminUsaUser)) {
            usaUserService.save(adminUsaUser);
        }
    }
}
