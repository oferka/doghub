package org.hk.doghub.metrics;

import io.micrometer.core.instrument.Tag;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Objects;

public class TagUtils {

    public static Iterable<Tag> getCommonTags(Environment environment) {
        return List.of(
                Tag.of("application", Objects.requireNonNull(environment.getProperty("spring.application.name")))
        );
    }
}
