package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.Span;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.FormatStyle.MEDIUM;

public class TipCreationTime extends Span {

    public static final String CLASS_NAME = "tip-creation-time";

    public TipCreationTime(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        ZonedDateTime creationTime = tip.getCreationTime();
        if(creationTime != null) {
            setText(creationTime.format(DateTimeFormatter.ofLocalizedDateTime(MEDIUM)));
        }
    }
}
