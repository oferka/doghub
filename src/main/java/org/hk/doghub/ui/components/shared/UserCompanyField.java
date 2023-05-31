package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.textfield.TextField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import static com.vaadin.flow.component.icon.VaadinIcon.FACTORY;
import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;

public class UserCompanyField extends TextField {

    public static final String CLASS_NAME = "user-company-field";

    public static final String LABEL = "Company";

    public UserCompanyField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setClearButtonVisible(true);
        setMinLength(2);
        setMaxLength(64);
        setPrefixComponent(FACTORY.create());
        setValueChangeMode(EAGER);
        addValueChangeListener(this::valueChanged);
    }

    public void setValue(@NotNull DogHubUser user) {
        setValue(user.getCompany());
    }

    private void valueChanged(ComponentValueChangeEvent<TextField, String> event) {
        String value = event.getValue();
        if(isValidValue(value)) {
            event.getSource().setInvalid(false);
            event.getSource().setErrorMessage(null);
        }
        else {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage(format("{0} length must be between 2 and 128 characters", LABEL));
        }
    }

    private boolean isValidValue(String value) {
        return(value.length() >= 2 && value.length() <= 64);
    }
}
