package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.html.H2;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.security.AuthenticatedUser;

public class TipCreationViewHeaderInfoTitleText extends H2 {

    public static final String CLASS_NAME = TipCreationViewHeaderInfoTitle.CLASS_NAME + "-text";

    public TipCreationViewHeaderInfoTitleText() {
        addClassName(CLASS_NAME);

        setTitleText("Create a Tip");
    }

    public void setTitleText(@NotNull String titleText) {
        setText(titleText);
    }
}
