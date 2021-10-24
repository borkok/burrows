public class MoveToFrontDecoder {
    private final char[] letters = new char[256];

    public MoveToFrontDecoder() {
        for (char i = 0; i < 256; i++) {
            letters[i] = i;
        }
    }

    public char decode(char code) {
        int theLetter = findLetter(code);
        letters[theLetter] = 0; //new code, put to front
        for (char letter = 0; letter < 256; letter++) {
            //move to the right letters that were before 'letter'
            if (letters[letter] < code && letter != theLetter)  letters[letter]++;
        }
        return (char) theLetter;
    }

    private int findLetter(char code) {
        // check simple
        if (letters[code] == code) return code;

        // search for code
        for (char letter = 0; letter < 256; letter++) {
            if (letters[letter] == code) return letter;
        }

        // should never happen
        return -1;
    }
}
