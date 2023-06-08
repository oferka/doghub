package org.hk.doghub.ui.components.shared;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.NamedEntity;

@FunctionalInterface
public interface EntityUpdateService<T extends NamedEntity, P extends EntityUpdateParameters> {

    @NotNull T update(@NotNull P updateParameters);
}
