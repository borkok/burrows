public class MoveToFrontDecoder {
    private final char[] letters = new char[256];

    public MoveToFrontDecoder() {
        for (char i = 0; i < 256; i++) {
            letters[i] = i;
        }
    }

    public char decode(char code) {
        int oldLetter = -1;
        // check simple
        if (letters[code] == code)  {
            oldLetter = code;
        } else {
            // search for code
            for (char i = 0; i < 256; i++) {
                if (letters[i] == code) {
                    oldLetter = i;
                    break;
                }
            }
        }
        letters[oldLetter] = 0; //new encode, put to front
        for (char i = 0; i < 256; i++) {
            //move the ones that were before 'in' to the right
            if (letters[i] < code && i != oldLetter)  letters[i]++;
        }
        return (char) oldLetter;
    }
}
