package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.DogHubComboBoxField;

import static com.vaadin.flow.component.icon.VaadinIcon.MAP_MARKER;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.user.DogHubAddress.STATE_MAX_LENGTH;
import static org.hk.doghub.model.user.DogHubAddress.STATE_MIN_LENGTH;

public class UserStateField extends DogHubComboBoxField {

    public static final String CLASS_NAME = "user-state-field";

    public static final String LABEL = "State";

    public UserStateField() {
        super(LABEL, STATE_MIN_LENGTH, STATE_MAX_LENGTH, MAP_MARKER.create(), asList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",
                "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
                "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"));
        addClassName(CLASS_NAME);
        setLabel(LABEL);
    }

    public void setValue(@NotNull DogHubUser user) {
        String value = (user.getAddress() != null) ? user.getAddress().getState() : EMPTY;
        setValueWithValidation(value);
    }
}
