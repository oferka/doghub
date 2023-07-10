package org.hk.doghub.data.repository.dog;

import org.hk.doghub.model.dog.DogHubDog;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DogHubDogRepositoryTest extends DogHubDogDataTest {

    @RepeatedTest(10)
    void shouldSaveDog() {
        DogHubDog item = dogHubDogProvider.get();
        DogHubDog saved = dogHubDogRepository.save(item);
        assertEquals(item.getName(), saved.getName());
        dogHubDogRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveAllDogs() {
        List<DogHubDog> items = dogHubDogProvider.get(getNumberOfItemsToLoad());
        List<DogHubDog> saved = dogHubDogRepository.saveAll(items);
        assertEquals(saved.size(), items.size());
        dogHubDogRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldSaveDogWithSpecifiedNonExistingId() {
        DogHubDog item = dogHubDogProvider.get();
        item.setId(getNonExistingId());
        DogHubDog saved = dogHubDogRepository.save(item);
        assertNotEquals(item.getId(), saved.getId());
        dogHubDogRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveDogWithNullCreationTime() {
        DogHubDog item = dogHubDogProvider.get();
        item.setCreationTime(null);
        DogHubDog saved = dogHubDogRepository.save(item);
        assertNull(saved.getCreationTime());
        dogHubDogRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveDogWithFutureCreationTime() {
        DogHubDog item = dogHubDogProvider.get();
        item.setCreationTime(getFutureDateTime());
        assertThrows(TransactionSystemException.class, () -> dogHubDogRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveDogWithNullName() {
        DogHubDog item = dogHubDogProvider.get();
        item.setName(null);
        assertThrows(TransactionSystemException.class, () -> dogHubDogRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveDogWithNameThatExceedsMaxLength() {
        DogHubDog item = dogHubDogProvider.get();
        item.setName(getNameThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubDogRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveDogWithNonUniqueNameAndCreatedBy() {
        DogHubDog item1 = dogHubDogProvider.get();
        DogHubDog saved = dogHubDogRepository.save(item1);
        DogHubDog item2 = dogHubDogProvider.get();
        item2.setName(item1.getName());
        item2.setCreatedBy(item1.getCreatedBy());
        assertThrows(DataIntegrityViolationException.class, () -> dogHubDogRepository.save(item2));
        dogHubDogRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveDogWithNullBreed() {
        DogHubDog item = dogHubDogProvider.get();
        item.setBreed(null);
        DogHubDog saved = dogHubDogRepository.save(item);
        assertNull(saved.getBreed());
        dogHubDogRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveDogWithBreedThatExceedsMaxLength() {
        DogHubDog item = dogHubDogProvider.get();
        item.setBreed(getBreedThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubDogRepository.save(item));
    }


//    @RepeatedTest(10)
//    void shouldSaveTipWithNullThumbnailPicture() {
//        DogHubTip item = dogHubTipProvider.get();
//        item.setThumbnailPicture(null);
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertNull(saved.getThumbnailPicture());
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotSaveTipWithThumbnailPictureThatExceedsMaxLength() {
//        DogHubTip item = dogHubTipProvider.get();
//        item.setThumbnailPicture(getThumbnailPictureThatExceedsMaxLength());
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
//    }
//
//    @RepeatedTest(10)
//    void shouldNotSaveTipWithThumbnailPictureThatHasInvalidFormat() {
//        DogHubTip item = dogHubTipProvider.get();
//        item.setThumbnailPicture(getThumbnailPictureWithInvalidFormat());
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
//    }
//
//    @RepeatedTest(10)
//    void shouldNotSaveTipWithNullFeedback() {
//        DogHubTip item = dogHubTipProvider.get();
//        item.setFeedback(null);
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
//    }
//
//    @RepeatedTest(10)
//    void shouldSaveTipWithNullLikes() {
//        DogHubTip item = dogHubTipProvider.get();
//        item.getFeedback().setLikes(null);
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertNull(saved.getFeedback().getLikes());
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldSaveTipWithNegativeLikes() {
//        DogHubTip item = dogHubTipProvider.get();
//        Long negativeNumber = -10L;
//        item.getFeedback().setLikes(negativeNumber);
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertEquals(negativeNumber, saved.getFeedback().getLikes());
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldSaveTipWithNullShares() {
//        DogHubTip item = dogHubTipProvider.get();
//        item.getFeedback().setShares(null);
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertNull(saved.getFeedback().getShares());
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldSaveTipWithNegativeShares() {
//        DogHubTip item = dogHubTipProvider.get();
//        Long negativeNumber = -10L;
//        item.getFeedback().setShares(negativeNumber);
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertEquals(negativeNumber, saved.getFeedback().getShares());
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldSaveTipWithNullComments() {
//        DogHubTip item = dogHubTipProvider.get();
//        item.getFeedback().setComments(null);
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertNull(saved.getFeedback().getComments());
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldSaveTipWithNegativeComments() {
//        DogHubTip item = dogHubTipProvider.get();
//        Long negativeNumber = -10L;
//        item.getFeedback().setComments(negativeNumber);
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertEquals(negativeNumber, saved.getFeedback().getComments());
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotSaveTipWithNullCreatedBy() {
//        DogHubTip item = dogHubTipProvider.get();
//        item.setCreatedBy(null);
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(item));
//    }
//
//    @RepeatedTest(10)
//    void shouldNotSaveTipWithNonExistingCreatedBy() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubUser createdBy = item.getCreatedBy();
//        createdBy.setId(getNonExistingId());
//        item.setCreatedBy(createdBy);
//        assertThrows(DataIntegrityViolationException.class, () -> dogHubTipRepository.save(item));
//    }
//
//    @RepeatedTest(10)
//    void shouldFindAllTips() {
//        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
//        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
//        List<DogHubTip> allTips = dogHubTipRepository.findAll();
//        assertTrue(allTips.size() >= saved.size());
//        dogHubTipRepository.deleteAll(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldFindAllTipsWithPaging() {
//        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
//        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
//        int pageSize = 5;
//        Page<DogHubTip> tips = dogHubTipRepository.findAll(PageRequest.of(0, pageSize, Sort.by(Sort.Direction.ASC, "id")));
//        assertEquals(pageSize, tips.toList().size());
//        dogHubTipRepository.deleteAll(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldFindTipById() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertEquals(item.getTitle(), saved.getTitle());
//        Optional<DogHubTip> tipOptional = dogHubTipRepository.findById(saved.getId());
//        assertTrue(tipOptional.isPresent());
//        assertEquals(item.getTitle(), tipOptional.get().getTitle());
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotFindTipByIdNonExistingId() {
//        Optional<DogHubTip> userOptional = dogHubTipRepository.findById(getNonExistingId());
//        assertTrue(userOptional.isEmpty());
//    }
//
//    @RepeatedTest(10)
//    void shouldFindTipByCreatedBy() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        List<DogHubTip> tips = dogHubTipRepository.findByCreatedBy(saved.getCreatedBy());
//        assertFalse(tips.isEmpty());
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotFindTipByNonExistingCreatedBy() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        DogHubUser createdBy = saved.getCreatedBy();
//        Long originalId = createdBy.getId();
//        createdBy.setId(getNonExistingId());
//        List<DogHubTip> tips = dogHubTipRepository.findByCreatedBy(createdBy);
//        assertTrue(tips.isEmpty());
//        createdBy.setId(originalId);
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotFindTipByNullCreatedBy() {
//        List<DogHubTip> tips = dogHubTipRepository.findByCreatedBy(null);
//        assertTrue(tips.isEmpty());
//    }
//
//    @RepeatedTest(10)
//    void shouldFindTipByTop1ByIdGreaterThanOrderById() {
//        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
//        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
//        Long id = saved.get(0).getId();
//        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdGreaterThanOrderById(id);
//        assertTrue(tipOptional.isPresent());
//        dogHubTipRepository.deleteAll(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotFindTipByTop1ByIdGreaterThanOrderById() {
//        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
//        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
//        long maximalId = dogHubTipRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "id"))).iterator().next().getId();
//        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdGreaterThanOrderById(maximalId);
//        assertTrue(tipOptional.isEmpty());
//        dogHubTipRepository.deleteAll(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldFindTipByTop1ByIdLessThanOrderByIdDesc() {
//        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
//        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
//        Long id = saved.get(1).getId();
//        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdLessThanOrderByIdDesc(id);
//        assertTrue(tipOptional.isPresent());
//        dogHubTipRepository.deleteAll(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotFindTipByTop1ByIdLessThanOrderByIdDesc() {
//        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
//        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
//        long minimalId = dogHubTipRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "id"))).iterator().next().getId();
//        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdLessThanOrderByIdDesc(minimalId);
//        assertTrue(tipOptional.isEmpty());
//        dogHubTipRepository.deleteAll(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldFindTipByTop1ByIdGreaterThanAndCreatedByOrderById() {
//        DogHubTip item1 = dogHubTipProvider.get();
//        DogHubTip saved1 = dogHubTipRepository.save(item1);
//        DogHubTip item2 = dogHubTipProvider.get();
//        item2.setCreatedBy(item1.getCreatedBy());
//        DogHubTip saved2 = dogHubTipRepository.save(item2);
//        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdGreaterThanAndCreatedByOrderById(saved1.getId(), saved1.getCreatedBy());
//        assertTrue(tipOptional.isPresent());
//        dogHubTipRepository.delete(saved1);
//        dogHubTipRepository.delete(saved2);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotFindTipByTop1ByIdGreaterThanAndCreatedByOrderById() {
//        DogHubTip item1 = dogHubTipProvider.get();
//        DogHubTip saved1 = dogHubTipRepository.save(item1);
//        DogHubTip item2 = dogHubTipProvider.get();
//        item2.setCreatedBy(item1.getCreatedBy());
//        DogHubTip saved2 = dogHubTipRepository.save(item2);
//        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdGreaterThanAndCreatedByOrderById(saved2.getId(), saved2.getCreatedBy());
//        assertTrue(tipOptional.isEmpty());
//        dogHubTipRepository.delete(saved1);
//        dogHubTipRepository.delete(saved2);
//    }
//
//    @RepeatedTest(10)
//    void shouldFindTipByTop1ByIdLessThanAndCreatedByOrderByIdDesc() {
//        DogHubTip item1 = dogHubTipProvider.get();
//        DogHubTip saved1 = dogHubTipRepository.save(item1);
//        DogHubTip item2 = dogHubTipProvider.get();
//        item2.setCreatedBy(item1.getCreatedBy());
//        DogHubTip saved2 = dogHubTipRepository.save(item2);
//        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdLessThanAndCreatedByOrderByIdDesc(saved2.getId(), saved2.getCreatedBy());
//        assertTrue(tipOptional.isPresent());
//        dogHubTipRepository.delete(saved1);
//        dogHubTipRepository.delete(saved2);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotFindTipByTop1ByIdLessThanAndCreatedByOrderByIdDesc() {
//        DogHubTip item1 = dogHubTipProvider.get();
//        DogHubTip saved1 = dogHubTipRepository.save(item1);
//        DogHubTip item2 = dogHubTipProvider.get();
//        item2.setCreatedBy(item1.getCreatedBy());
//        DogHubTip saved2 = dogHubTipRepository.save(item2);
//        long minimalId = dogHubTipRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "id"))).iterator().next().getId();
//        Optional<DogHubTip> tipOptional = dogHubTipRepository.findTop1ByIdLessThanAndCreatedByOrderByIdDesc(minimalId, saved1.getCreatedBy());
//        assertTrue(tipOptional.isEmpty());
//        dogHubTipRepository.delete(saved1);
//        dogHubTipRepository.delete(saved2);
//    }
//
//    @RepeatedTest(10)
//    void shouldExistById() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertTrue(dogHubTipRepository.existsById(saved.getId()));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotExistByNonExistingId() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertFalse(dogHubTipRepository.existsById(getNonExistingId()));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldExistByIdAndCreatedBy() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertTrue(dogHubTipRepository.existsByIdAndCreatedBy(saved.getId(), saved.getCreatedBy()));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotExistByIdAndCreatedByWithNonExistingId() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertFalse(dogHubTipRepository.existsByIdAndCreatedBy(getNonExistingId(), saved.getCreatedBy()));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldExistByTitleAndCreatedBy() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertTrue(dogHubTipRepository.existsByTitleAndCreatedBy(saved.getTitle(), saved.getCreatedBy()));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotExistByTitleAndCreatedByWithNonExistingTitle() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertFalse(dogHubTipRepository.existsByTitleAndCreatedBy(getNonExistingTitle(), saved.getCreatedBy()));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldCountTips() {
//        long countBefore = dogHubTipRepository.count();
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        long countAfter = dogHubTipRepository.count();
//        assertEquals(countAfter, countBefore + 1);
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldCountTipsByCreatedBy() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        assertTrue(dogHubTipRepository.countByCreatedBy(saved.getCreatedBy()) > 0);
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipCreationTime() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        ZonedDateTime creationTime = getPastDateTime();
//        saved.setCreationTime(creationTime);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertEquals(creationTime, updated.getCreationTime());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipCreationTimeToNull() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.setCreationTime(null);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertNull(updated.getCreationTime());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotUpdateTipCreationTimeToFuture() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        ZonedDateTime creationTime = getFutureDateTime();
//        saved.setCreationTime(creationTime);
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(saved));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipName() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        String name = dogHubTipProvider.get().getName();
//        saved.setName(name);
//        DogHubTip updated = dogHubTipRepository.save(item);
//        assertEquals(name, updated.getName());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotUpdateTipNameToNull() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.setName(null);
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(saved));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotUpdateTipNameToValueThatExceedsMaxLength() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.setName(getNameThatExceedsMaxLength());
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(saved));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipTitle() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        String title = dogHubTipProvider.get().getTitle();
//        saved.setTitle(title);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertEquals(title, updated.getTitle());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotUpdateTipTitleToNull() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.setTitle(null);
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(saved));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotUpdateTipTitleToValueThatExceedsMaxLength() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.setTitle(getTitleThatExceedsMaxLength());
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(saved));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotUpdateTipTitleToNonUniqueValueCombinedWithCreatedBy() {
//        List<DogHubTip> items = dogHubTipProvider.get(getNumberOfItemsToLoad());
//        List<DogHubTip> saved = dogHubTipRepository.saveAll(items);
//        DogHubTip first = saved.get(0);
//        DogHubTip second = saved.get(1);
//        second.setTitle(first.getTitle());
//        second.setCreatedBy(first.getCreatedBy());
//        assertThrows(DataIntegrityViolationException.class, () -> dogHubTipRepository.save(second));
//        dogHubTipRepository.deleteAll(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipContent() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        String content = dogHubTipProvider.get().getContent();
//        saved.setContent(content);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertEquals(content, updated.getContent());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipContentToNull() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.setContent(null);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertNull(updated.getContent());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotUpdateTipContentToValueThatExceedsMaxLength() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.setContent(getContentThatExceedsMaxLength());
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(saved));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipMoreInfo() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        String moreInfo = dogHubTipProvider.get().getMoreInfo();
//        saved.setMoreInfo(moreInfo);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertEquals(moreInfo, updated.getMoreInfo());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipMoreInfoToNull() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.setMoreInfo(null);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertNull(updated.getMoreInfo());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotUpdateTipMoreInfoToValueThatExceedsMaxLength() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.setMoreInfo(getMoreInfoThatExceedsMaxLength());
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(saved));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipThumbnailPicture() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        String thumbnailPicture = dogHubTipProvider.get().getThumbnailPicture();
//        saved.setThumbnailPicture(thumbnailPicture);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertEquals(thumbnailPicture, updated.getThumbnailPicture());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipThumbnailPictureToNull() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.setThumbnailPicture(null);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertNull(updated.getThumbnailPicture());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotUpdateTipThumbnailPictureToValueThatExceedsMaxLength() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.setThumbnailPicture(getThumbnailPictureThatExceedsMaxLength());
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(saved));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotUpdateTipThumbnailPictureToValueThatHasInvalidFormat() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.setThumbnailPicture(getThumbnailPictureWithInvalidFormat());
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(saved));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipFeedback() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        DogHubFeedback feedback = dogHubTipProvider.get().getFeedback();
//        saved.setFeedback(feedback);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertEquals(feedback, updated.getFeedback());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotUpdateTipFeedbackToNull() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.setFeedback(null);
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(saved));
//        dogHubTipRepository.delete(saved);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipLikes() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        Long likes = dogHubTipProvider.get().getFeedback().getLikes();
//        saved.getFeedback().setLikes(likes);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertEquals(likes, updated.getFeedback().getLikes());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipLikesToNull() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.getFeedback().setLikes(null);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertNull(updated.getFeedback().getLikes());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipLikesToNegativeValue() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.getFeedback().setLikes(-10L);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertEquals(-10, updated.getFeedback().getLikes());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipShares() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        Long shares = dogHubTipProvider.get().getFeedback().getShares();
//        saved.getFeedback().setShares(shares);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertEquals(shares, updated.getFeedback().getShares());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipSharesToNull() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.getFeedback().setShares(null);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertNull(updated.getFeedback().getShares());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipSharesToNegativeValue() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.getFeedback().setShares(-10L);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertEquals(-10, updated.getFeedback().getShares());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipComments() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        Long comments = dogHubTipProvider.get().getFeedback().getComments();
//        saved.getFeedback().setComments(comments);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertEquals(comments, updated.getFeedback().getComments());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipCommentsToNull() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.getFeedback().setComments(null);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertNull(updated.getFeedback().getComments());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipCommentsToNegativeValue() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.getFeedback().setComments(-10L);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertEquals(-10, updated.getFeedback().getComments());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldUpdateTipCreatedBy() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        DogHubUser createdBy = dogHubTipProvider.get().getCreatedBy();
//        saved.setCreatedBy(createdBy);
//        DogHubTip updated = dogHubTipRepository.save(saved);
//        assertEquals(createdBy.getId(), updated.getCreatedBy().getId());
//        dogHubTipRepository.delete(updated);
//    }
//
//    @RepeatedTest(10)
//    void shouldNotUpdateTipCreatedByToNull() {
//        DogHubTip item = dogHubTipProvider.get();
//        DogHubTip saved = dogHubTipRepository.save(item);
//        saved.setCreatedBy(null);
//        assertThrows(TransactionSystemException.class, () -> dogHubTipRepository.save(saved));
//        dogHubTipRepository.delete(saved);
//    }
}