package org.hk.doghub.data.service.tip;

import org.hk.doghub.data.repository.tip.DogHubTipDataTest;
import org.hk.doghub.model.tip.DogHubTip;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DogHubTipServiceTest extends DogHubTipDataTest {

    @Autowired
    private DogHubTipService dogHubTipService;

    @RepeatedTest(10)
    void shouldFindTipById() {
        DogHubTip item = dogHubTipProvider.get();
        DogHubTip saved = dogHubTipRepository.save(item);
        Optional<DogHubTip> tipOptional = dogHubTipService.findById(saved.getId());
        assertTrue(tipOptional.isPresent());
        assertEquals(item.getTitle(), tipOptional.get().getTitle());
        dogHubTipRepository.delete(saved);
    }

}