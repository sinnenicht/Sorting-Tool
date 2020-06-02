package sorter.data.lex;

import sorter.data.line.Lines;
import sorter.data.word.Words;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LexNaturalSort {
    private final String[] array;
    private final int length;

    public LexNaturalSort(Lines lines) {
        this.length = lines.getLength();
        String[] array = lines.getArray();
        mergeSort(array, 0, length);
        this.array = array;
    }

    public LexNaturalSort(Words words) {
        this.length = words.getLength();
        String[] array = words.getArray();
        mergeSort(array, 0, length);
        this.array = array;
    }

    public LexNaturalSort(Map<String, Integer> map, int numTimes) {
        List<String> arrayList = new ArrayList<>();

        for (var entry : map.entrySet()) {
            if (entry.getValue() == numTimes) {
                arrayList.add(entry.getKey());
            }
        }

        String[] array = new String[arrayList.size()];
        int index = 0;

        for (var entry : arrayList) {
            array[index++] = entry;
        }

        this.length = array.length;
        mergeSort(array, 0, length);
        this.array = array;
    }

    public String[] getArray() {
        return array;
    }

    public int getLength() {
        return length;
    }

    protected void mergeSort(String[] array, int leftIncl, int rightExcl) {

        if (rightExcl <= leftIncl + 1) {
            return;
        }

        int middle = leftIncl + (rightExcl - leftIncl) / 2;

        mergeSort(array, leftIncl, middle);
        mergeSort(array, middle, rightExcl);

        merge(array, leftIncl, middle, rightExcl);
    }

    private void merge(String[] array, int left, int middle, int right) {
        String[] temp = new String[right - left];
        int l = left;
        int r = middle;
        int t = 0;

        while (l < middle && r < right) {
            LexSorter sorter = new LexSorter(array[l], array[r]);

            if (sorter.getResult().equals(array[r])) {
                temp[t++] = array[l++];
            } else {
                temp[t++] = array[r++];
            }
        }

        for (; l < middle; l++, t++) {
            temp[t] = array[l];
        }

        for (; r < right; r++, t++) {
            temp[t] = array[r];
        }

        System.arraycopy(temp, 0, array, left, temp.length);
    }
}
