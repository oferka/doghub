package org.hk.doghub.ui.components.shared.dog;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static com.vaadin.flow.component.icon.VaadinIcon.PICTURE;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.HasThumbnailPicture.THUMBNAIL_PICTURE_MAX_LENGTH;

public class DogThumbnailPictureField extends EditableTextField {

    public static final String CLASS_NAME = "dog-thumbnail-picture-field";

    public static final String LABEL = "Thumbnail Picture URL";

    public DogThumbnailPictureField() {
        super(LABEL, false, THUMBNAIL_PICTURE_MAX_LENGTH, PICTURE.create(), null);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubDog dog) {
        String value = dog.getThumbnailPicture();
        setValue((value != null) ? value : EMPTY);
    }
}
