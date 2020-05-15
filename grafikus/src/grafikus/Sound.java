package grafikus;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Hang osztály, amit többször le lehet játszani és auto-rewindol.
 * TODO(boti): loop fuggveny?
 */
public class Sound implements LineListener {
    private boolean isReady = false;
    private Clip audioClip = null;

    public Sound() {

    }

    // Betölti a hangot a streamból
    public void load(InputStream istream) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (isReady) {
            return;
        }
        AudioInputStream stream = AudioSystem.getAudioInputStream(istream);
        AudioFormat format = stream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);

        audioClip = (Clip) AudioSystem.getLine(info);
        audioClip.open(stream);

        audioClip.addLineListener(this);
        isReady = true;
    }

    // Lejátssza a hangot, ha az be van töltve (és nem megy épp).
    public void play() {
        if (!isReady) return;

        audioClip.start();
    }

    // Megállítja es rewindolja a hangot
    public void stop() {
        audioClip.stop();
        audioClip.setFramePosition(0);
    }

    // Ha a hangfile végére erünk, autorewind.
    @Override
    public void update(LineEvent e) {
        System.out.println(e.toString());
        if (e.getType() == LineEvent.Type.STOP) {
            audioClip.setFramePosition(0);
        }
    }
}
