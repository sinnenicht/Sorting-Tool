package sorter.data.word;

import sorter.data.lex.LexByCount;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class WordByCount {
    private final int length;
    private final Map<String, Integer> map;

    public WordByCount(Words words) {
        this.length = words.getLength();
        LexByCount lexByCount = new LexByCount(words.getArray());
        this.map = lexByCount.getMap();
    }

    public void printToConsole() {
        System.out.println("Total words: " + length);

        for (var entry : map.entrySet()) {
            int percent = entry.getValue() * 100 / length;
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + percent + "%");
        }
    }

    public void printToFile(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Total words: " + length);

            for (var entry : map.entrySet()) {
                int percent = entry.getValue() * 100 / length;
                writer.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + percent + "%");
            }
        } catch (IOException e) {
            System.out.println("An exception occurs " + e.getMessage());
        }
    }
}
