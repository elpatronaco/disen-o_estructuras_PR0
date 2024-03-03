package edu.uoc.ds.adt;

public class PR0CypherCaesarArray {
    private char[] charArr;

    public static final int alphabetLength = 26;
    public static final int lowerCaseStart = 97;
    public static final int lowerCaseEnd = lowerCaseStart + alphabetLength - 1;
    public static final int upperCaseStart = 65;
    public static final int upperCaseEnd = upperCaseStart + alphabetLength - 1;

    PR0CypherCaesarArray(String str) {
        init(str);
    }

    private void init(String str) {
        charArr = str.toCharArray();
    }

    private boolean isBetween(int value, int start, int end) {
        return value >= start && value <= end;
    }

    public static char shiftChar(char c, int rightShift, int start, int end) {
        var finalShift = rightShift % alphabetLength;

        if (finalShift == 0)
            return c;

        var ascii = (int) c;
        var shiftedAscii = ascii + finalShift;

        if (shiftedAscii > end) {
            return (char) (start + (shiftedAscii - end - 1));
        }

        return (char) shiftedAscii;
    }

    private char[] shift(int rightShift) {
        var len = charArr.length;
        var shiftedArr = new char[len];

        for (var i = 0; i < len; i++) {
            char c = charArr[i];
            var ascii = (int) c;

            if (isBetween(ascii, lowerCaseStart, lowerCaseEnd)) {
                shiftedArr[i] = shiftChar(c, rightShift, lowerCaseStart, lowerCaseEnd);
            } else if (isBetween(ascii, upperCaseStart, upperCaseEnd)) {
                shiftedArr[i] = shiftChar(c, rightShift, upperCaseStart, upperCaseEnd);
            } else {
                shiftedArr[i] = c;
            }
        }

        return shiftedArr;
    }

    public char[] cypher2Array(int rightShift) {
        return shift(rightShift);
    }

    public String cypher(int rightShift) {
        return String.valueOf(shift(rightShift));
    }
}
