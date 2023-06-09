package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.H2;

import static java.lang.String.format;

public class UsersViewHeaderInfoTitleCount extends H2 {

    public static final String CLASS_NAME = UsersViewHeaderInfoTitle.CLASS_NAME + "-count";

    public UsersViewHeaderInfoTitleCount(long count) {
        addClassName(CLASS_NAME);
        setText(format("(%s)", count));
    }
}
