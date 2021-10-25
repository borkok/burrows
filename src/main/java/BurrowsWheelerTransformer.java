public class BurrowsWheelerTransformer {
    private int first;
    private final String lastColumn;

    public BurrowsWheelerTransformer(String input) {
        StringBuilder sb = new StringBuilder();
        CircularSuffixArray suffixArray = new CircularSuffixArray(input);
        for (int i = 0; i < suffixArray.length(); i++) {
            int start = suffixArray.index(i);
            if (start == 0) {
                first = i;
                sb.append(input.charAt(input.length()-1));
            } else {
                sb.append(input.charAt(start-1));
            }
        }
        lastColumn = sb.toString();
    }

    public int getFirst() {
        return first;
    }

    public String getLastColumn() {
        return lastColumn;
    }
}
