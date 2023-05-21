package org.hk.doghub.automation.e2e.selenium.ui.actions.select;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.sound.player.clip.SoundPlayerClipService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultSelectSoundPlayer implements SelectSoundPlayer {

    private final SelectSoundPlayerConfiguration selectSoundPlayerConfiguration;

    private final SoundPlayerClipService soundPlayerClipService;

    @Override
    public void play() {
        if(selectSoundPlayerConfiguration.isEnabled()) {
            log.info("Select sound play started");
            soundPlayerClipService.play(selectSoundPlayerConfiguration.getAudioFilePath());
            log.info("Select sound play completed");
        }
    }
}
