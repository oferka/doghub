package org.hk.doghub.data.content.generator.tip.faker;

import org.hk.doghub.data.content.generator.tip.Tip;
import org.hk.doghub.data.content.generator.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TipProviderFakerTest {

    @Autowired
    private TipProviderFaker provider;

    @Test
    public void shouldGet() {
        Tip entity = provider.get();
        assertNotNull(entity);
    }

    @Test
    public void shouldGetMultiple() {
        List<Tip> entities = provider.get(10);
        assertEquals(10, entities.size());
    }
}
