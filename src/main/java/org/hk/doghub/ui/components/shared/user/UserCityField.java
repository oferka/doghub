package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.user.DogHubAddress.CITY_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.CITY_SOLID;

public class UserCityField extends EditableTextField {

    public static final String CLASS_NAME = "user-city-field";

    public static final String LABEL = "City";

    public UserCityField() {
        super(LABEL, false, CITY_MAX_LENGTH, CITY_SOLID.create(), null);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubUser user) {
        String value = (user.getAddress() != null) ? user.getAddress().getCity() : EMPTY;
        setValue(value);
    }
}
