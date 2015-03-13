package demo_son;

import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Arnaud FRANCOIS
 */
public class Son extends Thread {
    private String son;

    public Son(String son) {
        this.son = son;
    }

    @Override
    public void run() {
        SourceDataLine line;
        AudioInputStream audioInputStream;
        AudioFormat audioFormat;

        try {
            audioInputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(son));
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        audioFormat = audioInputStream.getFormat();
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

        // On récupère le DataLine adéquat et on l'ouvre
        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
        }

        // Avant toute chose il est nécessaire d'ouvrir la ligne
        try {
            line.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
        }
        // pour que le flux soit effectivement redirigé sur la carte son il
        // faut demarrer la ligne
        line.start();

		// il faut maintenant écrire sur la ligne. Travail comme sur un
		// inputStream quelconque
		try {
			byte bytes[] = new byte[1024];
			int bytesRead=0;
			while (((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1)) {
				line.write(bytes, 0, bytesRead);
			}
		} catch (IOException io) {
			io.printStackTrace();
			return;
		}
		// on ferme la ligne à la fin
		line.close();
    }
}
