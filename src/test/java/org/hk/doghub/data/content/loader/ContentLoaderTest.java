package org.hk.doghub.data.content.loader;

import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContentLoaderTest {

    @Autowired
    private ContentLoader loader;

    @RepeatedTest(3)
    void shouldLoad() {
        loader.load();
    }
}