package org.hk.doghub.data.content.generator.tip.domcop.csv;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.tip.Tip;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CSVContentProviderTest {

    @Autowired
    private CSVContentProvider provider;

    @RepeatedTest(10)
    public void shouldGet() {
        Tip tip = provider.get();
        log.info(tip.toString());
        assertNotNull(tip);
    }

    @RepeatedTest(10)
    public void shouldGetMultiple() {
        List<Tip> tips = provider.get(5);
        assertEquals(5, tips.size());
    }
}