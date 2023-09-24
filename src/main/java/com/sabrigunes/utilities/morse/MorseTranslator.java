package com.sabrigunes.utilities.morse;

public class MorseTranslator {

    public static String encode(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            stringBuilder.append(charToMorse(ch)).append(" ");
        }

        return stringBuilder.toString().trim();
    }

    private static String charToMorse(char ch) {
        try {
            if (Character.isWhitespace(ch)) {
                return "/";
            }
            return Alphabet.findMorse(ch);
        } catch (IllegalArgumentException ex) {
            return "";
        }

    }

    public static String decode(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        var morse = str.split("[ ]+");
        for (var m : morse) {
            stringBuilder.append(morseToCharacter(m));
        }
        return stringBuilder.toString().trim();
    }

    private static char morseToCharacter(String str) {
        if (str.equals("/"))
            return ' ';
        return Alphabet.findCharacter(str);
    }

}
