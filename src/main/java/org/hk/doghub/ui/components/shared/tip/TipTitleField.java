package org.hk.doghub.ui.components.shared.tip;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static com.vaadin.flow.component.icon.VaadinIcon.DIAMOND;
import static org.hk.doghub.model.tip.DogHubTip.TITLE_MAX_LENGTH;
import static org.hk.doghub.model.tip.DogHubTip.TITLE_MIN_LENGTH;

public class TipTitleField extends EditableTextField {

    public static final String CLASS_NAME = "tip-title-field";

    public static final String LABEL = "Title";

    public TipTitleField() {
        super(LABEL, true, TITLE_MIN_LENGTH, TITLE_MAX_LENGTH, DIAMOND.create(), null);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubTip tip) {
        @NotNull String value = tip.getTitle();
        setValue(value);
    }
}
