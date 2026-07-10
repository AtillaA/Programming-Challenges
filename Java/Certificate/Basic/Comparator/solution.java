import java.util.Arrays;
import java.util.Objects;

class Comparator {
    // Overload 1: compare two Strings
    public boolean compare(String a, String b) {
        return Objects.equals(a, b);
    }

    // Overload 2: compare two primitive integers
    public boolean compare(int a, int b) {
        return a == b;
    }

    // Overload 3: compare two integer arrays sequentially
    public boolean compare(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }
}
