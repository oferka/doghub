package org.hk.doghub;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan(basePackages = "org.hk.doghub.model")
@Theme(value = DogHubApplication.THEME_NAME)
@PWA(name = DogHubApplication.APPLICATION_NAME, shortName = DogHubApplication.APPLICATION_SHORT_NAME, offlineResources = { DogHubApplication.APPLICATION_HIGH_RESOLUTION_LOGO_COLOR_ON_TRANSPARENT})
public class DogHubApplication extends SpringBootServletInitializer implements AppShellConfigurator {

    public static final String THEME_NAME = "doghub";
    public static final String APPLICATION_NAME = "Dog Hub";
    public static final String APPLICATION_SHORT_NAME = "DogHub";
    public static final String APPLICATION_HIGH_RESOLUTION_LOGO_BLACK_ON_TRANSPARENT = "images/doghub-high-resolution-logo-black-on-transparent-background.png";
    public static final String APPLICATION_HIGH_RESOLUTION_LOGO_BLACK_ON_WHITE = "images/doghub-high-resolution-logo-black-on-white-background.png";
    public static final String APPLICATION_HIGH_RESOLUTION_LOGO_COLOR_ON_TRANSPARENT = "images/doghub-high-resolution-logo-color-on-transparent-background.png";
    public static final String APPLICATION_HIGH_RESOLUTION_LOGO_WHITE_ON_TRANSPARENT = "images/doghub-high-resolution-logo-white-on-transparent-background.png";
    public static final String APPLICATION_HIGH_RESOLUTION_LOGO_WHITE_ON_BLACK = "images/doghub-high-resolution-logo-white-on-transparent-black.png";

    public static void main(String[] args) {
        SpringApplication.run(DogHubApplication.class, args);
    }
}