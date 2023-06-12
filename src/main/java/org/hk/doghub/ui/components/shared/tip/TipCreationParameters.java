package org.hk.doghub.ui.components.shared.tip;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntityCreationParameters;

import static org.hk.doghub.model.tip.DogHubTip.TITLE_MAX_LENGTH;

@Getter
@Setter
public class TipCreationParameters extends EntityCreationParameters {

    @NotNull @Size(max = TITLE_MAX_LENGTH)
    private String title;

    @NotNull
    private DogHubUser createdBy;
}
