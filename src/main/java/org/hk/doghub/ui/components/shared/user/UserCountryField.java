package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.DogHubComboBoxField;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.user.DogHubAddress.COUNTRY_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.GLOBE_SOLID;

public class UserCountryField extends DogHubComboBoxField {

    public static final String CLASS_NAME = "user-country-field";

    public static final String LABEL = "Country";

    public UserCountryField() {
        super(LABEL, COUNTRY_MAX_LENGTH, GLOBE_SOLID.create(), asList("USA", "Canada", "Israel", "Italy", "France", "Australia", "China", "Japan", "Mexico", "Russia", "Germany", "India"));
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubUser user) {
        String value = (user.getAddress() != null) ? user.getAddress().getCountry() : EMPTY;
        setValueWithValidation(value);
    }
}
