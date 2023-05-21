package org.hk.doghub.automation.e2e.selenium.ui.actions.alert;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.sound.player.clip.SoundPlayerClipService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultConfirmBoxSoundPlayer implements ConfirmBoxSoundPlayer {

    private final ConfirmBoxSoundPlayerConfiguration confirmBoxSoundPlayerConfiguration;

    private final SoundPlayerClipService soundPlayerClipService;

    @Override
    public void play() {
        if(confirmBoxSoundPlayerConfiguration.isEnabled()) {
            log.info("Confirm box sound play started");
            soundPlayerClipService.play(confirmBoxSoundPlayerConfiguration.getAudioFilePath());
            log.info("Confirm box sound play completed");
        }
    }
}
