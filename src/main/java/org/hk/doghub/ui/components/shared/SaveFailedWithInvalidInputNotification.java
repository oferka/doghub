package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.util.List;

import static com.vaadin.flow.component.details.DetailsVariant.SMALL;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static com.vaadin.flow.component.notification.NotificationVariant.LUMO_ERROR;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.vaadin.lineawesome.LineAwesomeIcon.EXCLAMATION_SOLID;

public class SaveFailedWithInvalidInputNotification extends Notification {

    public static final String CLASS_NAME = "save-failed-with-invalid-input-notification";

    public SaveFailedWithInvalidInputNotification(List<String> violations) {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ERROR);
        UnorderedList unorderedList = new UnorderedList();
        for(String violation : violations) {
            unorderedList.add(new ListItem(violation));
        }
        Details info = new Details("Save Failed!", unorderedList);
        info.setOpened(false);
        info.addThemeVariants(SMALL);
        HorizontalLayout layout = new HorizontalLayout(EXCLAMATION_SOLID.create(), info, new CloseNotificationButton(this));
        layout.setAlignItems(CENTER);
        add(layout);
        setPosition(MIDDLE);
        setDuration(10000);
    }
}
