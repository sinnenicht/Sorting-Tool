package sorter.data.word;

import sorter.data.lex.LexNaturalSort;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WordNaturalSort {
    private final String[] array;
    private final int length;

    public WordNaturalSort(Words words) {
        this.length = words.getLength();
        LexNaturalSort sorter = new LexNaturalSort(words);
        this.array = sorter.getArray();
    }

    public void printToConsole() {
        System.out.println("Total words: " + length);
        System.out.println("Sorted data:");

        for (int index = 0; index < length; index++) {
            System.out.print(array[index] + " ");
        }
    }

    public void printToFile(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Total words: " + length);
            writer.print("Sorted data: ");

            for (int index = 0; index < length; index++) {
                writer.print(array[index] + " ");
            }
        } catch (IOException e) {
            System.out.println("An exception occurs " + e.getMessage());
        }
    }
}
