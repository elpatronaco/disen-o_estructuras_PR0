package edu.uoc.ds.adt;

public class PR0CypherCaesarArray {
    private char[] charArr;
    private final Tuple lowerCases = new Tuple(97, 122);
    private final Tuple upperCases = new Tuple(65, 90);

    PR0CypherCaesarArray(String str) {
        init(str);
    }

    private void init(String str) {
        charArr = str.toCharArray();
    }

    private boolean isBetween(int value, Tuple tuple) {
        return value >= tuple.start && value <= tuple.end;
    }

    public static char shiftChar(char c, int rightShift, Tuple tuple) {
        final var start = tuple.start;
        final var end = tuple.end;

        var finalShift = rightShift % 26;

        if (finalShift == 0) return c;

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

            if (isBetween(ascii, lowerCases)) {
                shiftedArr[i] = shiftChar(c, rightShift, lowerCases);
            } else if (isBetween(ascii, upperCases)) {
                shiftedArr[i] = shiftChar(c, rightShift, upperCases);
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
