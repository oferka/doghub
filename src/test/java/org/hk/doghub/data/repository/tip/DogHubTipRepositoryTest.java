package org.hk.doghub.data.repository.tip;

import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.TransactionSystemException;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

    @RepeatedTest(10)
    void shouldSaveTipWithNullCreationTime() {
        DogHubTip item = dogHubTipProvider.get();
        item.setCreationTime(null);
        DogHubTip saved = dogHubTipRepository.save(item);
        assertNull(saved.getCreationTime());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveTipWithFutureCreationTime() {
        DogHubTip item = dogHubTipProvider.get();
        item.setCreationTime(getFutureDateTime());
        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveTipWithNullName() {
        DogHubTip item = dogHubTipProvider.get();
        item.setName(null);
        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveTipWithNameThatExceedsMaxLength() {
        DogHubTip item = dogHubTipProvider.get();
        item.setName(getNameThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveTipWithNullTitle() {
        DogHubTip item = dogHubTipProvider.get();
        item.setTitle(null);
        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveTipWithTitleThatExceedsMaxLength() {
        DogHubTip item = dogHubTipProvider.get();
        item.setTitle(getTitleThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveTipWithNonUniqueTitleAndCreatedBy() {
        DogHubTip item1 = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item1);
        DogHubTip item2 = dogHubTipProvider.get();
        item2.setTitle(item1.getTitle());
        item2.setCreatedBy(item1.getCreatedBy());
        assertThrows(DataIntegrityViolationException.class, () -> dogHubTipRepository.save(item2));
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveTipWithNullContent() {
        DogHubTip item = dogHubTipProvider.get();
        item.setContent(null);
        DogHubTip saved = dogHubTipRepository.save(item);
        assertNull(saved.getContent());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveTipWithContentThatExceedsMaxLength() {
        DogHubTip item = dogHubTipProvider.get();
        item.setContent(getContentThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveTipWithNullMoreInfo() {
        DogHubTip item = dogHubTipProvider.get();
        item.setMoreInfo(null);
        DogHubTip saved = dogHubTipRepository.save(item);
        assertNull(saved.getMoreInfo());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveTipWithMoreInfoThatExceedsMaxLength() {
        DogHubTip item = dogHubTipProvider.get();
        item.setMoreInfo(getMoreInfoThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveTipWithNullThumbnailPicture() {
        DogHubTip item = dogHubTipProvider.get();
        item.setThumbnailPicture(null);
        DogHubTip saved = dogHubTipRepository.save(item);
        assertNull(saved.getThumbnailPicture());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveTipWithThumbnailPictureThatExceedsMaxLength() {
        DogHubTip item = dogHubTipProvider.get();
        item.setThumbnailPicture(getThumbnailPictureThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveTipWithThumbnailPictureThatHasInvalidFormat() {
        DogHubTip item = dogHubTipProvider.get();
        item.setThumbnailPicture(getThumbnailPictureWithInvalidFormat());
        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveTipWithNullFeedback() {
        DogHubTip item = dogHubTipProvider.get();
        item.setFeedback(null);
        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveTipWithNullLikes() {
        DogHubTip item = dogHubTipProvider.get();
        item.getFeedback().setLikes(null);
        DogHubTip saved = dogHubTipRepository.save(item);
        assertNull(saved.getFeedback().getLikes());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveTipWithNegativeLikes() {
        DogHubTip item = dogHubTipProvider.get();
        Long negativeNumber = -10L;
        item.getFeedback().setLikes(negativeNumber);
        DogHubTip saved = dogHubTipRepository.save(item);
        assertEquals(negativeNumber, saved.getFeedback().getLikes());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveTipWithNullShares() {
        DogHubTip item = dogHubTipProvider.get();
        item.getFeedback().setShares(null);
        DogHubTip saved = dogHubTipRepository.save(item);
        assertNull(saved.getFeedback().getShares());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveTipWithNegativeShares() {
        DogHubTip item = dogHubTipProvider.get();
        Long negativeNumber = -10L;
        item.getFeedback().setShares(negativeNumber);
        DogHubTip saved = dogHubTipRepository.save(item);
        assertEquals(negativeNumber, saved.getFeedback().getShares());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveTipWithNullComments() {
        DogHubTip item = dogHubTipProvider.get();
        item.getFeedback().setComments(null);
        DogHubTip saved = dogHubTipRepository.save(item);
        assertNull(saved.getFeedback().getComments());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveTipWithNegativeComments() {
        DogHubTip item = dogHubTipProvider.get();
        Long negativeNumber = -10L;
        item.getFeedback().setComments(negativeNumber);
        DogHubTip saved = dogHubTipRepository.save(item);
        assertEquals(negativeNumber, saved.getFeedback().getComments());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveTipWithNullCreatedBy() {
        DogHubTip item = dogHubTipProvider.get();
        item.setCreatedBy(null);
        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveTipWithNonExistingCreatedBy() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubUser createdBy = item.getCreatedBy();
        createdBy.setId(getNonExistingId());
        item.setCreatedBy(createdBy);
        assertThrows(DataIntegrityViolationException.class, () -> dogHubTipRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldFindAllTips() {
        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
        List<DogHubTip> allTips = dogHubTipRepository.findAll();
        assertTrue(allTips.size() >= saved.size());
        dogHubTipRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldFindAllTipsWithPaging() {
        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
        int pageSize = 5;
        Page<DogHubTip> tips = dogHubTipRepository.findAll(PageRequest.of(0, pageSize, Sort.by(Sort.Direction.ASC, "id")));
        assertEquals(pageSize, tips.toList().size());
        dogHubTipRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldFindTipById() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertEquals(item.getTitle(), saved.getTitle());
        Optional<DogHubTip> tipOptional = dogHubTipRepository.findById(saved.getId());
        assertTrue(tipOptional.isPresent());
        assertEquals(item.getTitle(), tipOptional.get().getTitle());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotFindTipByIdNonExistingId() {
        Optional<DogHubTip> userOptional = dogHubTipRepository.findById(getNonExistingId());
        assertTrue(userOptional.isEmpty());
    }

    @RepeatedTest(10)
    void shouldFindTipByCreatedBy() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        List<DogHubTip> tips = dogHubTipRepository.findByCreatedBy(saved.getCreatedBy());
        assertFalse(tips.isEmpty());
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotFindTipByNonExistingCreatedBy() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        DogHubUser createdBy = saved.getCreatedBy();
        Long originalId = createdBy.getId();
        createdBy.setId(getNonExistingId());
        List<DogHubTip> tips = dogHubTipRepository.findByCreatedBy(createdBy);
        assertTrue(tips.isEmpty());
        createdBy.setId(originalId);
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotFindTipByNullCreatedBy() {
        List<DogHubTip> tips = dogHubTipRepository.findByCreatedBy(null);
        assertTrue(tips.isEmpty());
    }

    @RepeatedTest(10)
    void shouldFindTipByTop1ByIdGreaterThanOrderById() {
        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
        Long id = saved.get(0).getId();
        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdGreaterThanOrderById(id);
        assertTrue(tipOptional.isPresent());
        dogHubTipRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldNotFindTipByTop1ByIdGreaterThanOrderById() {
        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
        long maximalId = dogHubTipRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "id"))).iterator().next().getId();
        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdGreaterThanOrderById(maximalId);
        assertTrue(tipOptional.isEmpty());
        dogHubTipRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldFindTipByTop1ByIdLessThanOrderByIdDesc() {
        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
        Long id = saved.get(1).getId();
        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdLessThanOrderByIdDesc(id);
        assertTrue(tipOptional.isPresent());
        dogHubTipRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldNotFindTipByTop1ByIdLessThanOrderByIdDesc() {
        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
        long minimalId = dogHubTipRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "id"))).iterator().next().getId();
        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdLessThanOrderByIdDesc(minimalId);
        assertTrue(tipOptional.isEmpty());
        dogHubTipRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldFindTipByTop1ByIdGreaterThanAndCreatedByOrderById() {
        DogHubTip item1 = dogHubTipProvider.get();
        DogHubTip saved1 = dogHubTipRepository.save(item1);
        DogHubTip item2 = dogHubTipProvider.get();
        item2.setCreatedBy(item1.getCreatedBy());
        DogHubTip saved2 = dogHubTipRepository.save(item2);
        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdGreaterThanAndCreatedByOrderById(saved1.getId(), saved1.getCreatedBy());
        assertTrue(tipOptional.isPresent());
        dogHubTipRepository.delete(saved1);
        dogHubTipRepository.delete(saved2);
    }

    @RepeatedTest(10)
    void shouldNotFindTipByTop1ByIdGreaterThanAndCreatedByOrderById() {
        DogHubTip item1 = dogHubTipProvider.get();
        DogHubTip saved1 = dogHubTipRepository.save(item1);
        DogHubTip item2 = dogHubTipProvider.get();
        item2.setCreatedBy(item1.getCreatedBy());
        DogHubTip saved2 = dogHubTipRepository.save(item2);
        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdGreaterThanAndCreatedByOrderById(saved2.getId(), saved2.getCreatedBy());
        assertTrue(tipOptional.isEmpty());
        dogHubTipRepository.delete(saved1);
        dogHubTipRepository.delete(saved2);
    }

    @RepeatedTest(10)
    void shouldFindTipByTop1ByIdLessThanAndCreatedByOrderByIdDesc() {
        DogHubTip item1 = dogHubTipProvider.get();
        DogHubTip saved1 = dogHubTipRepository.save(item1);
        DogHubTip item2 = dogHubTipProvider.get();
        item2.setCreatedBy(item1.getCreatedBy());
        DogHubTip saved2 = dogHubTipRepository.save(item2);
        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdLessThanAndCreatedByOrderByIdDesc(saved2.getId(), saved2.getCreatedBy());
        assertTrue(tipOptional.isPresent());
        dogHubTipRepository.delete(saved1);
        dogHubTipRepository.delete(saved2);
    }

    @RepeatedTest(10)
    void shouldNotFindTipByTop1ByIdLessThanAndCreatedByOrderByIdDesc() {
        DogHubTip item1 = dogHubTipProvider.get();
        DogHubTip saved1 = dogHubTipRepository.save(item1);
        DogHubTip item2 = dogHubTipProvider.get();
        item2.setCreatedBy(item1.getCreatedBy());
        DogHubTip saved2 = dogHubTipRepository.save(item2);
        long minimalId = dogHubTipRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "id"))).iterator().next().getId();
        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdLessThanAndCreatedByOrderByIdDesc(minimalId, saved1.getCreatedBy());
        assertTrue(tipOptional.isEmpty());
        dogHubTipRepository.delete(saved1);
        dogHubTipRepository.delete(saved2);
    }

    @RepeatedTest(10)
    void shouldExistById() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertTrue(dogHubTipRepository.existsById(saved.getId()));
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotExistByNonExistingId() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertFalse(dogHubTipRepository.existsById(getNonExistingId()));
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldExistByIdAndCreatedBy() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertTrue(dogHubTipRepository.existsByIdAndCreatedBy(saved.getId(), saved.getCreatedBy()));
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotExistByIdAndCreatedByWithNonExistingId() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertFalse(dogHubTipRepository.existsByIdAndCreatedBy(getNonExistingId(), saved.getCreatedBy()));
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldExistByTitleAndCreatedBy() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertTrue(dogHubTipRepository.existsByTitleAndCreatedBy(saved.getTitle(), saved.getCreatedBy()));
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotExistByTitleAndCreatedByWithNonExistingTitle() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertFalse(dogHubTipRepository.existsByTitleAndCreatedBy(getNonExistingTitle(), saved.getCreatedBy()));
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldCountTips() {
        long countBefore = dogHubTipRepository.count();
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        long countAfter = dogHubTipRepository.count();
        assertEquals(countAfter, countBefore + 1);
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldCountTipsByCreatedBy() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        assertTrue(dogHubTipRepository.countByCreatedBy(saved.getCreatedBy()) > 0);
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateTipCreationTime() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        ZonedDateTime creationTime = getPastDateTime();
        saved.setCreationTime(creationTime);
        DogHubTip updated = dogHubTipRepository.save(saved);
        assertEquals(creationTime, updated.getCreationTime());
        dogHubTipRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateTipCreationTimeToNull() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        saved.setCreationTime(null);
        DogHubTip updated = dogHubTipRepository.save(saved);
        assertNull(updated.getCreationTime());
        dogHubTipRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateTipCreationTimeToFuture() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        ZonedDateTime creationTime = getFutureDateTime();
        saved.setCreationTime(creationTime);
        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(saved));
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateTipName() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        String name = dogHubTipProvider.get().getName();
        saved.setName(name);
        DogHubTip updated = dogHubTipRepository.save(item);
        assertEquals(name, updated.getName());
        dogHubTipRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateTipNameToNull() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        saved.setName(null);
        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(saved));
        dogHubTipRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotUpdateTipNameToValueThatExceedsMaxLength() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        saved.setName(getNameThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(saved));
        dogHubTipRepository.delete(saved);
    }
}