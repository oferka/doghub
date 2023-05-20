package org.hk.doghub.data.content.verifier;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.service.DogHubTipService;
import org.hk.doghub.model.DogHubTip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubTipContentVerifier {

    private final DogHubTipService dogHubTipService;

    public Iterable<DogHubTip> findLoaded(Iterable<DogHubTip> tips) {
        List<DogHubTip> result = new ArrayList<>();
        for(DogHubTip tip : tips) {
            if(dogHubTipService.exists(tip)) {
                result.add(tip);
            }
        }
        log.info("{} tips found as loaded", result.size());
        return result;
    }

    public Iterable<DogHubTip> findNotLoaded(Iterable<DogHubTip> tips) {
        List<DogHubTip> result = new ArrayList<>();
        for(DogHubTip tip : tips) {
            if(!dogHubTipService.exists(tip)) {
                result.add(tip);
            }
        }
        log.info("{} tips found as unloaded", result.size());
        return result;
    }
}
