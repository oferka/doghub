package org.hk.doghub.data.content.verifier;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.service.DogHubUserService;
import org.hk.doghub.model.DogHubUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubUserContentVerifier {

    private final DogHubUserService dogHubUserService;

    public Iterable<DogHubUser> findLoaded(Iterable<DogHubUser> users) {
        List<DogHubUser> result = new ArrayList<>();
        for(DogHubUser user : users) {
            if(dogHubUserService.exists(user)) {
                result.add(user);
            }
        }
        log.info("{} users found as loaded", result.size());
        return result;
    }

    public Iterable<DogHubUser> findNotLoaded(Iterable<DogHubUser> users) {
        List<DogHubUser> result = new ArrayList<>();
        for(DogHubUser user : users) {
            if(!dogHubUserService.exists(user)) {
                result.add(user);
            }
        }
        log.info("{} users found as unloaded", result.size());
        return result;
    }
}
