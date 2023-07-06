package org.hk.doghub.data.repository.user;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.model.user.DogHubUser;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.TransactionSystemException;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

import static java.text.MessageFormat.format;
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
        assertNull(item.getCreationTime());
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
        item.setName(randomAlphabetic(NAME_MAX_LENGTH + 1));
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
        item.setUsername(randomAlphabetic(USER_NAME_MAX_LENGTH + 1));
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
        assertNull(item.getEmail());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithEmailThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.setEmail(randomAlphabetic(EMAIL_MAX_LENGTH + 1));
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithEmailThatHasInvalidFormat() {
        DogHubUser item = dogHubUserProvider.get();
        String invalidEmail = item.getEmail().replace('@', '.');
        log.info(format("Invalid email {0}", invalidEmail));
        item.setEmail(invalidEmail);
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullTitle() {
        DogHubUser item = dogHubUserProvider.get();
        item.setTitle(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(item.getTitle());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithTitleThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.setTitle(randomAlphabetic(TITLE_MAX_LENGTH + 1));
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullThumbnailPicture() {
        DogHubUser item = dogHubUserProvider.get();
        item.setThumbnailPicture(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(item.getThumbnailPicture());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithThumbnailPictureThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.setThumbnailPicture(randomAlphabetic(THUMBNAIL_PICTURE_MAX_LENGTH + 1));
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithThumbnailPictureThatHasInvalidFormat() {
        DogHubUser item = dogHubUserProvider.get();
        String invalidThumbnailPicture = item.getThumbnailPicture().replace(':', '@');
        log.info(format("Invalid thumbnail picture {0}", invalidThumbnailPicture));
        item.setThumbnailPicture(invalidThumbnailPicture);
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullDateOfBirth() {
        DogHubUser item = dogHubUserProvider.get();
        item.setDateOfBirth(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(item.getDateOfBirth());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithFutureDateOfBirth() {
        DogHubUser item = dogHubUserProvider.get();
        item.setDateOfBirth(getFutureDateTime());
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    private @NotNull ZonedDateTime getFutureDateTime() {
        return ZonedDateTime.now().plus(Duration.ofDays(10));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullCompany() {
        DogHubUser item = dogHubUserProvider.get();
        item.setCompany(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(item.getCompany());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithCompanyThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.setCompany(randomAlphabetic(COMPANY_MAX_LENGTH + 1));
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullAddress() {
        DogHubUser item = dogHubUserProvider.get();
        item.setAddress(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(item.getAddress());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullCountry() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setCountry(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(item.getAddress().getCountry());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithCountryThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setCountry(randomAlphabetic(COUNTRY_MAX_LENGTH + 256));
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullState() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setState(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(item.getAddress().getState());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithStateThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setState(randomAlphabetic(STATE_MAX_LENGTH + 256));
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullCity() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setCity(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(item.getAddress().getCity());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithCityThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setCity(randomAlphabetic(CITY_MAX_LENGTH + 256));
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullStreetName() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setStreetName(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(item.getAddress().getStreetName());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithStreetNameThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setStreetName(randomAlphabetic(STREET_NAME_MAX_LENGTH + 256));
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(item));
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullStreetNumber() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setNumber(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(item.getAddress().getNumber());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNegativeStreetNumber() {
        DogHubUser item = dogHubUserProvider.get();
        Integer negativeNumber = -10;
        item.getAddress().setNumber(negativeNumber);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertEquals(negativeNumber, item.getAddress().getNumber());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUserWithNullPostcode() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setPostcode(null);
        DogHubUser saved = dogHubUserRepository.save(item);
        assertNull(item.getAddress().getPostcode());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotSaveUserWithPostcodeThatExceedsMaxLength() {
        DogHubUser item = dogHubUserProvider.get();
        item.getAddress().setPostcode(randomAlphabetic(POSTCODE_MAX_LENGTH + 256));
        assertThrows(DataIntegrityViolationException.class, () -> dogHubUserRepository.save(item));
    }
}