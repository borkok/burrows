public class ArrayRotator {
    /**
     * Rotate subarray one step to the right.
     * Only subarray from 0 to end index is shifted. Rest of the array is left unmodified
     * @param array array to modify
     * @param end end of subarray
     * @throws IllegalArgumentException if end is outside array bounds
     */
    public static void rotateRight(char[] array, int end) {
        if (end < 0 || end >= array.length) throw new IllegalArgumentException();
        if (end == 0) return;

        char putMeInFront = array[end];
        System.arraycopy(array, 0, array, 1, end);
        array[0] = putMeInFront;
    }
}
