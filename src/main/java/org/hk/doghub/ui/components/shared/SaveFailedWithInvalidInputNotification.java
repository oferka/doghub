package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_TERTIARY_INLINE;
import static com.vaadin.flow.component.icon.VaadinIcon.CLOSE_SMALL;
import static com.vaadin.flow.component.icon.VaadinIcon.WARNING;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static com.vaadin.flow.component.notification.NotificationVariant.LUMO_ERROR;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class SaveFailedWithInvalidInputNotification extends Notification {

    public static final String CLASS_NAME = "save-failed-with-invalid-input-notification";

    public SaveFailedWithInvalidInputNotification(List<String> violations) {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ERROR);
        VerticalLayout info = new VerticalLayout();
        Div infoHeader = new Div(new Text("Save Failed!"));
        info.add(infoHeader);
        for(String violation : violations) {
            info.add(new Div(new Text(violation)));
        }
        HorizontalLayout layout = new HorizontalLayout(WARNING.create(), info, createCloseBtn(this));
        layout.setAlignItems(CENTER);
        add(layout);
        setPosition(MIDDLE);
        setDuration(10000);
    }

    private Button createCloseBtn(Notification notification) {
        Button closeBtn = new Button(CLOSE_SMALL.create(), clickEvent -> notification.close());
        closeBtn.addThemeVariants(LUMO_TERTIARY_INLINE);
        return closeBtn;
    }
}
