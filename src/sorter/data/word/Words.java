package sorter.data.word;

import sorter.DataType;
import sorter.data.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Words extends Data {
    private String[] array;
    private int length;

    public Words() {
        this.dataType = DataType.WORD;

        Scanner scanner = new Scanner(System.in);

        String[] words = parseInput(scanner).split(" ");
        this.length = words.length;
        this.array = words;
    }

    public Words(File file) {
        this.dataType = DataType.WORD;

        try (Scanner input = new Scanner(file)) {
            String[] words = parseInput(input).split(" ");
            this.length = words.length;
            this.array = words;
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public String[] getArray() {
        return array;
    }

    public int getLength() {
        return length;
    }

    private String parseInput(Scanner scanner) {
        StringBuilder wordString = new StringBuilder();

        while (scanner.hasNext()) {
            wordString.append(scanner.next());
            wordString.append(" ");
        }

        return wordString.toString();
    }
}
