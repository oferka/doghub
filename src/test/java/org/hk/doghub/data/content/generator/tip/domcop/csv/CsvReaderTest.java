package org.hk.doghub.data.content.generator.tip.domcop.csv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CsvReaderTest {

    @Autowired
    private CsvReader reader;

    @Test
    void shouldRead() {
        List<TipLine> tipLines = reader.read();
        assertNotNull(tipLines);
    }
}