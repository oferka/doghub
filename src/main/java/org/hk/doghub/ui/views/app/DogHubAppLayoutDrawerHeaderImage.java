package org.hk.doghub.ui.views.app;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.html.Image;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.Key.KEY_K;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static org.hk.doghub.DogHubApplication.APPLICATION_LOGO_WHITE_ON_TRANSPARENT;
import static org.hk.doghub.DogHubApplication.APPLICATION_NAME;

@Slf4j
public class DogHubAppLayoutDrawerHeaderImage extends Image {

    public static final String CLASS_NAME = DogHubAppLayoutDrawerHeader.CLASS_NAME + "-image";

    public DogHubAppLayoutDrawerHeaderImage() {
        addClassName(CLASS_NAME);
        setSrc(APPLICATION_LOGO_WHITE_ON_TRANSPARENT);
        setAlt(APPLICATION_NAME);
        addClickListener(this::applicationImageClicked);
        addClickShortcut(KEY_K, ALT);
    }

    private void applicationImageClicked(ClickEvent<Image> event) {
        log.info("Image Clicked");
    }
}
