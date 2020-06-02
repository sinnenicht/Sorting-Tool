package sorter.data.lex;

import java.util.LinkedHashMap;
import java.util.Map;

public class LexByCount {
    private final Map<String, Integer> map;

    public LexByCount(String[] array) {
        int length = array.length;
        Map<String, Integer> numOccurrences = new LinkedHashMap<>();
        Map<String, Integer> sortedNumOccurrences = new LinkedHashMap<>();
        int highestCount = 1;

        for (String currentString : array) {
            if (numOccurrences.containsKey(currentString)) {
                int newCount = numOccurrences.get(currentString) + 1;
                numOccurrences.put(currentString, newCount);

                if (numOccurrences.get(currentString) > highestCount) {
                    highestCount = numOccurrences.get(currentString);
                }
            } else {
                numOccurrences.put(currentString, 1);
            }
        }

        for (int times = 1; times <= highestCount; times++) {
            if (numOccurrences.containsValue(times)) {
                LexNaturalSort sorter = new LexNaturalSort(numOccurrences, times);
                String[] keys = sorter.getArray();

                for (String string : keys) {
                    sortedNumOccurrences.put(string, times);
                }
            }
        }

        this.map = sortedNumOccurrences;
    }

    public Map<String, Integer> getMap() {
        return map;
    }
}
