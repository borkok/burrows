public class CircularSuffix implements Comparable<CircularSuffix> {

    private final int start;
    private final String originalText;

    CircularSuffix(String originalText, int start) {
        this.start = start;
        this.originalText = originalText;
    }

    int start() {
        return start;
    }

    char lastChar() {
        return getAtRelativeIndex(length() - 1);
    }

    int absoluteIndex(int relativeIndex) {
        if (relativeIndex >= length() - start) {
            int delta = relativeIndex - length();
            return start + delta;
        }
        return start + relativeIndex;
    }

    private int length() {
        return originalText.length();
    }

    char getAtRelativeIndex(int relativeIndex) {
        return originalText.charAt(absoluteIndex(relativeIndex));
    }

    @Override
    public int compareTo(CircularSuffix other) {
        for (int i = 0; i < length(); i++) {
            if (this.getAtRelativeIndex(i) > other.getAtRelativeIndex(i)) return 1;
            if (this.getAtRelativeIndex(i) < other.getAtRelativeIndex(i)) return -1;
        }
        return 0;
    }
}
