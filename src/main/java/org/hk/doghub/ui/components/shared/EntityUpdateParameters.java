package org.hk.doghub.ui.components.shared;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import static org.hk.doghub.model.NamedEntity.NAME_MAX_LENGTH;

@Getter
@Setter
public abstract class EntityUpdateParameters {

    @NotNull
    private Long id;

    @NotNull @Size(max = NAME_MAX_LENGTH)
    private String name;
}
