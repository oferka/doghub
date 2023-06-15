package org.hk.doghub.data.content.provider;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EntityProviderConfiguration {

    @Positive
    private Integer numberOfItems = 500;
}
