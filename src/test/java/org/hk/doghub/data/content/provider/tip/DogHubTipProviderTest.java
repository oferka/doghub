package org.hk.doghub.data.content.provider.tip;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.tip.Tip;
import org.hk.doghub.data.content.provider.AbstractEntityProvider;
import org.hk.doghub.model.tip.DogHubTip;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class DogHubTipProviderTest {

    @Autowired
    private AbstractEntityProvider<Tip, DogHubTip> provider;

    @RepeatedTest(10)
    void shouldConvert() {
        DogHubTip entity = provider.get();
        assertNotNull(entity);
        log.info(entity.toString());
    }

    @RepeatedTest(10)
    void shouldConvertMultiple() {
        List<DogHubTip> entities = provider.get(5);
        assertEquals(5, entities.size());
    }
}
