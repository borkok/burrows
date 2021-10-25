public class MoveToFrontDecoder {
    // index is code, value is letter
    private final char[] letters = new char[256];

    public MoveToFrontDecoder() {
        for (char i = 0; i < 256; i++) {
            letters[i] = i;
        }
    }

    public char decode(char code) {
        ArrayRotator.rotateRight(letters, code);
        return letters[0];
    }
}
