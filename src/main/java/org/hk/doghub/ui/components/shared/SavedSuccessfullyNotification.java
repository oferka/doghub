package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static com.vaadin.flow.component.notification.NotificationVariant.LUMO_SUCCESS;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.vaadin.lineawesome.LineAwesomeIcon.CHECK_CIRCLE_SOLID;

public class SavedSuccessfullyNotification extends Notification {

    public static final String CLASS_NAME = "saved-successfully-notification";

    public SavedSuccessfullyNotification() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_SUCCESS);

        Div info = new Div(new Text("Saved Successfully!"));
        Button viewBtn = new Button("View", clickEvent -> close());
        HorizontalLayout layout = new HorizontalLayout(CHECK_CIRCLE_SOLID.create(), info, viewBtn, new CloseNotificationButton(this));
        layout.setAlignItems(CENTER);
        add(layout);
        setPosition(MIDDLE);
        setDuration(5000);
    }
}
