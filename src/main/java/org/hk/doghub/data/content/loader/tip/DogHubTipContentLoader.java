package org.hk.doghub.data.content.loader.tip;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.provider.tip.DogHubTipContentProvider;
import org.hk.doghub.data.service.tip.DogHubTipService;
import org.hk.doghub.model.tip.DogHubTip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubTipContentLoader {

    private final DogHubTipContentProvider contentProvider;

    private final DogHubTipContentProviderConfiguration contentProviderConfiguration;

    private final DogHubTipService dogHubTipService;

    public long load() {
        List<DogHubTip> content = contentProvider.get(contentProviderConfiguration.getNumberOfItems());
        long savedTipsCounter = 0;
        for(DogHubTip tip : content) {
            try {
                dogHubTipService.save(tip);
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
