import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CircularSuffixArray {
    private final List<CircularSuffix> sortedSuffixes;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) throw new IllegalArgumentException();
        sortedSuffixes = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            sortedSuffixes.add(new CircularSuffix(s, i));
        }
        sortedSuffixes.sort(Comparator.naturalOrder());
    }

    // length of s
    public int length() {
        return sortedSuffixes.size();
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i >= length()) throw new IllegalArgumentException();
        return sortedSuffixes.get(i).start();
    }

    // unit testing (required)
    public static void main(String[] args) {}

}
