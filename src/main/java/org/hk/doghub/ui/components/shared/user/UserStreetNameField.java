package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.user.DogHubAddress.STREET_NAME_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.ROAD_SOLID;

public class UserStreetNameField extends EditableTextField {

    public static final String CLASS_NAME = "user-street-name-field";

    public static final String LABEL = "Street Name";

    public UserStreetNameField() {
        super(LABEL, false, STREET_NAME_MAX_LENGTH, ROAD_SOLID.create(), null);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubUser user) {
        String value = (user.getAddress() != null) ? user.getAddress().getStreetName() : EMPTY;
        setValue(value);
    }
}
