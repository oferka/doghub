package org.hk.doghub.automation.sound.player.clip;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SoundPlayerClipServiceTest {

    @Autowired
    private SoundPlayerClipService soundPlayerClipService;

    @Test
    public void shouldPlay() {
        soundPlayerClipService.play("AudioFileWithWavFormat.wav");
    }
}