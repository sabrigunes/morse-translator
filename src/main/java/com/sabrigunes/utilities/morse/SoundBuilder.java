package com.sabrigunes.utilities.morse;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteBuffer;

public class SoundBuilder {
    public static void play(String morse) {
        String[] morseNodes = morse.split(" ");
        for (String m : morseNodes)
            playMorseCharacter(m);

    }

    private static void playMorseCharacter(String morse) {
        try {
            Thread.sleep(50);
            for (int i = 0; i < morse.length(); ++i) {
                if (morse.charAt(i) == '/')
                    Thread.sleep(50);
                else if ((morse.charAt(i) == '.')) {
                    beep(450, 200);
                    Thread.sleep(50);
                } else if ((morse.charAt(i) == '-')) {
                    beep(450, 500);
                    Thread.sleep(50);
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }


    /**
     * Source: https://gist.github.com/jbzdak/61398b8ad795d22724dd
     * Thanks @jbzdak.
     */
    public static void beep(double freq, final double millis) throws InterruptedException, LineUnavailableException {
        final Clip clip = AudioSystem.getClip();
        AudioFormat af = clip.getFormat();
        if (af.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
            throw new UnsupportedOperationException("Unknown encoding");
        }
        if (af.getSampleSizeInBits() != 16) {
            System.err.println("Weird sample size.  Dunno what to do with it.");
            return;
        }
        int bytesPerFrame = af.getFrameSize();
        double fps = af.getFrameRate();
        int frames = (int) (fps * (millis / 1000));
        ByteBuffer data = ByteBuffer.allocate(frames * bytesPerFrame);
        double freqFactor = (Math.PI / 2) * freq / fps;
        double ampFactor = Short.MAX_VALUE;
        short sample;
        for (int frame = 0; frame < frames; frame++) {
            sample = (short) (ampFactor * Math.sin(frame * freqFactor));
            data.putShort(sample);
        }
        clip.open(af, data.array(), 0, data.position());
        clip.addLineListener(new LineListener() {
            @Override
            public void update(LineEvent event) {
                if (event.getType() == LineEvent.Type.START) {
                    Timer t = new Timer((int) millis + 1, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            clip.close();
                        }
                    });
                    t.setRepeats(false);
                    t.start();
                }
            }
        });
        clip.start();

        Thread.sleep((long) millis);


    }
}
