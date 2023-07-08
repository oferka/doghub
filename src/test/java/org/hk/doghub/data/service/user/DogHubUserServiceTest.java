package org.hk.doghub.data.service.user;

import jakarta.validation.ConstraintViolationException;
import org.hk.doghub.data.repository.user.DogHubUserDataTest;
import org.hk.doghub.model.user.DogHubUser;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DogHubUserServiceTest extends DogHubUserDataTest {

    @Autowired
    private DogHubUserService dogHubUserService;

    @RepeatedTest(10)
    void shouldFindUserById() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        Optional<DogHubUser> userOptional = dogHubUserService.findById(saved.getId());
        assertTrue(userOptional.isPresent());
        assertEquals(item.getUsername(), userOptional.get().getUsername());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldFindAllUsers() {
        List<DogHubUser> items = dogHubUserProvider.get(getNumberOfItemsToLoad());
        List<DogHubUser> saved = dogHubUserRepository.saveAll(items);
        List<DogHubUser> allUsers = dogHubUserService.findAll();
        assertTrue(allUsers.size() >= saved.size());
        dogHubUserRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldFindAllUsersWithPaging() {
        List<DogHubUser> items = dogHubUserProvider.get(getNumberOfItemsToLoad());
        List<DogHubUser> saved = dogHubUserRepository.saveAll(items);
        int pageSize = 5;
        Page<DogHubUser> users = dogHubUserService.findAll(PageRequest.of(0, pageSize));
        assertEquals(pageSize, users.toList().size());
        dogHubUserRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldSaveUser() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserService.save(item);
        assertEquals(item.getUsername(), saved.getUsername());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldCountUsers() {
        long countBefore = dogHubUserService.count();
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        long countAfter = dogHubUserService.count();
        assertEquals(countAfter, countBefore + 1);
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldExistForExistingUser() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        assertTrue(dogHubUserService.exists(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotExistForNonExistingUsername() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        saved.setUsername(dogHubUserProvider.get().getUsername());
        assertFalse(dogHubUserService.exists(saved));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldFindPreviousUser() {
        List<DogHubUser> items = dogHubUserProvider.get(getNumberOfItemsToLoad());
        List<DogHubUser> saved = dogHubUserRepository.saveAll(items);
        List<DogHubUser> allUsers = dogHubUserRepository.findAll();
        int index = 5;
        Optional<DogHubUser> userOptional = dogHubUserService.findPrevious(allUsers.get(index).getId());
        assertTrue(userOptional.isPresent());
        assertEquals(allUsers.get(index-1).getId(), userOptional.get().getId());
        dogHubUserRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldNotFindPreviousUserOnMinimalId() {
        List<DogHubUser> items = dogHubUserProvider.get(getNumberOfItemsToLoad());
        List<DogHubUser> saved = dogHubUserRepository.saveAll(items);
        long minimalId = dogHubUserRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "id"))).iterator().next().getId();
        Optional<DogHubUser> userOptional = dogHubUserService.findPrevious(minimalId);
        assertTrue(userOptional.isEmpty());
        dogHubUserRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldFindNextUser() {
        List<DogHubUser> items = dogHubUserProvider.get(getNumberOfItemsToLoad());
        List<DogHubUser> saved = dogHubUserRepository.saveAll(items);
        List<DogHubUser> allUsers = dogHubUserRepository.findAll();
        int index = 5;
        Optional<DogHubUser> userOptional = dogHubUserService.findNext(allUsers.get(index).getId());
        assertTrue(userOptional.isPresent());
        assertEquals(allUsers.get(index+1).getId(), userOptional.get().getId());
        dogHubUserRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldNotFindNextUserOnMaximalId() {
        List<DogHubUser> items = dogHubUserProvider.get(getNumberOfItemsToLoad());
        List<DogHubUser> saved = dogHubUserRepository.saveAll(items);
        long maximalId = dogHubUserRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "id"))).iterator().next().getId();
        Optional<DogHubUser> userOptional = dogHubUserService.findNext(maximalId);
        assertTrue(userOptional.isEmpty());
        dogHubUserRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldFindRandomUser() {
        List<DogHubUser> items = dogHubUserProvider.get(getNumberOfItemsToLoad());
        List<DogHubUser> saved = dogHubUserRepository.saveAll(items);
        Optional<DogHubUser> userOptional = dogHubUserService.findRandom();
        assertTrue(userOptional.isPresent());
        dogHubUserRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldFindUserByUsername() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        assertEquals(item.getUsername(), saved.getUsername());
        Optional<DogHubUser> userOptional = dogHubUserService.findByUsername(saved.getUsername());
        assertTrue(userOptional.isPresent());
        assertEquals(item.getUsername(), userOptional.get().getUsername());
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotFindUserByNonExistingUsername() {
        Optional<DogHubUser> userOptional = dogHubUserService.findByUsername(getNonExistingUsername());
        assertTrue(userOptional.isEmpty());
    }

    @RepeatedTest(10)
    void shouldNotFindUserByNullUsername() {
        assertThrows(ConstraintViolationException.class, () -> dogHubUserService.findByUsername(null));
    }

    @RepeatedTest(10)
    void shouldNotFindUserByUsernameThatExceedsMaxLength() {
        assertThrows(ConstraintViolationException.class, () -> dogHubUserService.findByUsername(getUsernameThatExceedsMaxLength()));
    }

    @RepeatedTest(10)
    void shouldExistByUsername() {
        DogHubUser item = dogHubUserProvider.get();
        DogHubUser saved = dogHubUserRepository.save(item);
        assertEquals(item.getUsername(), saved.getUsername());
        assertTrue(dogHubUserService.existsByUsername(item.getUsername()));
        dogHubUserRepository.delete(saved);
    }

    @RepeatedTest(10)
    void shouldNotExistByNullUsername() {
        assertThrows(ConstraintViolationException.class, () -> dogHubUserService.findByUsername(null));
    }

    @RepeatedTest(10)
    void shouldNotExistByNonExistingUsername() {
        Optional<DogHubUser> userOptional = dogHubUserService.findByUsername(getNonExistingUsername());
        assertTrue(userOptional.isEmpty());
    }

    @RepeatedTest(10)
    void shouldNotExistByUsernameThatExceedsMaxLength() {
        assertThrows(ConstraintViolationException.class, () -> dogHubUserService.findByUsername(getUsernameThatExceedsMaxLength()));
    }
}