package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.html.Image;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GoogleLogo extends Image {

    public static final String CLASS_NAME = "google-logo";

    public GoogleLogo() {
        addClassName(CLASS_NAME);
        setSrc("images/google_logo.png");
        setAlt("Google");
        addClickListener(this::googleImageClicked);
    }

    private void googleImageClicked(ClickEvent<Image> event) {
        log.info("Google Image Clicked");
    }
}
