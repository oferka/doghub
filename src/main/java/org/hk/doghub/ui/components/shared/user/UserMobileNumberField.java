package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static com.vaadin.flow.component.icon.VaadinIcon.PHONE;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.user.DogHubUser.MOBILE_NUMBER_MAX_LENGTH;
import static org.hk.doghub.model.user.DogHubUser.MOBILE_NUMBER_MIN_LENGTH;

public class UserMobileNumberField extends EditableTextField {

    public static final String CLASS_NAME = "user-mobile-number-field";

    public static final String LABEL = "Mobile Phone";

    public UserMobileNumberField() {
        super(LABEL, false, MOBILE_NUMBER_MIN_LENGTH, MOBILE_NUMBER_MAX_LENGTH, PHONE.create(), "[0-9()+-]");
    }

    public void setValue(@NotNull DogHubUser user) {
        String value = user.getMobileNumber();
        setValue((value != null) ? value : EMPTY);
    }
}
