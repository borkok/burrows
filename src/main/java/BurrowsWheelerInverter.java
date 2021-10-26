import java.util.ArrayList;
import java.util.List;

public class BurrowsWheelerInverter {
    private final int R = 256;
    private final int N;
    private final char[] firstColumn;
    private final CountWithIndices[] lastColumnCharsCountWithIndices;

    private String result;

    public BurrowsWheelerInverter(int first, String lastColumn) {
        N = lastColumn.length();
        firstColumn = new char[N];

        lastColumnCharsCountWithIndices = new CountWithIndices[R+1];
        for (int r = 0; r <= R; r++) {
            lastColumnCharsCountWithIndices[r] = new CountWithIndices();
        }

        buildFirstColumn(lastColumn);
        buildResult(first);
    }

    private void buildResult(int first) {
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
        int orderNumber = charAtIndexOrderNumber(i, c);
        return lastColumnCharsCountWithIndices[c].indices.get(orderNumber);
    }

    private int charAtIndexOrderNumber(int index, char c) {
        return c == 0 ? index : index - lastColumnCharsCountWithIndices[c - 1].count;
    }

    public String getResult() {
        return result;
    }

    // key-indexed counting sort + storing indices of each char in last column
    private void buildFirstColumn(String lastColumn) {
        for (int i = 0; i < N; i++) {
            lastColumnCharsCountWithIndices[lastColumn.charAt(i)+1].count++;
        }

        for (int r = 0; r < R; r++) {
            lastColumnCharsCountWithIndices[r+1].count += lastColumnCharsCountWithIndices[r].count;
        }

        for (int i = 0; i < N; i++) {
            firstColumn[lastColumnCharsCountWithIndices[lastColumn.charAt(i)].count++] = lastColumn.charAt(i);
            lastColumnCharsCountWithIndices[lastColumn.charAt(i)].indices.add(i);
        }
    }

    private static class CountWithIndices {
        int count;
        List<Integer> indices = new ArrayList<>();
    }
}
