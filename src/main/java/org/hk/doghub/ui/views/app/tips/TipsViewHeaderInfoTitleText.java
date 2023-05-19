package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.H2;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.security.AuthenticatedUser;

public class TipsViewHeaderInfoTitleText extends H2 {

    public static final String CLASS_NAME = TipsViewHeaderInfoTitle.CLASS_NAME + "-text";

    public TipsViewHeaderInfoTitleText(TipsDataProvider tipsDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setTitleText(TipsView.NAME);
    }

    public void setTitleText(@NotNull String titleText) {
        setText(titleText);
    }
}
