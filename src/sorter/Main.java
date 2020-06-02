package sorter;

import sorter.data.line.Lines;
import sorter.data.num.Longs;
import sorter.data.word.Words;
import sorter.sort_types.ByCountSorter;
import sorter.sort_types.NaturalSorter;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static File inputFileName;
    public static File outputFileName;

    public static void main(final String[] args) {
        DataType currentDataType = DataType.WORD;
        SortingType currentSortingType = SortingType.NATURAL;
        Pattern dataTypePattern = Pattern.compile("-dataType");
        Pattern sortingTypePattern = Pattern.compile("-sortingType");
        Pattern inputFilePattern = Pattern.compile("-inputFile");
        Pattern outputFilePattern = Pattern.compile("-outputFile");
        Pattern parameterPattern = Pattern.compile("-.*");
        int length = args.length;
        boolean badInput = false;
        boolean hasInFile = false;
        boolean hasOutFile = false;

        for (int index = 0; index < length; index++) {
            Matcher dataType = dataTypePattern.matcher(args[index]);
            Matcher sortingType = sortingTypePattern.matcher(args[index]);
            Matcher inputFile = inputFilePattern.matcher(args[index]);
            Matcher outputFile = outputFilePattern.matcher(args[index]);
            Matcher parameter = parameterPattern.matcher(args[index]);

            if (dataType.matches()) {
                int nextIndex = index + 1;

                if (nextIndex < length) {
                    currentDataType = parseDataType(args[nextIndex]);
                } else {
                    badInput = true;
                    System.out.println("No data type defined!");
                }

            } else if (sortingType.matches()) {
                int nextIndex = index + 1;

                if (nextIndex < length) {
                    currentSortingType = parseSortingType(args[nextIndex]);
                } else {
                    badInput = true;
                    System.out.println("No sorting type defined!");
                }

            } else if (inputFile.matches()) {
                int nextIndex = index + 1;

                if (nextIndex < length) {
                    File input = new File("./" + args[nextIndex]);
                    if (input.isFile()) {
                        hasInFile = true;
                        inputFileName = input;
                    } else {
                        System.out.println("Bad input file! No such file exists.");
                    }
                } else {
                    badInput = true;
                    System.out.println("No input file defined!");
                }
            } else if (outputFile.matches()) {
                int nextIndex = index + 1;

                if (nextIndex < length) {
                    hasOutFile = true;
                    outputFileName = new File("./" + args[nextIndex]);
                } else {
                    badInput = true;
                    System.out.println("No output file defined!");
                }
            } else if (parameter.matches()) {
                System.out.println("\"" + args[index] + "\" isn't a valid parameter. It's skipped.");
            }
        }

        if (!badInput) {
            programRuns(currentDataType, currentSortingType, hasInFile, hasOutFile);
        }
    }

    private static DataType parseDataType(String argument) {
        if ("long".equals(argument)) {
            return DataType.LONG;
        } else if ("line".equals(argument)) {
            return DataType.LINE;
        } else if ("word".equals(argument)) {
            return DataType.WORD;
        } else {
            return DataType.BAD_INPUT;
        }
    }

    private static SortingType parseSortingType(String argument) {
        if ("natural".equals(argument)) {
            return SortingType.NATURAL;
        } else if ("byCount".equals(argument)) {
            return SortingType.BY_COUNT;
        } else {
            return SortingType.BAD_INPUT;
        }
    }

    private static void programRuns(DataType dataType, SortingType sortingType, boolean hasInFile, boolean hasOutFile) {
        Sorter sorter = new Sorter();

        if (sortingType == SortingType.NATURAL) {
            sorter.setMethod(new NaturalSorter());
        } else if (sortingType == SortingType.BY_COUNT) {
            sorter.setMethod(new ByCountSorter());
        } else {
            System.out.println("Invalid sorting type.");
        }

        switch (dataType) {
            case LONG:
                Longs longs;

                if (hasInFile) {
                    longs = new Longs(inputFileName);
                } else {
                    longs = new Longs();
                }

                sorter.sort(longs, hasOutFile);
                break;

            case LINE:
                Lines lines;

                if (hasInFile) {
                    lines = new Lines(inputFileName);
                } else {
                    lines = new Lines();
                }

                sorter.sort(lines, hasOutFile);
                break;

            case WORD:
                Words words;

                if (hasInFile) {
                    words = new Words(inputFileName);
                } else {
                    words = new Words();
                }

                sorter.sort(words, hasOutFile);
                break;

            case BAD_INPUT:
                System.out.println("Invalid data type.");
                break;
        }
    }
}
