package sorter.data.num;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LongNaturalSort {
    private final long[] array;
    private final int length;

    public LongNaturalSort(Longs longs) {
        this.length = longs.getLength();
        long[] array = longs.getArray();
        mergeSort(array, 0, length);
        this.array = array;
    }

    public LongNaturalSort(Map<Long, Integer> map, int numTimes) {
        List<Long> arrayList = new ArrayList<>();

        for (var entry : map.entrySet()) {
            if (entry.getValue() == numTimes) {
                arrayList.add(entry.getKey());
            }
        }

        long[] array = new long[arrayList.size()];
        int index = 0;

        for (var entry : arrayList) {
            array[index++] = entry;
        }

        this.length = array.length;
        mergeSort(array, 0, length);
        this.array = array;
    }

    public long[] getArray() {
        return array;
    }

    public int getLength() {
        return length;
    }

    public void printToConsole() {
        System.out.println("Total numbers: " + length);
        System.out.print("Sorted data: ");

        for (int index = 0; index < length; index++) {
            System.out.print(array[index] + " ");
        }
    }

    public void printToFile(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Total numbers: " + length);
            writer.print("Sorted data: ");

            for (int index = 0; index < length; index++) {
                writer.print(array[index] + " ");
            }
        } catch (IOException e) {
            System.out.println("An exception occurs " + e.getMessage());
        }
    }

    private void mergeSort(long[] array, int leftIncl, int rightExcl) {
        if (rightExcl <= leftIncl + 1) {
            return;
        }

        int middle = leftIncl + (rightExcl - leftIncl) / 2;

        mergeSort(array, leftIncl, middle);
        mergeSort(array, middle, rightExcl);

        merge(array, leftIncl, middle, rightExcl);
    }

    private void merge(long[] array, int left, int middle, int right) {
        long[] temp = new long[right - left];
        int l = left;
        int r = middle;
        int t = 0;

        while (l < middle && r < right) {
            if (array[l] <= array[r]) {
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
