package com.sabrigunes.utilities.morse;

public enum Alphabet {
    A(".-", 'a'), B("-...", 'b'), C("-.-.", 'c'), D("-..", 'd'),
    E(".", 'e'), F("..-.", 'f'), G("--.", 'g'), H("....", 'h'),
    I("..", 'i'), J(".---", 'j'), K("-.-", 'k'), L(".-..", 'l'),
    M("--", 'm'), N("-.", 'n'), O("---", 'o'), P(".--.", 'p'),
    Q("--.-", 'q'), R(".-.", 'r'), S("...", 's'), T("-", 't'),
    U("..-", 'u'), V("...-", 'v'), W(".--", 'w'), X("-..-", 'x'),
    Y("-.--", 'y'), Z("--..", 'z'), ZERO("-----", '0'), ONE(".----", '1'),
    TWO("..---", '2'), THREE("...--", '3'), FOUR("....-", '4'),
    FIVE(".....", '5'), SIX("-....", '6'), SEVEN("--...", '7'),
    EIGHT("---..", '8'), NINE("----.", '9'), DOT(".-.-.-", '.'),
    COMMA("--..--", ','), QUESTION_MARK("..--..", '?'), SINGLE_QUOTE(".----.", '\''),
    EXCLAMATION_POINT("-.-.--", '!'), SLASH("-..-.", '/'), LEFT_PARENTHESIS("-.--.", '('),
    RIGHT_PARENTHESES("-.--.-", ')'), AMPERSAND(".-...", '&'), COLON("---...", ':'),
    SEMICOLON("-.-.-.", ';'), EQUALS("-...-", '='), PLUS(".-.-.", '+'),
    MINUS("-....-", '-'), UNDERSCORE("..--.-", '_'), QUOTE(".-..-.", '"'),
    DOLLAR_MARK("...-..-", '$'), AT_SYMBOL(".--.-.", '@');
    private final String morse;
    private final char character;

    Alphabet(String morse, char character) {
        this.morse = morse;
        this.character = character;
    }

    public String getMorse() {
        return morse;
    }

    public char getCharacter() {
        return character;
    }

    public static char findCharacter(String ch) {
        for (var m : Alphabet.values()) {
            if (m.getMorse().equals(ch))
                return m.getCharacter();
        }
        return '\0';
    }

    public static String findMorse(char ch) {
        for (var m : Alphabet.values()) {
            if (m.getCharacter() == ch)
                return m.getMorse();
        }
        return " ";
    }


}
