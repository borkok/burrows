public class MoveToFrontEncoder {
    private final char[] letters = new char[256];

    public MoveToFrontEncoder() {
        for (char i = 0; i < 256; i++) {
            letters[i] = i;
        }
    }

    public char encode(char theLetter) {
        char code = letters[theLetter];
        letters[theLetter] = 0; //new code, put to front
        for (char letter = 0; letter < 256; letter++) {
            //move letters that were before 'theLetter' to the right
            if (letters[letter] < code && letter != theLetter)  letters[letter]++;
        }
        return code;
    }
}
