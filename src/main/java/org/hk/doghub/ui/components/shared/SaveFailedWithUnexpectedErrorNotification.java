package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_TERTIARY_INLINE;
import static com.vaadin.flow.component.icon.VaadinIcon.CLOSE_SMALL;
import static com.vaadin.flow.component.icon.VaadinIcon.WARNING;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static com.vaadin.flow.component.notification.NotificationVariant.LUMO_ERROR;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class SaveFailedWithUnexpectedErrorNotification extends Notification {

    public static final String CLASS_NAME = "save-failed-with-unexpected-error-notification";

    public SaveFailedWithUnexpectedErrorNotification() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ERROR);
        Div info = new Div(new Text("Save Failed!"));
        HorizontalLayout layout = new HorizontalLayout(WARNING.create(), info, createCloseBtn(this));
        layout.setAlignItems(CENTER);
        add(layout);
        setPosition(MIDDLE);
        setDuration(5000);
    }

    private Button createCloseBtn(Notification notification) {
        Button closeBtn = new Button(CLOSE_SMALL.create(), clickEvent -> notification.close());
        closeBtn.addThemeVariants(LUMO_TERTIARY_INLINE);
        return closeBtn;
    }
}
