import java.util.stream.IntStream;

class NaturalNumber {

    private final int n;

    public NaturalNumber(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.n = n;
    }

    public Classification getClassification() {
        int sum = IntStream.rangeClosed(1, n/2)
                .parallel()
                .filter(it -> n % it == 0)
                .sum();

        if (sum > n) {
            return Classification.ABUNDANT;
        } else if (sum < n) {
            return Classification.DEFICIENT;
        } else {
            return Classification.PERFECT;
        }
    }

}
