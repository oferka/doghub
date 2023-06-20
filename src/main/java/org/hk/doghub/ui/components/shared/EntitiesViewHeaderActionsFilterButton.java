package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.vaadin.lineawesome.LineAwesomeIcon.FILTER_SOLID;

public class EntitiesViewHeaderActionsFilterButton extends Button {

    public static final String CLASS_NAME = EntitiesViewHeaderActions.CLASS_NAME + "-filter-button";

    public EntitiesViewHeaderActionsFilterButton() {
        addClassName(CLASS_NAME);
        setIcon(FILTER_SOLID.create());
        setText("Filter");
        addClickListener(this::filterClicked);
    }

    private void filterClicked(ClickEvent<Button> event) {
        Notification.show("Filter Clicked", 3000, MIDDLE);
    }
}
