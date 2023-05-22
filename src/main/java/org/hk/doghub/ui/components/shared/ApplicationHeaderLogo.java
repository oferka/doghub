package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.html.Image;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.Key.KEY_K;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static org.hk.doghub.DogHubApplication.APPLICATION_HIGH_RESOLUTION_LOGO_BLACK_ON_TRANSPARENT;
import static org.hk.doghub.DogHubApplication.APPLICATION_NAME;

@Slf4j
public class ApplicationHeaderLogo extends Image {

    public static final String CLASS_NAME = ApplicationHeader.CLASS_NAME + "-logo";

    public ApplicationHeaderLogo() {
        addClassName(CLASS_NAME);
        setSrc(APPLICATION_HIGH_RESOLUTION_LOGO_BLACK_ON_TRANSPARENT);
        setAlt(APPLICATION_NAME);
        addClickListener(this::applicationImageClicked);
        addClickShortcut(KEY_K, ALT);
    }

    private void applicationImageClicked(ClickEvent<Image> event) {
        log.info("Image Clicked");
    }
}
