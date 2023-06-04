package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.textfield.TextField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.tip.DogHubTip;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.component.icon.VaadinIcon.TEXT_INPUT;
import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class TipContentField extends TextField {

    public static final String CLASS_NAME = "tip-content-field";

    public static final String LABEL = "Content";

    public TipContentField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setClearButtonVisible(true);
        setMinLength(2);
        setMaxLength(1024);
        setPrefixComponent(TEXT_INPUT.create());
        setValueChangeMode(EAGER);
        addValueChangeListener(this::valueChanged);
    }

    public void setValue(@NotNull DogHubTip tip) {
        String value = tip.getContent();
        setValue((value != null) ? value : EMPTY);
    }

    private void valueChanged(ComponentValueChangeEvent<TextField, String> event) {
        String value = event.getValue();
        validateValue(value);
    }

    private void validateValue(String value) {
        List<String> violations = validateTipField(value);
        if(violations.isEmpty()) {
            setInvalid(false);
            setErrorMessage(null);
        }
        else {
            setInvalid(true);
            setErrorMessage(violations.get(0));
        }
    }

    private List<String> validateTipField(String value) {
        List<String> result = new ArrayList<>();
        if(value == null || value.length() < 2 || value.length() > 64) {
            result.add(format("{0} length must be between 2 and 1024 characters", LABEL));
        }
        return result;
    }

    public List<String> validateTipField() {
        return validateTipField(getValue());
    }
}
