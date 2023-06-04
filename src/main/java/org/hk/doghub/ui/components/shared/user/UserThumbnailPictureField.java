package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static com.vaadin.flow.component.icon.VaadinIcon.PICTURE;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.user.DogHubUser.THUMBNAIL_PICTURE_MAX_LENGTH;
import static org.hk.doghub.model.user.DogHubUser.THUMBNAIL_PICTURE_MIN_LENGTH;

public class UserThumbnailPictureField extends EditableTextField {

    public static final String CLASS_NAME = "user-thumbnail-picture-field";

    public static final String LABEL = "Avatar URL";

    public UserThumbnailPictureField() {
        super(LABEL, false, THUMBNAIL_PICTURE_MIN_LENGTH, THUMBNAIL_PICTURE_MAX_LENGTH, PICTURE.create(), null);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubUser user) {
        String value = user.getThumbnailPicture();
        setValue((value != null) ? value : EMPTY);
    }
}
