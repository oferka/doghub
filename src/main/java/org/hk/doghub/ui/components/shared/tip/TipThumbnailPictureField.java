package org.hk.doghub.ui.components.shared.tip;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.tip.DogHubTip.THUMBNAIL_PICTURE_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.IMAGE_SOLID;

public class TipThumbnailPictureField extends EditableTextField {

    public static final String CLASS_NAME = "tip-thumbnail-picture-field";

    public static final String LABEL = "Thumbnail Picture URL";

    public TipThumbnailPictureField() {
        super(LABEL, false, THUMBNAIL_PICTURE_MAX_LENGTH, IMAGE_SOLID.create(), null);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubTip tip) {
        String value = tip.getThumbnailPicture();
        setValue((value != null) ? value : EMPTY);
    }
}
