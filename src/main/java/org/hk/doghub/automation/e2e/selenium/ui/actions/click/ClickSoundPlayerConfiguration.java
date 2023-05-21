package org.hk.doghub.automation.e2e.selenium.ui.actions.click;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/click-sound-player.properties")
@ConfigurationProperties(prefix = "click.sound.player")
@Data
public class ClickSoundPlayerConfiguration {

    private boolean enabled = true;

    private String audioFilePath = "automation/e2e/selenium/audio/mixkit-single-classic-click-1116.wav";
}
