package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.Key.KEY_F;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.FILTER;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class TipsViewHeaderActionsFilterButton extends Button {

    public static final String CLASS_NAME = TipsViewHeaderActions.CLASS_NAME + "-filter-button";

    public TipsViewHeaderActionsFilterButton(TipsDataProvider tipsDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setIcon(FILTER.create());
        setText("Filter");
        addClickListener(this::filterClicked);
        addClickShortcut(KEY_F, ALT);
    }

    private void filterClicked(ClickEvent<Button> event) {
        Notification.show("Filter Clicked", 3000, MIDDLE);
    }
}
