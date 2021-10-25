import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {
    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    public static void transform() {
        String readString = BinaryStdIn.readString();
        BurrowsWheelerTransformer transformer = new BurrowsWheelerTransformer(readString);
        BinaryStdOut.write(transformer.getFirst());
        BinaryStdOut.write(transformer.getLastColumn());
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        String readString = BinaryStdIn.readString();
        BurrowsWheelerInverter inverter = new BurrowsWheelerInverter(first, readString);
        BinaryStdOut.write(inverter.getResult());
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args[0].equals("-")) transform();
        if (args[0].equals("+")) inverseTransform();
    }
}
