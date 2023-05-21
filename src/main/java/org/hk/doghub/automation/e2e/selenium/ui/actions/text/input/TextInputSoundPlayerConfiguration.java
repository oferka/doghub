package org.hk.doghub.automation.e2e.selenium.ui.actions.text.input;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/text-input-sound-player.properties")
@ConfigurationProperties(prefix = "text.input.sound.player")
@Data
public class TextInputSoundPlayerConfiguration {

    private boolean enabled = true;

    private String multipleCharactersAudioFilePath = "automation/e2e/selenium/audio/mixkit-keyboard-key-presses-2534.wav";

    private String singleCharactersAudioFilePath = "automation/e2e/selenium/audio/mixkit-single-key-type-2533.wav";
}
