package org.hk.doghub.data.content.generator.tip.faker;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.tip.Tip;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class TipContentProviderTest {

    @Autowired
    private TipContentProvider provider;

    @RepeatedTest(10)
    public void shouldGet() {
        String value = provider.get(new Tip());
        log.info(value);
        assertNotNull(value);
    }
}