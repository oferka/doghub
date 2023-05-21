package org.hk.doghub.automation.e2e.selenium.ui.actions.click;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.sound.player.clip.SoundPlayerClipService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultClickSoundPlayer implements ClickSoundPlayer {

    private final ClickSoundPlayerConfiguration clickSoundPlayerConfiguration;

    private final SoundPlayerClipService soundPlayerClipService;

    @Override
    public void play() {
        if(clickSoundPlayerConfiguration.isEnabled()) {
            log.info("Click sound play started");
            soundPlayerClipService.play(clickSoundPlayerConfiguration.getAudioFilePath());
            log.info("Click sound play completed");
        }
    }
}
