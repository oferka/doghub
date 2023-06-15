package org.hk.doghub.data.content.provider;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hk.doghub.model.AbstractEntity;

@Data
public class EntityProviderConfiguration<T extends AbstractEntity> {

    @Positive
    private Integer numberOfItems = 500;
}
