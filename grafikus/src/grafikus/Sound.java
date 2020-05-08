package grafikus;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Hang osztaly, amit tobbszor le lehet jatszani
 * es auto-rewindol
 * TODO(boti): loop fuggveny?
 */
public class Sound implements LineListener {
    private boolean isReady = false;
    private Clip audioClip = null;

    public Sound() {

    }

    // Betolti a hangot fajlbol
    public void load(String path) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (isReady) {
            return;
        }

        URL u = Thread.currentThread().getContextClassLoader().getResource(path);
        AudioInputStream stream = AudioSystem.getAudioInputStream(u);
        AudioFormat format = stream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);

        audioClip = (Clip) AudioSystem.getLine(info);
        audioClip.open(stream);

        audioClip.addLineListener(this);
        isReady = true;
    }

    // lejatsza a hangot, ha az be van toltve (es nem megy epp)
    public void play() {
        if (!isReady) return;

        audioClip.start();
    }

    // megallitja es rewindolja a hangot
    public void stop() {
        audioClip.stop();
        audioClip.setFramePosition(0);
    }

    // Ha a hangfile vegere erunk, autorewind
    @Override
    public void update(LineEvent e) {
        System.out.println(e.toString());
        if (e.getType() == LineEvent.Type.STOP) {
            audioClip.setFramePosition(0);
        }
    }
}
