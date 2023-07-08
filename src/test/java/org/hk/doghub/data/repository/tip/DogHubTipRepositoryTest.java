package org.hk.doghub.data.repository.tip;

import org.hk.doghub.model.tip.DogHubTip;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DogHubTipRepositoryTest extends DogHubTipDataTest {

    @RepeatedTest(10)
    void shouldSaveTip() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertEquals(item.getTitle(), saved.getTitle());
        dogHubTipRepository.delete(saved);
    }
}