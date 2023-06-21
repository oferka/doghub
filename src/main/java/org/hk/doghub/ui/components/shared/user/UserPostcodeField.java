package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.user.DogHubAddress.POSTCODE_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.MAP_MARKER_SOLID;

public class UserPostcodeField extends EditableTextField {

    public static final String CLASS_NAME = "user-postcode-field";

    public static final String LABEL = "Postcode";

    public UserPostcodeField() {
        super(LABEL, false, POSTCODE_MAX_LENGTH, MAP_MARKER_SOLID.create(), null);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubUser user) {
        String value = (user.getAddress() != null) ? user.getAddress().getPostcode() : EMPTY;
        setValue(value);
    }
}
