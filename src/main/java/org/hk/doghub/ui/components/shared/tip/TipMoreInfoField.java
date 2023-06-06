package org.hk.doghub.ui.components.shared.tip;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static com.vaadin.flow.component.icon.VaadinIcon.INFO_CIRCLE;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.tip.DogHubTip.MORE_INFO_MAX_LENGTH;

public class TipMoreInfoField extends EditableTextField {

    public static final String CLASS_NAME = "tip-more-info-field";

    public static final String LABEL = "More Information URL";

    public TipMoreInfoField() {
        super(LABEL, false, MORE_INFO_MAX_LENGTH, INFO_CIRCLE.create(), null);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubTip tip) {
        String value = tip.getMoreInfo();
        setValue((value != null) ? value : EMPTY);
    }
}
