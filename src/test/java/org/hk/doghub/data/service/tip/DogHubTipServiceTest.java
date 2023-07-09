package org.hk.doghub.data.service.tip;

import org.hk.doghub.data.repository.tip.DogHubTipDataTest;
import org.hk.doghub.model.tip.DogHubTip;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DogHubTipServiceTest extends DogHubTipDataTest {

    @Autowired
    private DogHubTipService dogHubTipService;

    @RepeatedTest(10)
    void shouldFindTipById() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        Optional<DogHubTip> tipOptional = dogHubTipService.findById(saved.getId());
        assertTrue(tipOptional.isPresent());
        assertEquals(item.getTitle(), tipOptional.get().getTitle());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldFindAllTips() {
        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
        List<DogHubTip> allTips = dogHubTipService.findAll();
        assertTrue(allTips.size() >= saved.size());
        dogHubTipRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldFindAllTipsWithPaging() {
        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
        int pageSize = 5;
        Page<DogHubTip> tips = dogHubTipService.findAll(PageRequest.of(0, pageSize));
        assertEquals(pageSize, tips.toList().size());
        dogHubTipRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldSaveTip() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipService.save(item);
        assertEquals(item.getTitle(), saved.getTitle());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldCountTips() {
        long countBefore = dogHubTipService.count();
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        long countAfter = dogHubTipService.count();
        assertEquals(countAfter, countBefore + 1);
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldExistForExistingTip() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertTrue(dogHubTipService.exists(saved));
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotExistForNonExistingTitle() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        saved.setTitle(dogHubTipProvider.get().getTitle());
        assertFalse(dogHubTipService.exists(saved));
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldExistByIdAndCreatedByForExistingTip() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertTrue(dogHubTipService.existsByIdAndCreatedBy(saved.getId(), saved.getCreatedBy()));
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotExistByIdAndCreatedByForNonExistingId() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertFalse(dogHubTipService.existsByIdAndCreatedBy(getNonExistingId(), saved.getCreatedBy()));
        dogHubTipRepository.delete(saved);
    }
}