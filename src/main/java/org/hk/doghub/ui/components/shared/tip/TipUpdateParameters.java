package org.hk.doghub.ui.components.shared.tip;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.ui.components.shared.EntityUpdateParameters;

import static org.hk.doghub.model.tip.DogHubTip.*;

@Getter
@Setter
public class TipUpdateParameters extends EntityUpdateParameters {

    @NotNull @Size(max = TITLE_MAX_LENGTH)
    private String title;

    @Size(max = CONTENT_MAX_LENGTH)
    private String content;

    @Size(max = MORE_INFO_MAX_LENGTH)
    private String moreInfo;

    @Size(max = THUMBNAIL_PICTURE_MAX_LENGTH) @URL
    private String thumbnailPicture;
}
