package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static com.vaadin.flow.component.icon.VaadinIcon.MAP_MARKER;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.user.DogHubAddress.POSTCODE_MAX_LENGTH;
import static org.hk.doghub.model.user.DogHubAddress.POSTCODE_MIN_LENGTH;

public class UserPostcodeField extends EditableTextField {

    public static final String CLASS_NAME = "user-postcode-field";

    public static final String LABEL = "Postcode";

    public UserPostcodeField() {
        super(LABEL, false, POSTCODE_MIN_LENGTH, POSTCODE_MAX_LENGTH, MAP_MARKER.create(), null);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubUser user) {
        String value = (user.getAddress() != null) ? user.getAddress().getPostcode() : EMPTY;
        setValue(value);
    }
}
