package sorter.data.lex;

public class LexSorter {
    private String result;

    public LexSorter(String string1, String string2) {
        int length1 = string1.length();
        int length2 = string2.length();
        boolean differenceFound = false;

        for (int index = 0; index < length1 && index < length2; index++) {
            char string1Char = string1.charAt(index);
            char string2Char = string2.charAt(index);
            if (string1Char != string2Char) {
                differenceFound = true;

                if (string1Char > string2Char) {
                    this.result = string1;
                } else {
                    this.result = string2;
                }

                break;
            }
        }

        if (!differenceFound) {
            if (length1 > length2) {
                this.result = string1;
            } else {
                this.result = string2;
            }
        }
    }

    public String getResult() {
        return result;
    }
}
