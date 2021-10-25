public class MoveToFrontEncoder {
    // index is code, value is letter
    private final char[] letters = new char[256];

    public MoveToFrontEncoder() {
        for (char i = 0; i < 256; i++) {
            letters[i] = i;
        }
    }

    public char encode(char theLetter) {
        char code = findCode(theLetter);
        ArrayRotator.rotateRight(letters, code);
        return code;
    }

    private char findCode(char theLetter) {
        if (letters[theLetter] == theLetter) return theLetter;
        for (char i = 0; i < 256; i++) {
            if (letters[i] == theLetter) return i;
        }
        //should never happen
        throw new IllegalStateException();
    }
}
