package codingdojo.wordwrap;

public class Wrapper {

    public static String wrap(String text, int col) {
        if (text.length() <= col) {
            return text;
        } else {
            int newLinePos = -1;
            int readPos = 0;
            int whitespacePos = -1;
            while (newLinePos == -1 && readPos <= col && readPos < text.length()) {
                char readChar = text.charAt(readPos);
                if (readChar == '\n') {
                    newLinePos = readPos;
                } else if (readChar == ' ') {
                    whitespacePos = readPos;
                }
                readPos++;
            }
            if (newLinePos > -1) {
                // write text before new line, and then wrap the rest
                int wrapPos = newLinePos + 1;
                return rtrim(text.substring(0, wrapPos))
                        + wrap(ltrim(text.substring(wrapPos)), col);
            } else {
                // write text before last whitespace before col
                // (or col if whole line contain word longer than col),
                // then write a wrapping new line char, and then wrap the rest
                int wrapPos = whitespacePos > -1 ? whitespacePos : col;
                return rtrim(text.substring(0, wrapPos))
                        + '\n'
                        + wrap(ltrim(text.substring(wrapPos)), col);
            }
        }
    }

    /* String.trim() trims new lines. We do't want that. */

    private static String ltrim(String text) {
        return !text.isEmpty() && text.charAt(0) == ' ' ?
                ltrim(text.substring(1)) : text;
    }

    private static String rtrim(String text) {
        return !text.isEmpty() && text.charAt(text.length() - 1) == ' ' ?
                rtrim(text.substring(0, text.length() - 1)) : text;
    }

}
