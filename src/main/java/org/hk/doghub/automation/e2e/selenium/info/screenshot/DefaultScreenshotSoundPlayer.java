package org.hk.doghub.automation.e2e.selenium.info.screenshot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.sound.player.clip.SoundPlayerClipService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultScreenshotSoundPlayer implements ScreenshotSoundPlayer {

    private final ScreenshotSoundPlayerConfiguration screenshotSoundPlayerConfiguration;

    private final SoundPlayerClipService soundPlayerClipService;

    @Override
    public void play() {
        if(screenshotSoundPlayerConfiguration.isEnabled()) {
            log.info("Screenshot sound play started");
            soundPlayerClipService.play(screenshotSoundPlayerConfiguration.getAudioFilePath());
            log.info("Screenshot sound play completed");
        }
    }
}
