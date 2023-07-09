package org.hk.doghub.data.service.tip;

import jakarta.validation.ConstraintViolationException;
import org.hk.doghub.data.repository.tip.DogHubTipDataTest;
import org.hk.doghub.model.tip.DogHubTip;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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

    @RepeatedTest(10)
    void shouldExistByTitleAndCreatedByForExistingTip() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertTrue(dogHubTipService.existsByTitleAndCreatedBy(saved.getTitle(), saved.getCreatedBy()));
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotExistByTitleAndCreatedByForNonExistingTitle() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertFalse(dogHubTipService.existsByTitleAndCreatedBy(getNonExistingTitle(), saved.getCreatedBy()));
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldFindPreviousTip() {
        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
        List<DogHubTip> allTips = dogHubTipRepository.findAll();
        int index = 5;
        Optional<DogHubTip> tipOptional = dogHubTipService.findPrevious(allTips.get(index).getId());
        assertTrue(tipOptional.isPresent());
        assertEquals(allTips.get(index-1).getId(), tipOptional.get().getId());
        dogHubTipRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldNotFindPreviousTipOnMinimalId() {
        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
        long minimalId = dogHubTipRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "id"))).iterator().next().getId();
        Optional<DogHubTip> tipOptional = dogHubTipService.findPrevious(minimalId);
        assertTrue(tipOptional.isEmpty());
        dogHubTipRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldFindNextTip() {
        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
        List<DogHubTip> allTips = dogHubTipRepository.findAll();
        int index = 5;
        Optional<DogHubTip> tipOptional = dogHubTipService.findNext(allTips.get(index).getId());
        assertTrue(tipOptional.isPresent());
        assertEquals(allTips.get(index+1).getId(), tipOptional.get().getId());
        dogHubTipRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldNotFindNextTipOnMaximalId() {
        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
        long maximalId = dogHubTipRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "id"))).iterator().next().getId();
        Optional<DogHubTip> tipOptional = dogHubTipService.findNext(maximalId);
        assertTrue(tipOptional.isEmpty());
        dogHubTipRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldFindTipByCreatedBy() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertFalse(dogHubTipService.findByCreatedBy(saved.getCreatedBy()).isEmpty());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotFindTipByNullCreatedBy() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertThrows(ConstraintViolationException.class, () -> dogHubTipService.findByCreatedBy(null));
        dogHubTipRepository.delete(saved);
    }
}