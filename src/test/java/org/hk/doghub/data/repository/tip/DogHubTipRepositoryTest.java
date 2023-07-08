package org.hk.doghub.data.repository.tip;

import org.hk.doghub.model.tip.DogHubTip;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;

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
}