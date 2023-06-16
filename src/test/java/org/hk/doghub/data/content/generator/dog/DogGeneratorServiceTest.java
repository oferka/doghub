package org.hk.doghub.data.content.generator.dog;

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
class DogGeneratorServiceTest {

    @Autowired
    private GeneratorService<Dog> generatorService;

    @RepeatedTest(10)
    void shouldGenerate() {
        Dog entity = generatorService.generate();
        assertNotNull(entity);
        log.info(entity.toString());
    }

    @RepeatedTest(10)
    public void shouldGenerateMultiple() {
        List<Dog> entities = generatorService.generate(5);
        assertEquals(5, entities.size());
    }
}