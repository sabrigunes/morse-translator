package com.sabrigunes.utilities.morse;

public class Test {
    public static void main(String[] args) {
        morseTest();
    }

    private static void morseTest(){
        String str = MorseTranslator.encode("S O S");
        Morse morse = new Morse(str);
        morse.playMorseSoundInLoop();
    }

    private static void encoderTest(){
        String str = MorseTranslator.encode("hi, i am morse encoder.");
        System.out.println(str);
    }

    private static void decoderTest(){
        String str = MorseTranslator.decode("-- . .-. .... .- -... .- --..-- / -... . -. / -- --- .-. ... . / . -. -.-. --- -.. . .-. .-.-.-");
        System.out.println(str);
    }
}
