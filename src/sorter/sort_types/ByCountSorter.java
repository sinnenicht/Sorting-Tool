package sorter.sort_types;

import sorter.DataType;
import sorter.Main;
import sorter.SortingMethod;
import sorter.data.Data;
import sorter.data.line.LineByCount;
import sorter.data.line.Lines;
import sorter.data.num.LongByCount;
import sorter.data.num.Longs;
import sorter.data.word.WordByCount;
import sorter.data.word.Words;

public class ByCountSorter implements SortingMethod {
    @Override
    public void sort(Data data, boolean hasFile) {
        DataType dataType = data.getDataType();
        switch (dataType) {
            case LONG:
                LongByCount longSort = new LongByCount((Longs) data);

                if (hasFile) {
                    longSort.printToFile(Main.outputFileName);
                } else {
                    longSort.printToConsole();
                }
                break;
            case LINE:
                LineByCount lineSort = new LineByCount((Lines) data);

                if (hasFile) {
                    lineSort.printToFile(Main.outputFileName);
                } else {
                    lineSort.printToConsole();
                }
                break;
            case WORD:
                WordByCount wordSort = new WordByCount((Words) data);

                if (hasFile) {
                    wordSort.printToFile(Main.outputFileName);
                } else {
                    wordSort.printToConsole();
                }
                break;
        }
    }
}
