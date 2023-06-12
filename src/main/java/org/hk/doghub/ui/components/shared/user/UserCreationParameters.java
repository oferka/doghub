package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hk.doghub.ui.components.shared.EntityCreationParameters;

import static org.hk.doghub.model.user.DogHubUser.PASSWORD_MAX_LENGTH;

@Getter
@Setter
public class UserCreationParameters extends EntityCreationParameters {

    @NotNull @Size(max = PASSWORD_MAX_LENGTH)
    private String password;
}
