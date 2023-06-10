package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.Past;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.FormatStyle.MEDIUM;

public class CreationTimeLabel extends Span {

    public static final String CLASS_NAME = "creation-time-label";

    public CreationTimeLabel(@Past ZonedDateTime creationTime) {
        addClassName(CLASS_NAME);
        if(creationTime != null) {
            setText(creationTime.format(DateTimeFormatter.ofLocalizedDateTime(MEDIUM)));
        }
    }
}
