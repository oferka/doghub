package org.hk.doghub.automation.e2e.selenium.ui.actions.select;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/select-sound-player.properties")
@ConfigurationProperties(prefix = "select.sound.player")
@Data
public class SelectSoundPlayerConfiguration {

    private boolean enabled = true;

    private String audioFilePath = "automation/e2e/selenium/audio/mixkit-arcade-game-jump-coin-216.wav";
}
