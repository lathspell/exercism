import java.util.HashMap;
import java.util.Map;

class RnaTranscription {

    private static final Map<Character, Character> rnaMap = new HashMap() {
        {
            put('G', 'C');
            put('A', 'U');
            put('T', 'A');
            put('C', 'G');
        }
    };

    String transcribe(String dnaStrand) {
        return dnaStrand.codePoints()
                .map(it -> rnaMap.get((char) it))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
