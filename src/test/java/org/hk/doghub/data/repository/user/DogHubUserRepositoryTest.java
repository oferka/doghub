package org.hk.doghub.data.repository.user;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.model.DogHubFeedback;
import org.hk.doghub.model.user.DogHubAddress;
import org.hk.doghub.model.user.DogHubUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.TransactionSystemException;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.time.Duration.ofDays;
import static java.time.ZonedDateTime.now;
import static java.util.Collections.emptyList;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hk.doghub.model.NamedEntity.NAME_MAX_LENGTH;
import static org.hk.doghub.model.user.DogHubAddress.*;
import static org.hk.doghub.model.user.DogHubUser.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class DogHubUserRepositoryTest extends DogHubUserDataTest {

    @RepeatedTest(10)
    void shouldSaveUser() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        assertEquals(item.getUsername(), saved.getUsername());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveAllUsers() {
        List<DogHubUser> items = dogHubUserProvider.get(10);
        List<DogHubUser> saved = dogHubUserRepository.saveAll(items);
        assertEquals(saved.size(), items.size());
        dogHubUserRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithSpecifiedNonExistingId() {
        DogHubUser item = dogHubUserProvider.get();
        Long id = RandomUtils.nextLong(1000000, Long.MAX_VALUE);
        item.setId(id);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNotEquals(item.getId(), saved.getId());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullCreationTime() {
        DogHubUser item = dogHubUserProvider.get();
        item.setCreationTime(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getCreationTime());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithFutureCreationTime() {
        DogHubUser item = dogHubUserProvider.get();
        item.setCreationTime(getFutureDateTime());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithNullName() {
        DogHubUser item = dogHubUserProvider.get();
        item.setName(null);
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithNameThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.setName(getNameThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithNullUserName() {
        DogHubUser item = dogHubUserProvider.get();
        item.setUsername(null);
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithUsernameThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.setUsername(getUsernameThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithNonUniqueUserName() {
        DogHubUser item1 = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item1);
        assertEquals(item1.getUsername(), saved.getUsername());
        DogHubUser item2 = dogHubUserProvider.get();
        item2.setUsername(item1.getUsername());
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(item2));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullEmail() {
        DogHubUser item = dogHubUserProvider.get();
        item.setEmail(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getEmail());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithEmailThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.setEmail(getEmailThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithEmailThatHasInvalidFormat() {
        DogHubUser item = dogHubUserProvider.get();
        item.setEmail(getEmailWithInvalidFormat());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullTitle() {
        DogHubUser item = dogHubUserProvider.get();
        item.setTitle(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getTitle());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithTitleThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.setTitle(getTitleThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullThumbnailPicture() {
        DogHubUser item = dogHubUserProvider.get();
        item.setThumbnailPicture(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getThumbnailPicture());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithThumbnailPictureThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.setThumbnailPicture(getThumbnailPictureThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithThumbnailPictureThatHasInvalidFormat() {
        DogHubUser item = dogHubUserProvider.get();
        item.setThumbnailPicture(getThumbnailPictureWithInvalidFormat());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullDateOfBirth() {
        DogHubUser item = dogHubUserProvider.get();
        item.setDateOfBirth(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getDateOfBirth());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithFutureDateOfBirth() {
        DogHubUser item = dogHubUserProvider.get();
        item.setDateOfBirth(getFutureDateTime());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullCompany() {
        DogHubUser item = dogHubUserProvider.get();
        item.setCompany(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getCompany());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithCompanyThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.setCompany(getCompanyThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullAddress() {
        DogHubUser item = dogHubUserProvider.get();
        item.setAddress(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getAddress());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullCountry() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setCountry(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getAddress().getCountry());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithCountryThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setCountry(getCountryThatExceedsMaxLength());
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullState() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setState(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getAddress().getState());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithStateThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setState(getStateThatExceedsMaxLength());
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullCity() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setCity(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getAddress().getCity());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithCityThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setCity(getCityThatExceedsMaxLength());
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullStreetName() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setStreetName(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getAddress().getStreetName());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithStreetNameThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setStreetName(getStreetNameThatExceedsMaxLength());
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullStreetNumber() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setNumber(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getAddress().getNumber());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNegativeStreetNumber() {
        DogHubUser item = dogHubUserProvider.get();
        Integer negativeNumber = -10;
        item.getAddress().setNumber(negativeNumber);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertEquals(negativeNumber, saved.getAddress().getNumber());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullPostcode() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setPostcode(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getAddress().getPostcode());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithPostcodeThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setPostcode(getPostcodeThatExceedsMaxLength());
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullMobileNumber() {
        DogHubUser item = dogHubUserProvider.get();
        item.setMobileNumber(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getMobileNumber());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithMobileNumberThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.setMobileNumber(getMobileNumberThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithNullHashedPassword() {
        DogHubUser item = dogHubUserProvider.get();
        item.setHashedPassword(null);
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithHashedPasswordThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.setHashedPassword(getHashedPasswordThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithNullFeedback() {
        DogHubUser item = dogHubUserProvider.get();
        item.setFeedback(null);
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullLikes() {
        DogHubUser item = dogHubUserProvider.get();
        item.getFeedback().setLikes(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getFeedback().getLikes());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNegativeLikes() {
        DogHubUser item = dogHubUserProvider.get();
        Long negativeNumber = -10L;
        item.getFeedback().setLikes(negativeNumber);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertEquals(negativeNumber, saved.getFeedback().getLikes());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullShares() {
        DogHubUser item = dogHubUserProvider.get();
        item.getFeedback().setShares(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getFeedback().getShares());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNegativeShares() {
        DogHubUser item = dogHubUserProvider.get();
        Long negativeNumber = -10L;
        item.getFeedback().setShares(negativeNumber);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertEquals(negativeNumber, saved.getFeedback().getShares());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullComments() {
        DogHubUser item = dogHubUserProvider.get();
        item.getFeedback().setComments(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getFeedback().getComments());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNegativeComments() {
        DogHubUser item = dogHubUserProvider.get();
        Long negativeNumber = -10L;
        item.getFeedback().setComments(negativeNumber);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertEquals(negativeNumber, saved.getFeedback().getComments());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithNullRoles() {
        DogHubUser item = dogHubUserProvider.get();
        item.setRoles(null);
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithEmptyRoles() {
        DogHubUser item = dogHubUserProvider.get();
        item.setRoles(Collections.emptySet());
        DogHubUser saved = dogHubUserRepository.save(item);
        assertTrue(saved.getRoles().isEmpty());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullTips() {
        DogHubUser item = dogHubUserProvider.get();
        item.setDogHubTips(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getDogHubTips());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithEmptyTips() {
        DogHubUser item = dogHubUserProvider.get();
        item.setDogHubTips(emptyList());
        DogHubUser saved = dogHubUserRepository.save(item);
        assertTrue(saved.getDogHubTips().isEmpty());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullDogs() {
        DogHubUser item = dogHubUserProvider.get();
        item.setDogHubDogs(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(saved.getDogHubDogs());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithEmptyDogs() {
        DogHubUser item = dogHubUserProvider.get();
        item.setDogHubDogs(emptyList());
        DogHubUser saved = dogHubUserRepository.save(item);
        assertTrue(saved.getDogHubDogs().isEmpty());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldFindUserById() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        assertEquals(item.getUsername(), saved.getUsername());
        Optional<DogHubUser> userOptional = dogHubUserRepository.findById(saved.getId());
        assertTrue(userOptional.isPresent());
        assertEquals(item.getUsername(), userOptional.get().getUsername());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotFindUserByIdNonExistingId() {
        Optional<DogHubUser> userOptional = dogHubUserRepository.findById(getNonExistingId());
        Assertions.assertTrue(userOptional.isEmpty());
    }

    @RepeatedTest(10)
    void shouldFindUserByUsername() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        assertEquals(item.getUsername(), saved.getUsername());
        Optional<DogHubUser> userOptional = dogHubUserRepository.findByUsername(saved.getUsername());
        assertTrue(userOptional.isPresent());
        assertEquals(item.getUsername(), userOptional.get().getUsername());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotFindUserByNonExistingUsername() {
        Optional<DogHubUser> userOptional = dogHubUserRepository.findByUsername(getNonExistingUsername());
        assertTrue(userOptional.isEmpty());
    }

    @RepeatedTest(10)
    void shouldNotFindUserByNullUsername() {
        Optional<DogHubUser> userOptional = dogHubUserRepository.findByUsername(null);
        assertTrue(userOptional.isEmpty());
    }

    @RepeatedTest(10)
    void shouldNotFindUserByUsernameThatExceedsMaxLength() {
        Optional<DogHubUser> userOptional = dogHubUserRepository.findByUsername(getUsernameThatExceedsMaxLength());
        assertTrue(userOptional.isEmpty());
    }

    @RepeatedTest(10)
    void shouldExistByUsername() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        assertEquals(item.getUsername(), saved.getUsername());
        assertTrue(dogHubUserRepository.existsByUsername(item.getUsername()));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotExistByNullUsername() {
        Optional<DogHubUser> userOptional = dogHubUserRepository.findByUsername(null);
        assertTrue(userOptional.isEmpty());
    }

    @RepeatedTest(10)
    void shouldNotExistByNonExistingUsername() {
        Optional<DogHubUser> userOptional = dogHubUserRepository.findByUsername(getNonExistingUsername());
        assertTrue(userOptional.isEmpty());
    }

    @RepeatedTest(10)
    void shouldNotExistByUsernameThatExceedsMaxLength() {
        Optional<DogHubUser> userOptional = dogHubUserRepository.findByUsername(getUsernameThatExceedsMaxLength());
        assertTrue(userOptional.isEmpty());
    }

    @RepeatedTest(10)
    void shouldFindTop1ByIdGreaterThanOrderById() {
        List<DogHubUser> items = dogHubUserProvider.get(10);
        List<DogHubUser> saved = dogHubUserRepository.saveAll(items);
        assertEquals(saved.size(), items.size());
        Optional<DogHubUser> userOptional = dogHubUserRepository.findTop1ByIdGreaterThanOrderById(saved.get(0).getId());
        assertTrue(userOptional.isPresent());
        assertEquals(userOptional.get().getId(), saved.get(1).getId());
        dogHubUserRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldNotFindTop1ByIdGreaterThanOrderById() {
        List<DogHubUser> items = dogHubUserProvider.get(10);
        List<DogHubUser> saved = dogHubUserRepository.saveAll(items);
        assertEquals(saved.size(), items.size());
        Optional<DogHubUser> userOptional = dogHubUserRepository.findTop1ByIdGreaterThanOrderById(saved.get(9).getId());
        assertTrue(userOptional.isEmpty());
        dogHubUserRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldFindTop1ByIdLessThanOrderByIdDesc() {
        List<DogHubUser> items = dogHubUserProvider.get(10);
        List<DogHubUser> saved = dogHubUserRepository.saveAll(items);
        assertEquals(saved.size(), items.size());
        Optional<DogHubUser> userOptional = dogHubUserRepository.findTop1ByIdLessThanOrderByIdDesc(saved.get(5).getId());
        assertTrue(userOptional.isPresent());
        assertEquals(userOptional.get().getId(), saved.get(4).getId());
        dogHubUserRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserCreationTime() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        ZonedDateTime creationTime = getPastDateTime();
        saved.setCreationTime(creationTime);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(creationTime, updated.getCreationTime());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserCreationTimeToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setCreationTime(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getCreationTime());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserCreationTimeToFuture() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        ZonedDateTime creationTime = getFutureDateTime();
        saved.setCreationTime(creationTime);
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserName() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        String name = dogHubUserProvider.get().getName();
        saved.setName(name);
        DogHubUser updated = dogHubUserRepository.save(item);
        assertEquals(name, updated.getName());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserNameToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setName(null);
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserNameToValueThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setName(getNameThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserUsername() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        String username = dogHubUserProvider.get().getUsername();
        saved.setUsername(username);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(username, updated.getUsername());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserUsernameToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setUsername(null);
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserUsernameToValueThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setUsername(getUsernameThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserUsernameToNonUniqueValue() {
        List<DogHubUser> items = dogHubUserProvider.get(2);
        List<DogHubUser> saved = dogHubUserRepository.saveAll(items);
        DogHubUser first = saved.get(0);
        DogHubUser second = saved.get(1);
        second.setUsername(first.getUsername());
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(second));
        dogHubUserRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserEmail() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        String email = dogHubUserProvider.get().getEmail();
        saved.setEmail(email);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(email, updated.getEmail());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserEmailToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setEmail(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getEmail());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserEmailToValueThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setEmail(getEmailThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserEmailToValueThatHasInvalidFormat() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setEmail(getEmailWithInvalidFormat());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserTitle() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        String title = dogHubUserProvider.get().getTitle();
        saved.setTitle(title);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(title, updated.getTitle());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserTitleToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setTitle(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getTitle());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserTitleToValueThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setEmail(getTitleThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserThumbnailPicture() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        String thumbnailPicture = dogHubUserProvider.get().getThumbnailPicture();
        saved.setThumbnailPicture(thumbnailPicture);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(thumbnailPicture, updated.getThumbnailPicture());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserThumbnailPictureToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setThumbnailPicture(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getThumbnailPicture());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserThumbnailPictureToValueThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setEmail(getThumbnailPictureThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserThumbnailPictureToValueThatHasInvalidFormat() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setThumbnailPicture(getThumbnailPictureWithInvalidFormat());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserDateOfBirth() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        ZonedDateTime dateOfBirth = getPastDateTime();
        saved.setDateOfBirth(dateOfBirth);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(dateOfBirth, updated.getDateOfBirth());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserDateOfBirthToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setDateOfBirth(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getDateOfBirth());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserDateOfBirthToFuture() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        ZonedDateTime dateOfBirth = getFutureDateTime();
        saved.setDateOfBirth(dateOfBirth);
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserCompany() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        String company = dogHubUserProvider.get().getCompany();
        saved.setCompany(company);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(company, updated.getCompany());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserCompanyToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setCompany(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getCompany());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserCompanyToValueThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setEmail(getCompanyThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserAddress() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        DogHubAddress address = dogHubUserProvider.get().getAddress();
        saved.setAddress(address);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(address, updated.getAddress());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserAddressToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setAddress(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getAddress());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserCountry() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        String country = dogHubUserProvider.get().getAddress().getCountry();
        saved.getAddress().setCountry(country);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(country, updated.getAddress().getCountry());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserCountryToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.getAddress().setCountry(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getAddress().getCountry());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserCountryToValueThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.getAddress().setCountry(getCountryThatExceedsMaxLength());
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserState() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        String state = dogHubUserProvider.get().getAddress().getState();
        saved.getAddress().setState(state);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(state, updated.getAddress().getState());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserStateToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.getAddress().setState(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getAddress().getState());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserStateToValueThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.getAddress().setState(getStateThatExceedsMaxLength());
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserCity() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        String city = dogHubUserProvider.get().getAddress().getCity();
        saved.getAddress().setCity(city);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(city, updated.getAddress().getCity());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserCityToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.getAddress().setCity(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getAddress().getCity());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserCityToValueThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.getAddress().setCity(getCityThatExceedsMaxLength());
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserStreetName() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        String streetName = dogHubUserProvider.get().getAddress().getStreetName();
        saved.getAddress().setStreetName(streetName);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(streetName, updated.getAddress().getStreetName());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserStreetNameToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.getAddress().setStreetName(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getAddress().getStreetName());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserStreetNameToValueThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.getAddress().setStreetName(getStreetNameThatExceedsMaxLength());
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserStreetNumber() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        int streetNumber = dogHubUserProvider.get().getAddress().getNumber();
        saved.getAddress().setNumber(streetNumber);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(streetNumber, updated.getAddress().getNumber());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserStreetNumberToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.getAddress().setNumber(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getAddress().getNumber());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserStreetNumberToNegativeValue() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.getAddress().setNumber(-1);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(-1, updated.getAddress().getNumber());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserPostcode() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        String postcode = dogHubUserProvider.get().getAddress().getPostcode();
        saved.getAddress().setPostcode(postcode);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(postcode, updated.getAddress().getPostcode());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserPostcodeToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.getAddress().setPostcode(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getAddress().getPostcode());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserPostcodeToValueThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.getAddress().setPostcode(getPostcodeThatExceedsMaxLength());
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserMobileNumber() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        String mobileNumber = dogHubUserProvider.get().getMobileNumber();
        saved.setMobileNumber(mobileNumber);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(mobileNumber, updated.getMobileNumber());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserMobileNumberToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setMobileNumber(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getMobileNumber());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserMobileNumberToValueThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setMobileNumber(getMobileNumberThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserHashedPassword() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        String hashedPassword = dogHubUserProvider.get().getHashedPassword();
        saved.setHashedPassword(hashedPassword);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(hashedPassword, updated.getHashedPassword());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserHashedPasswordToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setHashedPassword(null);
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserHashedPasswordToValueThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setHashedPassword(getHashedPasswordThatExceedsMaxLength());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserFeedback() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        DogHubFeedback feedback = dogHubUserProvider.get().getFeedback();
        saved.setFeedback(feedback);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(feedback, updated.getFeedback());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldNotUpdateUserFeedbackToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setFeedback(null);
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldUpdateUserTipsToNull() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setDogHubTips(null);
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertNull(updated.getDogHubTips());
        dogHubUserRepository.delete(updated);
    }

    @RepeatedTest(10)
    void shouldUpdateUserTipsToEmptyList() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setDogHubTips(emptyList());
        DogHubUser updated = dogHubUserRepository.save(saved);
        assertEquals(emptyList(), updated.getDogHubTips());
        dogHubUserRepository.delete(updated);
    }

    private @NotNull Long getNonExistingId() {
        return RandomUtils.nextLong();
    }

    private @NotNull String getNonExistingUsername() {
        return dogHubUserProvider.get().getUsername();
    }

    private @NotNull String getNameThatExceedsMaxLength() {
        return randomAlphabetic(NAME_MAX_LENGTH + 1);
    }

    private @NotNull String getUsernameThatExceedsMaxLength() {
        return randomAlphabetic(USER_NAME_MAX_LENGTH + 1);
    }

    private @NotNull String getEmailThatExceedsMaxLength() {
        return randomAlphabetic(EMAIL_MAX_LENGTH + 1);
    }

    private @NotNull String getTitleThatExceedsMaxLength() {
        return randomAlphabetic(TITLE_MAX_LENGTH + 1);
    }

    private @NotNull String getThumbnailPictureThatExceedsMaxLength() {
        return randomAlphabetic(THUMBNAIL_PICTURE_MAX_LENGTH + 1);
    }

    private @NotNull String getCompanyThatExceedsMaxLength() {
        return randomAlphabetic(COMPANY_MAX_LENGTH + 1);
    }

    private @NotNull String getCountryThatExceedsMaxLength() {
        return randomAlphabetic(COUNTRY_MAX_LENGTH + 1);
    }

    private @NotNull String getStateThatExceedsMaxLength() {
        return randomAlphabetic(STATE_MAX_LENGTH + 1);
    }

    private @NotNull String getCityThatExceedsMaxLength() {
        return randomAlphabetic(CITY_MAX_LENGTH + 1);
    }

    private @NotNull String getStreetNameThatExceedsMaxLength() {
        return randomAlphabetic(STREET_NAME_MAX_LENGTH + 1);
    }

    private @NotNull String getPostcodeThatExceedsMaxLength() {
        return randomAlphabetic(POSTCODE_MAX_LENGTH + 1);
    }

    private @NotNull String getHashedPasswordThatExceedsMaxLength() {
        return randomAlphabetic(PASSWORD_MAX_LENGTH + 1);
    }

    private @NotNull String getMobileNumberThatExceedsMaxLength() {
        return randomAlphabetic(MOBILE_NUMBER_MAX_LENGTH + 1);
    }

    private @NotNull ZonedDateTime getFutureDateTime() {
        return now().plus(ofDays(10));
    }

    private @NotNull ZonedDateTime getPastDateTime() {
        return now().minus(ofDays(10));
    }

    private @NotNull String getEmailWithInvalidFormat() {
        return dogHubUserProvider.get().getEmail().replace('@', '.');
    }

    private @NotNull String getThumbnailPictureWithInvalidFormat() {
        return dogHubUserProvider.get().getThumbnailPicture().replace(':', '.');
    }
}