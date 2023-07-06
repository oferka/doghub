package org.hk.doghub.data.repository.user;

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
import static org.hk.doghub.model.user.DogHubUser.EMAIL_MAX_LENGTH;
import static org.hk.doghub.model.user.DogHubUser.USER_NAME_MAX_LENGTH;
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
        item.setCreationTime(ZonedDateTime.now().plus(Duration.ofDays(10)));
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
        item.setName(randomAlphabetic(NAME_MAX_LENGTH+1));
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
        item.setUsername(randomAlphabetic(USER_NAME_MAX_LENGTH+1));
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
        item.setEmail(randomAlphabetic(EMAIL_MAX_LENGTH+1));
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
}