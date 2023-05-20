package org.hk.doghub.automation.sound.player.clip;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

@Service
@RequiredArgsConstructor
@Slf4j
public class SoundPlayerUsingClip implements LineListener {

    boolean isPlaybackCompleted;

    @Override
    public void update(LineEvent event) {
        if (LineEvent.Type.START == event.getType()) {
            log.info("Playback start event occurred");
        }
        else if (LineEvent.Type.STOP == event.getType()) {
            log.info("Playback stop event occurred");
            isPlaybackCompleted = true;
        }
    }

    void play(String audioFilePath) {
        log.info("Play audio file '{}' started", audioFilePath);
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(audioFilePath);
            assert inputStream != null;
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.addLineListener(this);
            audioClip.open(audioStream);
            audioClip.start();
            while (!isPlaybackCompleted) {
                Thread.sleep(Duration.ofSeconds(1).toMillis());
            }
            audioClip.close();
            audioStream.close();
        }
        catch (InterruptedException | UnsupportedAudioFileException | LineUnavailableException | IOException exception) {
            log.error("Error occurred during playback process:" + exception.getMessage());
        }
        log.info("Play audio file '{}' completed", audioFilePath);
    }
}
