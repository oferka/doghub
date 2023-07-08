package org.hk.doghub.data.repository.tip;

import org.hk.doghub.model.tip.DogHubTip;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DogHubTipRepositoryTest extends DogHubTipDataTest {

    @RepeatedTest(10)
    void shouldSaveTip() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertEquals(item.getTitle(), saved.getTitle());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveAllTips() {
        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
        assertEquals(saved.size(), items.size());
        dogHubTipRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldSaveTipWithSpecifiedNonExistingId() {
        DogHubTip item = dogHubTipProvider.get();
        item.setId(getNonExistingId());
        DogHubTip saved = dogHubTipRepository.save(item);
        assertNotEquals(item.getId(), saved.getId());
        dogHubTipRepository.delete(saved);
    }
}