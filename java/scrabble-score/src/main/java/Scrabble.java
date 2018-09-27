import java.util.HashMap;
import java.util.Map;

class Scrabble {

    private static final Map<String, Integer> points = new HashMap<String, Integer>() {{
        put("AEIOULNRST", 1);
        put("DG", 2);
        put("BCMP", 3);
        put("FHVWY", 4);
        put("K", 5);
        put("JX", 8);
        put("QZ", 10);
    }};

    private final String word;

    Scrabble(String word) {
        this.word = word;
    }

    int getScore() {
        return word.toUpperCase().chars()
                .map(c -> {
                    Map.Entry<String, Integer> found = points.entrySet().stream()
                            .filter(e -> e.getKey().contains(String.valueOf((char) c)))
                            .findFirst()
                            .orElse(null);
                    return found == null ? 0 : found.getValue();
                })
                .sum();
    }

}
