package org.hk.doghub.ui.components.shared.tip;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static com.vaadin.flow.component.icon.VaadinIcon.TEXT_INPUT;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.tip.DogHubTip.CONTENT_MAX_LENGTH;

public class TipContentField extends EditableTextField {

    public static final String CLASS_NAME = "tip-content-field";

    public static final String LABEL = "Content";

    public TipContentField() {
        super(LABEL, false, CONTENT_MAX_LENGTH, TEXT_INPUT.create(), null);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubTip tip) {
        String value = tip.getContent();
        setValue((value != null) ? value : EMPTY);
    }
}
