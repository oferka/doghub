package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.DogHubComboBoxField;

import static java.util.Arrays.asList;
import static org.hk.doghub.model.user.DogHubUser.TITLE_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.UNIVERSAL_ACCESS_SOLID;

public class UserTitleField extends DogHubComboBoxField {

    public static final String CLASS_NAME = "user-title-field";

    public static final String LABEL = "Title";

    public UserTitleField() {
        super(LABEL, TITLE_MAX_LENGTH, UNIVERSAL_ACCESS_SOLID.create(), asList("Mr.", "Mrs.", "Ms.", "Miss", "Dr.", "Rev.", "Prof.", "Hon.", "Capt.", "Col.", "Lt.", "Sen.", "Rep.", "Gov.", "Pres.", "Sir", "Dame", "Lady", "Lord", "Knight", "Prince", "Princess"));
        addClassName(CLASS_NAME);
        setLabel(LABEL);
    }

    public void setValue(@NotNull DogHubUser user) {
        String value = user.getTitle();
        setValueWithValidation(value);
    }
}
