# MorseTranslator

MorseTranslator allows you to convert text to morse code and vice versa.
It also provides a feature to vocalize morse code, so you can hear the code audibly.

## Usage

Converting Text to Morse Code

    String text = "Hello, I am using MorseTranslator.";
    Morse morse = new Morse(text);
    String morseText = morse.getMorse();

Converting Morse Code to Text

    String morseText = "... / --- / ...";
    Morse morse = new Morse(morseText);
    String text = morse.getText(); 

Listening to Morse Code Sound

    String text1 = "Hello, I am using MorseTranslator.";
    Morse morse1 = new Morse(text1);
    morse1.playSound();

    String text2 = "... / --- / ...";
    Morse morse2 = new Morse(text2);
    morse2.playSound();