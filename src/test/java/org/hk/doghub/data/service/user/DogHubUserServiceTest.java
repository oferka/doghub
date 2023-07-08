package org.hk.doghub.data.service.user;

import org.hk.doghub.data.repository.user.DogHubUserDataTest;
import org.hk.doghub.model.user.DogHubUser;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}