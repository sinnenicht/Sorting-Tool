package sorter.data.line;

import sorter.data.lex.LexNaturalSort;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNaturalSort {
    private final String[] array;
    private final int length;

    public LineNaturalSort(Lines lines) {
        this.length = lines.getLength();
        LexNaturalSort sorter = new LexNaturalSort(lines);
        this.array = sorter.getArray();
    }

    public void printToConsole() {
        System.out.println("Total lines: " + length);
        System.out.println("Sorted data:");

        for (int index = 0; index < length; index++) {
            System.out.println(array[index]);
        }
    }

    public void printToFile(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Total lines: " + length);
            writer.print("Sorted data: ");

            for (int index = 0; index < length; index++) {
                writer.print(array[index] + " ");
            }
        } catch (IOException e) {
            System.out.println("An exception occurs " + e.getMessage());
        }
    }
}
