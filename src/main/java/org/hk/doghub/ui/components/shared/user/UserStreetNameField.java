package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static com.vaadin.flow.component.icon.VaadinIcon.MAP_MARKER;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.user.DogHubAddress.STREET_NAME_MAX_LENGTH;
import static org.hk.doghub.model.user.DogHubAddress.STREET_NAME_MIN_LENGTH;

public class UserStreetNameField extends EditableTextField {

    public static final String CLASS_NAME = "user-street-name-field";

    public static final String LABEL = "Street Name";

    public UserStreetNameField() {
        super(LABEL, false, STREET_NAME_MIN_LENGTH, STREET_NAME_MAX_LENGTH, MAP_MARKER.create(), null);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubUser user) {
        String value = (user.getAddress() != null) ? user.getAddress().getStreetName() : EMPTY;
        setValue(value);
    }
}
