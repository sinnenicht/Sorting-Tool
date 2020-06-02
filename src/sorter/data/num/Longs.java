package sorter.data.num;

import sorter.DataType;
import sorter.data.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Longs extends Data {
    private long[] array;
    private int length;

    public Longs() {
        this.dataType = DataType.LONG;

        Scanner scanner = new Scanner(System.in);

        String[] stringNumbers = parseInput(scanner).split(" ");
        this.length = stringNumbers.length;
        long[] numbers = new long[length];

        for (int index = 0; index < length; index++) {
            numbers[index] = Long.parseLong(stringNumbers[index]);
        }

        this.array = numbers;
    }

    public Longs(File file) {
        this.dataType = DataType.LONG;

        try (Scanner input = new Scanner(file)) {
            String[] stringNumbers = parseInput(input).split(" ");
            this.length = stringNumbers.length;
            long[] numbers = new long[length];

            for (int index = 0; index < length; index++) {
                numbers[index] = Long.parseLong(stringNumbers[index]);
            }

            this.array = numbers;
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public long[] getArray() {
        return array;
    }

    public int getLength() {
        return length;
    }

    private String parseInput(Scanner scanner) {
        StringBuilder numberString = new StringBuilder();
        Pattern nonLongPattern = Pattern.compile("[^0-9\\-]");

        while (scanner.hasNext()) {
            String currentValue = scanner.next();
            Matcher nonLong = nonLongPattern.matcher(currentValue);

            if (nonLong.find()) {
                System.out.println("\"" + currentValue + "\" isn't a long. It's skipped.");
            } else {
                numberString.append(currentValue);
                numberString.append(" ");
            }
        }

        return numberString.toString();
    }
}
