package sorter.data.line;

import sorter.DataType;
import sorter.data.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lines extends Data {
    private String[] array;
    private int length;

    public Lines() {
        this.dataType = DataType.LINE;

        Scanner scanner = new Scanner(System.in);

        String[] lines = parseInput(scanner).split("#%NEW#%");
        this.length = lines.length;
        this.array = lines;
    }

    public Lines(File file) {
        this.dataType = DataType.LINE;

        try (Scanner input = new Scanner(file)) {
            String[] lines = parseInput(input).split("#%NEW#%");
            this.length = lines.length;
            this.array = lines;
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
        StringBuilder lineString = new StringBuilder();

        while (scanner.hasNextLine()) {
            lineString.append(scanner.nextLine());
            lineString.append("#%NEW#%");
        }

        return lineString.toString();
    }
}
