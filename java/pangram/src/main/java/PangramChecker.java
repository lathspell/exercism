import java.util.stream.IntStream;

public class PangramChecker {

    public boolean isPangram(String input) {
        String lowered = input.toLowerCase();
        return IntStream.rangeClosed('a', 'z').noneMatch(c -> lowered.indexOf(c) == -1);
    }

}
