package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;

import java.util.ArrayList;
import java.util.List;

import static java.text.MessageFormat.format;

public class DogHubComboBoxField extends ComboBox<String> {

    public static final String CLASS_NAME = "dog-hub-combo-box-title-field";

    private final int maxLength;

    public DogHubComboBoxField(String label, int maxLength, Component prefixComponent, List<String> values) {
        this.maxLength = maxLength;
        addClassName(CLASS_NAME);
        setLabel(label);
        setPrefixComponent(prefixComponent);
        setHelperText(format("Select or type your %s", label));
        setItems(values);
        setAllowCustomValue(true);
        addValueChangeListener(this::valueChanged);
        addCustomValueSetListener(this::customValueEntered);
    }

    private void valueChanged(ComponentValueChangeEvent<ComboBox<String>, String> event) {
        String value = event.getValue();
        setValueWithValidation(value);
    }

    private void customValueEntered(CustomValueSetEvent<ComboBox<String>> event) {
        String value = event.getDetail();
        setValueWithValidation(value);
    }

    protected void setValueWithValidation(String value) {
        List<String> violations = validateField(value);
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

    private List<String> validateField(String value) {
        List<String> result = new ArrayList<>();
        if(value == null || value.length() > maxLength) {
            result.add(format("{0} length must be up to {1} characters", getLabel(), maxLength));
        }
        return result;
    }

    public List<String> validateField() {
        return validateField(getValue());
    }
}
