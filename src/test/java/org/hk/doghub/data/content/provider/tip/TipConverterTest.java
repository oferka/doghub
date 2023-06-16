package org.hk.doghub.data.content.provider.tip;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.Provider;
import org.hk.doghub.data.content.generator.tip.Tip;
import org.hk.doghub.data.content.provider.Converter;
import org.hk.doghub.model.tip.DogHubTip;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class TipConverterTest {

    @Autowired
    private Converter<Tip, DogHubTip> converter;

    @Autowired
    private Provider<Tip> provider;

    @RepeatedTest(10)
    void shouldConvert() {
        Tip providedObject = provider.get();
        DogHubTip entity = converter.convert(providedObject);
        assertNotNull(entity);
        log.info(entity.toString());
    }

    @RepeatedTest(10)
    void shouldConvertMultiple() {
        List<Tip> providedObjects = provider.get(5);
        List<DogHubTip> entities = converter.convert(providedObjects);
        assertEquals(5, entities.size());
    }
}
