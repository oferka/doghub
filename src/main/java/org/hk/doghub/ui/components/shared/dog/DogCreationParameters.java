package org.hk.doghub.ui.components.shared.dog;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntityCreationParameters;

import static org.hk.doghub.model.NamedEntity.NAME_MAX_LENGTH;

@Getter
@Setter
public class DogCreationParameters extends EntityCreationParameters {

    @NotNull
    @Size(max = NAME_MAX_LENGTH)
    private String name;

    @NotNull
    private DogHubUser createdBy;
}
