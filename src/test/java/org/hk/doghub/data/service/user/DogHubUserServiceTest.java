package org.hk.doghub.data.service.user;

import org.hk.doghub.data.repository.user.DogHubUserDataTest;
import org.hk.doghub.model.user.DogHubUser;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
        List<DogHubUser> items = dogHubUserProvider.get(10);
        List<DogHubUser> saved = dogHubUserRepository.saveAll(items);
        List<DogHubUser> allUsers = dogHubUserService.findAll();
        assertTrue(allUsers.size() >= saved.size());
        dogHubUserRepository.deleteAll(saved);
    }

    @RepeatedTest(10)
    void shouldFindAllUsersWithPaging() {
        List<DogHubUser> items = dogHubUserProvider.get(10);
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
    void shouldFindPrevious() {
        List<DogHubUser> items = dogHubUserProvider.get(10);
        List<DogHubUser> saved = dogHubUserRepository.saveAll(items);
        List<DogHubUser> allUsers = dogHubUserRepository.findAll();
        int index = 5;
        Optional<DogHubUser> userOptional = dogHubUserService.findPrevious(allUsers.get(index).getId());
        assertTrue(userOptional.isPresent());
        assertEquals(allUsers.get(index-1).getId(), userOptional.get().getId());
        dogHubUserRepository.deleteAll(saved);
    }
}