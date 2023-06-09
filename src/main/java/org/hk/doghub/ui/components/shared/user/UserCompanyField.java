package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.user.DogHubUser.COMPANY_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.BUILDING_SOLID;

public class UserCompanyField extends EditableTextField {

    public static final String CLASS_NAME = "user-company-field";

    public static final String LABEL = "Company";

    public UserCompanyField() {
        super(LABEL, false, COMPANY_MAX_LENGTH, BUILDING_SOLID.create(), null);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubUser user) {
        String value = user.getCompany();
        setValue((value != null) ? value : EMPTY);
    }
}
