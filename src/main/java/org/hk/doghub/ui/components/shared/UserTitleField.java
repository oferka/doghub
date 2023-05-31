package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.combobox.ComboBox;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import java.util.List;

import static java.util.Arrays.asList;

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
        addCustomValueSetListener(this::customValueEntered);
    }

    public void setValue(@NotNull DogHubUser user) {
        setValue(user.getTitle());
    }

    private void customValueEntered(CustomValueSetEvent<ComboBox<String>> event) {
        String value = event.getDetail();
        if(isValidValue(value)) {
            event.getSource().setValue(value);
            event.getSource().setInvalid(false);
            event.getSource().setErrorMessage(null);
        }
        else {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage("Title length must be between 2 and 64 characters");
        }
    }

    private boolean isValidValue(String value) {
        return(value.length() >=2 && value.length() <= 64);
    }
}
