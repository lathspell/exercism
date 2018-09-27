import java.util.Arrays;
import java.util.stream.Collectors;

class Acronym {

    private final String acronym;

    Acronym(String phrase) {
        acronym = Arrays.stream(phrase.toUpperCase().split("[^A-Z]"))
                .filter(it -> !it.isEmpty())
                .map(it -> it.substring(0,1))
                .collect(Collectors.joining());
    }

    String get() {
        return acronym;
    }

}
