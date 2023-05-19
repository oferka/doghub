package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.security.AuthenticatedUser;

public class TipsViewHeaderInfoDescription extends Span {

    public static final String CLASS_NAME = TipsViewHeaderInfo.CLASS_NAME + "-description";

    public TipsViewHeaderInfoDescription(TipsDataProvider tipsDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setDescriptionText("Tips view description");
    }

    public void setDescriptionText(@NotNull String descriptionText) {
        setText(descriptionText);
    }
}
