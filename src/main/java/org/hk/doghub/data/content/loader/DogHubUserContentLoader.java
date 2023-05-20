package org.hk.doghub.data.content.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.hk.doghub.data.content.provider.DogHubUserContentProvider;
import org.hk.doghub.data.content.provider.DogHubUserContentProviderConfiguration;
import org.hk.doghub.data.content.verifier.DogHubUserContentVerifier;
import org.hk.doghub.data.service.DogHubUserService;
import org.hk.doghub.model.DogHubUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubUserContentLoader {

    private final DogHubUserContentProvider contentProvider;

    private final DogHubUserContentVerifier contentVerifier;

    private final DogHubUserContentProviderConfiguration contentProviderConfiguration;

    private final DogHubUserService dogHubUserService;

    public long ensureContentLoaded() {
        List<DogHubUser> content = contentProvider.get(contentProviderConfiguration.getNumberOfItems());
        Iterable<DogHubUser> unloadedContent = contentVerifier.findNotLoaded(content);
        if(!IterableUtils.isEmpty(unloadedContent)) {
            Iterable<DogHubUser> saved = dogHubUserService.saveAll(unloadedContent);
            log.info("{} doghub users saved", IterableUtils.size(saved));
        }
        log.info("{} doghub users ensured loaded", content.size());
        return content.size();
    }
}
