package org.hk.doghub.data.content.loader.tip;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.hk.doghub.data.content.provider.tip.DogHubTipContentProvider;
import org.hk.doghub.data.content.verifier.tip.DogHubTipContentVerifier;
import org.hk.doghub.data.service.tip.DogHubTipService;
import org.hk.doghub.model.tip.DogHubTip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubTipContentLoader {

    private final DogHubTipContentProvider contentProvider;

    private final DogHubTipContentVerifier contentVerifier;

    private final DogHubTipContentProviderConfiguration contentProviderConfiguration;

    private final DogHubTipService dogHubTipService;

    public long ensureContentLoaded() {
        List<DogHubTip> content = contentProvider.get(contentProviderConfiguration.getNumberOfItems());
        Iterable<DogHubTip> unloadedContent = contentVerifier.findNotLoaded(content);
        if(!IterableUtils.isEmpty(unloadedContent)) {
            Iterable<DogHubTip> saved = dogHubTipService.saveAll(unloadedContent);
            log.info("{} doghub tips saved", IterableUtils.size(saved));
        }
        log.info("{} doghub tips ensured loaded", content.size());
        return content.size();
    }
}
