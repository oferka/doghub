package org.hk.doghub.ui.components.shared;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.NamedEntity;

public interface EntityCreationService<T extends NamedEntity, P extends EntityCreationParameters> {

    @NotNull T create(@NotNull P creationParameters);

    boolean exists(@NotNull P creationParameters);
}
