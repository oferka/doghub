package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfoTitleCount;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfoTitleIcon;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfoTitleText;

import static com.vaadin.flow.component.icon.VaadinIcon.USERS;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UsersViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = UsersViewHeaderInfo.CLASS_NAME + "-title";

    private final EntitiesViewHeaderInfoTitleIcon icon;
    private final EntitiesViewHeaderInfoTitleText text;
    private final EntitiesViewHeaderInfoTitleCount count;

    public UsersViewHeaderInfoTitle(UserDataProvider usersViewDataProvider) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        icon = new EntitiesViewHeaderInfoTitleIcon(USERS);
        add(icon);

        text = new EntitiesViewHeaderInfoTitleText(UsersView.NAME);
        add(text);

        count = new EntitiesViewHeaderInfoTitleCount(usersViewDataProvider.count());
        add(count);
    }
}
