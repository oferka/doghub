package org.hk.doghub.data.content.generator.tip;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.GeneratorService;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class TipGeneratorServiceTest {

    @Autowired
    private GeneratorService<Tip> generatorService;

    @RepeatedTest(10)
    void shouldGenerate() {
        Tip entity = generatorService.generate();
        assertNotNull(entity);
        log.info(entity.toString());
    }

    @RepeatedTest(10)
    public void shouldGenerateMultiple() {
        List<Tip> entities = generatorService.generate(5);
        assertEquals(5, entities.size());
    }
}
