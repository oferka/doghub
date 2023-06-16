package org.hk.doghub.data.content.loader.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.provider.user.AdminDogHubUserProvider;
import org.hk.doghub.data.service.user.DogHubUserService;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminDogHubUserContentLoader {

    private final AdminDogHubUserProvider contentProvider;

    private final DogHubUserService usaUserService;

    public void ensureContentLoaded() {
        DogHubUser adminUsaUser = contentProvider.get();
        if(!usaUserService.exists(adminUsaUser)) {
            usaUserService.save(adminUsaUser);
        }
    }
}
