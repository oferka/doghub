package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.H2;
import org.hk.doghub.security.AuthenticatedUser;

import static java.lang.String.format;

public class TipsViewHeaderInfoTitleCount extends H2 {

    public static final String CLASS_NAME = TipsViewHeaderInfoTitle.CLASS_NAME + "-count";

    public TipsViewHeaderInfoTitleCount(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setTitleText(tipDataProvider.countForUser(authenticatedUser));
    }

    public void setTitleText(long count) {
        setText(format("(%s)", count));
    }
}
