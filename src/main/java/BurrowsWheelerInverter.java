public class BurrowsWheelerInverter {
    private final String result;

    private char[] firstColumn;
    private final String lastColumn;

    public BurrowsWheelerInverter(int first, String transformed) {
        lastColumn = transformed;

        sortLastColumnIntoFirstColumn();

        StringBuilder sb = new StringBuilder();
        int index = first;
        for (int i = 0; i < firstColumn.length; i++) {
            sb.append(firstColumn[index]);
            index = next(index);
        }
        result = sb.toString();
    }

    /*
    if first is the row in which the original input string appears,
    then next[first] is the row in the sorted order where the 1st original suffix (the original string left-shifted by 1) appears;
    next[next[first]] is the row in the sorted order where the 2nd original suffix appears;
    next[next[next[first]]] is the row where the 3rd original suffix appears; and so forth.
     */
    int next(int i) {
        char c = firstColumn[i];
        int count = 1;
        for (int j = i - 1; j >= 0 && firstColumn[j] == c; j--) {
            count++;
        }

        for (int j = 0; j < lastColumn.length(); j++) {
            if (lastColumn.charAt(j) == c) {
                if (count == 1) return j;
                count--;
            }
        }
        throw new IllegalStateException();
    }

    public String getResult() {
        return result;
    }

    private void sortLastColumnIntoFirstColumn() {
        int N = lastColumn.length();
        int R = 256;
        int[] count = new int[R+1];
        firstColumn = new char[N];

        for (int i = 0; i < N; i++) {
            count[lastColumn.charAt(i)+1]++;
        }

        for (int r = 0; r < R; r++) {
            count[r+1] += count[r];
        }

        for (int i = 0; i < N; i++) {
            firstColumn[count[lastColumn.charAt(i)]++] = lastColumn.charAt(i);
        }
    }
}
