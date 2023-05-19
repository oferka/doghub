package org.hk.doghub.ui.views.app;

import com.vaadin.flow.component.html.H1;
import jakarta.validation.constraints.NotNull;

public class DogHubAppLayoutHeaderContentTitle extends H1 {

    public static final String CLASS_NAME = DogHubAppLayoutHeaderContent.CLASS_NAME + "-title";

    public DogHubAppLayoutHeaderContentTitle() {
        addClassName(CLASS_NAME);
    }

    public void setTitleText(@NotNull String titleText) {
        setText(titleText);
    }
}
