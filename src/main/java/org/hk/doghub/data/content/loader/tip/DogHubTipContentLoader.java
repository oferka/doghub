package org.hk.doghub.data.content.loader.tip;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.loader.EntityContentLoader;
import org.hk.doghub.data.content.provider.EntityProvider;
import org.hk.doghub.data.content.provider.EntityProviderConfiguration;
import org.hk.doghub.data.service.EntityService;
import org.hk.doghub.model.tip.DogHubTip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubTipContentLoader implements EntityContentLoader<DogHubTip> {

    private final EntityProvider<DogHubTip> entityProvider;

    private final EntityProviderConfiguration<DogHubTip> providerConfiguration;

    private final EntityService<DogHubTip> entityService;

    public long load() {
        List<DogHubTip> content = entityProvider.get(providerConfiguration.getNumberOfItems());
        long savedTipsCounter = 0;
        for(DogHubTip tip : content) {
            try {
                entityService.save(tip);
                savedTipsCounter++;
            }
            catch (Exception e) {
                log.warn("Failed to save doghub tip named: '{}'", tip.getName());
            }
        }
        log.info("{} doghub tips saved", savedTipsCounter);
        return savedTipsCounter;
    }
}
