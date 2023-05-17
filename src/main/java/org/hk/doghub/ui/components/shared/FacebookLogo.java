package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.html.Image;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FacebookLogo extends Image {

    public static final String CLASS_NAME = "facebook-logo";

    public FacebookLogo() {
        addClassName(CLASS_NAME);
        setSrc("images/facebook_logo.png");
        setAlt("Facebook");
        addClickListener(this::facebookImageClicked);
    }

    private void facebookImageClicked(ClickEvent<Image> event) {
        log.info("Facebook Image Clicked");
    }
}
