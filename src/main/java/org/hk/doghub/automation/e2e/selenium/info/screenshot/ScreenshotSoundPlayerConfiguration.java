package org.hk.doghub.automation.e2e.selenium.info.screenshot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/screenshot-sound-player.properties")
@ConfigurationProperties(prefix = "screenshot.sound.player")
@Data
public class ScreenshotSoundPlayerConfiguration {

    private boolean enabled = true;

    private String audioFilePath = "audio/camera-shutter-click-01.wav";
}
