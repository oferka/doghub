package org.hk.doghub.ui.components.shared.tip;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.DogHubDateTimeField;

import java.time.LocalDateTime;

public class TipCreationTimeField extends DogHubDateTimeField {

    public static final String CLASS_NAME = "tip-creation-time-field";

    public static final String LABEL = "Creation Time";

    public TipCreationTimeField() {
        super(LABEL, true, true);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubTip tip) {
        LocalDateTime value = (tip.getCreationTime() != null) ? tip.getCreationTime().toLocalDateTime() : null;
        setValue(value);
    }
}
