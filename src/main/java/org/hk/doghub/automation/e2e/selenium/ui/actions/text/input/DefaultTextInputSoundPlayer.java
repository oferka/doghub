package org.hk.doghub.automation.e2e.selenium.ui.actions.text.input;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.sound.player.clip.SoundPlayerClipService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultTextInputSoundPlayer implements TextInputSoundPlayer {

    private final TextInputSoundPlayerConfiguration textInputSoundPlayerConfiguration;

    private final SoundPlayerClipService soundPlayerClipService;

    @Override
    public void playMultipleCharacters() {
        if(textInputSoundPlayerConfiguration.isEnabled()) {
            log.info("Text input sound play for multiple characters started");
            soundPlayerClipService.play(textInputSoundPlayerConfiguration.getMultipleCharactersAudioFilePath());
            log.info("Text input sound play for multiple characters completed");
        }
    }

    @Override
    public void playSingleCharacters() {
        if(textInputSoundPlayerConfiguration.isEnabled()) {
            log.info("Text input sound play for single character started");
            soundPlayerClipService.play(textInputSoundPlayerConfiguration.getSingleCharactersAudioFilePath());
            log.info("Text input sound play for single character completed");
        }
    }
}
