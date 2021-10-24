public class MoveToFrontHelper {
    private final char[] letters = new char[256];

    public MoveToFrontHelper() {
        for (char i = 0; i < 256; i++) {
            letters[i] = i;
        }
    }

    public char encode(char in) {
        char oldCode = letters[in];
        letters[in] = 0; //new code, put to front
        for (char i = 0; i < oldCode; i++) {
            letters[i]++; //move the ones that were before 'in' to the right
        }
        return oldCode;
    }
}
