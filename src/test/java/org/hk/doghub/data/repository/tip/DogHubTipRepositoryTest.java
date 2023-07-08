package org.hk.doghub.data.repository.tip;

import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.TransactionSystemException;

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
}