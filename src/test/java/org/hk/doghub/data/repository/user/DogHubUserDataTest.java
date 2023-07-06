package org.hk.doghub.data.repository.user;

import org.hk.doghub.data.content.provider.user.DogHubUserProvider;
import org.hk.doghub.data.content.provider.user.DogHubUserProviderConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DogHubUserDataTest {

    @Autowired
    protected DogHubUserRepository dogHubUserRepository;

    @Autowired
    protected DogHubUserProvider dogHubUserProvider;

    @Autowired
    protected DogHubUserProviderConfiguration dogHubUserProviderConfiguration;

    protected long userContentCountBefore;

    @BeforeEach
    void captureContentStatus() {
        userContentCountBefore = dogHubUserRepository.count();
    }

    @AfterEach
    void verifyContentStatusNotChanged() {
        long contentCountAfter = dogHubUserRepository.count();
        assertEquals(userContentCountBefore, contentCountAfter);
    }

    protected int getNumberOfItemsToLoad() {
        return dogHubUserProviderConfiguration.getNumberOfItems();
    }
}
