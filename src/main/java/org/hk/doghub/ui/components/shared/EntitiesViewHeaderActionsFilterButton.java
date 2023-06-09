package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.icon.VaadinIcon.FILTER;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class EntitiesViewHeaderActionsFilterButton extends Button {

    public static final String CLASS_NAME = "entities-view-header-actions-filter-button";

    public EntitiesViewHeaderActionsFilterButton() {
        addClassName(CLASS_NAME);
        setIcon(FILTER.create());
        setText("Filter");
        addClickListener(this::filterClicked);
    }

    private void filterClicked(ClickEvent<Button> event) {
        Notification.show("Filter Clicked", 3000, MIDDLE);
    }
}
