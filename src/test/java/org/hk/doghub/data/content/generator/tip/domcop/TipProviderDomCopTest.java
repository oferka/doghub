package org.hk.doghub.data.content.generator.tip.domcop;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.tip.Tip;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class TipProviderDomCopTest {

    @Autowired
    private TipProviderDomCop provider;

    @RepeatedTest(10)
    public void shouldGet() {
        Tip tip = provider.get();
        assertNotNull(tip);
    }

    @RepeatedTest(10)
    public void shouldGetMultiple() {
        List<Tip> tips = provider.get(50);
        assertEquals(50, tips.size());
    }
}