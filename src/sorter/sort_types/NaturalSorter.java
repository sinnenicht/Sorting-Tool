package sorter.sort_types;

import sorter.DataType;
import sorter.Main;
import sorter.SortingMethod;
import sorter.data.Data;
import sorter.data.line.LineNaturalSort;
import sorter.data.line.Lines;
import sorter.data.num.LongNaturalSort;
import sorter.data.num.Longs;
import sorter.data.word.WordNaturalSort;
import sorter.data.word.Words;

public class NaturalSorter implements SortingMethod {
    @Override
    public void sort(Data data, boolean hasFile) {
        DataType dataType = data.getDataType();
        switch (dataType) {
            case LONG:
                LongNaturalSort longSort = new LongNaturalSort((Longs) data);

                if (hasFile) {
                    longSort.printToFile(Main.outputFileName);
                } else {
                    longSort.printToConsole();
                }
                break;

            case LINE:
                LineNaturalSort lineSort = new LineNaturalSort((Lines) data);

                if (hasFile) {
                    lineSort.printToFile(Main.outputFileName);
                } else {
                    lineSort.printToConsole();
                }
                break;

            case WORD:
                WordNaturalSort wordSort = new WordNaturalSort((Words) data);

                if (hasFile) {
                    wordSort.printToFile(Main.outputFileName);
                } else {
                    wordSort.printToConsole();
                }
                break;
        }
    }
}
