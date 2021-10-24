import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/*
Performance requirements.
The running time of both move-to-front encoding and decoding must be proportional to n R (or better)
in the worst case and proportional to n + R (or better) on inputs that arise when compressing
typical English text, where n is the number of characters in the input and R is the alphabet size.

The amount of memory used by both move-to-front encoding and decoding must be proportional
to n + R (or better) in the worst case.
 */
public class MoveToFront {
    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        MoveToFrontEncoder encoder = new MoveToFrontEncoder();
        while(!BinaryStdIn.isEmpty()) {
            BinaryStdOut.write(encoder.encode(BinaryStdIn.readChar()));
        }
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        MoveToFrontDecoder decoder = new MoveToFrontDecoder();
        while(!BinaryStdIn.isEmpty()) {
            BinaryStdOut.write(decoder.decode(BinaryStdIn.readChar()));
        }
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-")) encode();
        if (args[0].equals("+")) decode();
    }
}
