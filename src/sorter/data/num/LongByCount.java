package sorter.data.num;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class LongByCount {
    private final int length;
    private final Map<Long, Integer> map;

    public LongByCount(Longs longs) {
        this.length = longs.getLength();
        long[] array = longs.getArray();
        Map<Long, Integer> numOccurrences = new LinkedHashMap<>();
        Map<Long, Integer> sortedNumOccurrences = new LinkedHashMap<>();
        int highestCount = 0;

        for (int index = 0; index < length; index++) {
            long currentLong = array[index];

            if (numOccurrences.containsKey(currentLong)) {
                int newCount = numOccurrences.get(currentLong) + 1;
                numOccurrences.put(currentLong, newCount);

                if (numOccurrences.get(currentLong) > highestCount) {
                    highestCount = numOccurrences.get(currentLong);
                }
            } else {
                numOccurrences.put(currentLong, 1);
            }
        }

        for (int times = 1; times <= highestCount; times++) {
            if (numOccurrences.containsValue(times)) {
                LongNaturalSort sorter = new LongNaturalSort(numOccurrences, times);
                long[] keys = sorter.getArray();

                for (long num : keys) {
                    sortedNumOccurrences.put(num, times);
                }
            }
        }

        this.map = sortedNumOccurrences;
    }

    public void printToConsole() {
        System.out.println("Total numbers: " + length);

        for (var entry : map.entrySet()) {
            int percent = entry.getValue() * 100 / length;
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + percent + "%");
        }
    }

    public void printToFile(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Total numbers: " + length);

            for (var entry : map.entrySet()) {
                int percent = entry.getValue() * 100 / length;
                writer.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + percent + "%");
            }
        } catch (IOException e) {
            System.out.println("An exception occurs " + e.getMessage());
        }
    }
}
