package com.sabrigunes.utilities.morse;

public class Morse {

    private final String text;
    private final String morse;

    public String getText() {
        return text;
    }

    public String getMorse() {
        return morse;
    }

    public Morse(String str) {
        if (isMorse(str)) {
            morse = str.trim();
            text = MorseTranslator.decode(morse);
        } else {
            text = str.trim();
            morse = MorseTranslator.encode(text);
        }
    }

    private boolean isMorse(String str) {
        for (int i = 0; i < str.length(); ++i) {
            if (!(str.charAt(i) == '.' || str.charAt(i) == '-' || str.charAt(i) == '/' || Character.isWhitespace(str.charAt(i))))
                return false;
        }
        return true;
    }

    public void playMorseSound() {
        SoundBuilder.play(morse);
    }

    public void playMorseSoundInLoop() {
        try{
            while (true){
                playMorseSound();
                Thread.sleep(300);
            }
        }
        catch (InterruptedException ex){
            throw new RuntimeException(ex.getMessage());
        }



    }

}
