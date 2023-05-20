package org.hk.doghub.automation.sound.player.clip;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SoundPlayerClipService {

    public void play(@NotNull @NotBlank String audioFilePath) {
        log.info("Play audio file '{}' started", audioFilePath);
        SoundPlayerUsingClip player = new SoundPlayerUsingClip();
        player.play(audioFilePath);
        log.info("Play audio file '{}' completed", audioFilePath);
    }
}
