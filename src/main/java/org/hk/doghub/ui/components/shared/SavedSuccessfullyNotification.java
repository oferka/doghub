package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_TERTIARY_INLINE;
import static com.vaadin.flow.component.icon.VaadinIcon.CHECK_CIRCLE;
import static com.vaadin.flow.component.icon.VaadinIcon.CLOSE_SMALL;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static com.vaadin.flow.component.notification.NotificationVariant.LUMO_SUCCESS;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class SavedSuccessfullyNotification extends Notification {

    public static final String CLASS_NAME = "saved-successfully-notification";

    public SavedSuccessfullyNotification() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_SUCCESS);

        Div info = new Div(new Text("Saved Successfully!"));
        Button viewBtn = new Button("View", clickEvent -> close());
        viewBtn.getStyle().set("margin", "0 0 0 var(--lumo-space-l)");
        HorizontalLayout layout = new HorizontalLayout(CHECK_CIRCLE.create(), info, viewBtn, createCloseBtn(this));
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
