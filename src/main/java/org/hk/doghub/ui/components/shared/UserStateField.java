package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.combobox.ComboBox;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import java.util.List;

import static com.vaadin.flow.component.icon.VaadinIcon.MAP_MARKER;
import static java.text.MessageFormat.format;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UserStateField extends ComboBox<String> {

    public static final String CLASS_NAME = "user-state-field";

    public static final String LABEL = "State";

    public UserStateField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setHelperText("Select or type your state");
        List<String> stateValues = asList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",
                "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
                "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");
        setItems(stateValues);
        setPrefixComponent(MAP_MARKER.create());
        setAllowCustomValue(true);
        addValueChangeListener(this::valueChanged);
        addCustomValueSetListener(this::customValueEntered);
    }

    private void valueChanged(ComponentValueChangeEvent<ComboBox<String>, String> event) {
        String value = event.getValue();
        setValueWithValidation(value);
    }

    public void setValue(@NotNull DogHubUser user) {
        String value = (user.getAddress() != null) ? user.getAddress().getState() : EMPTY;
        setValueWithValidation(value);
    }

    private void customValueEntered(CustomValueSetEvent<ComboBox<String>> event) {
        String value = event.getDetail();
        setValueWithValidation(value);
    }

    private void setValueWithValidation(String value) {
        if(isValidValue(value)) {
            setValue(value);
            setInvalid(false);
            setErrorMessage(null);
        }
        else {
            setInvalid(true);
            setErrorMessage(format("{0} length must be between 2 and 64 characters", LABEL));
        }
    }

    private boolean isValidValue(String value) {
        return(value.length() >=2 && value.length() <= 64);
    }
}
