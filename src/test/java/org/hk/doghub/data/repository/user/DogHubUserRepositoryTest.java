package org.hk.doghub.data.repository.user;

import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.model.user.DogHubUser;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.transaction.TransactionSystemException;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void shouldNotSaveUserWithInvalidCreationTime() {
        DogHubUser item = dogHubUserProvider.get();
        item.setCreationTime(ZonedDateTime.now().plus(Duration.ofDays(10)));
        assertThrows(TransactionSystemException.class, () -> dogHubUserRepository.save(item));
    }
}