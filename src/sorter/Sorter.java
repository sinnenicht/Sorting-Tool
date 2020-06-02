package sorter;

import sorter.data.Data;

public class Sorter {
    private SortingMethod method;

    public void setMethod(SortingMethod method) {
        this.method = method;
    }

    public void sort(Data data, boolean hasFile) {
        this.method.sort(data, hasFile);
    }
}
