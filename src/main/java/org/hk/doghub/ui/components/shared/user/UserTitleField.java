package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.combobox.ComboBox;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import java.util.ArrayList;
import java.util.List;

import static java.text.MessageFormat.format;
import static java.util.Arrays.asList;
import static org.hk.doghub.model.user.DogHubUser.TITLE_MAX_LENGTH;
import static org.hk.doghub.model.user.DogHubUser.TITLE_MIN_LENGTH;

public class UserTitleField extends ComboBox<String> {

    public static final String CLASS_NAME = "user-title-field";

    public static final String LABEL = "Title";

    public UserTitleField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setHelperText("Select or type your title");
        List<String> titleValues = asList("Mr.", "Mrs.", "Ms.", "Miss", "Dr.", "Rev.", "Prof.", "Hon.", "Capt.", "Col.", "Lt.", "Sen.", "Rep.", "Gov.", "Pres.", "Sir", "Dame", "Lady", "Lord", "Knight", "Prince", "Princess");
        setItems(titleValues);
        setAllowCustomValue(true);
        addValueChangeListener(this::valueChanged);
        addCustomValueSetListener(this::customValueEntered);
    }

    private void valueChanged(ComponentValueChangeEvent<ComboBox<String>, String> event) {
        String value = event.getValue();
        setValueWithValidation(value);
    }

    public void setValue(@NotNull DogHubUser user) {
        String value = user.getTitle();
        setValueWithValidation(value);
    }

    private void customValueEntered(CustomValueSetEvent<ComboBox<String>> event) {
        String value = event.getDetail();
        setValueWithValidation(value);
    }

    private void setValueWithValidation(String value) {
        List<String> violations = validateUserField(value);
        if(violations.isEmpty()) {
            setValue(value);
            setInvalid(false);
            setErrorMessage(null);
        }
        else {
            setInvalid(true);
            setErrorMessage(violations.get(0));
        }
    }

    private List<String> validateUserField(String value) {
        List<String> result = new ArrayList<>();
        if(value == null || value.length() < TITLE_MIN_LENGTH || value.length() > TITLE_MAX_LENGTH) {
            result.add(format("{0} length must be between {1} and {2} characters", LABEL, TITLE_MIN_LENGTH, TITLE_MAX_LENGTH));
        }
        return result;
    }

    public List<String> validateUserField() {
        return validateUserField(getValue());
    }
}
