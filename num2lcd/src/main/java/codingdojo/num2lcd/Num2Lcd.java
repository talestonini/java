package codingdojo.num2lcd;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Num2Lcd {

    private static final Map<Character, String[]> DIGIT_MAP = new HashMap<>();

    static {
        DIGIT_MAP.put('0', new String[]{" _ ", "| |", "|_|"});
        DIGIT_MAP.put('1', new String[]{"   ", "  |", "  |"});
        DIGIT_MAP.put('2', new String[]{" _ ", " _|", "|_ "});
        DIGIT_MAP.put('3', new String[]{" _ ", " _|", " _|"});
        DIGIT_MAP.put('4', new String[]{"   ", "|_|", "  |"});
        DIGIT_MAP.put('5', new String[]{" _ ", "|_ ", " _|"});
        DIGIT_MAP.put('6', new String[]{" _ ", "|_ ", "|_|"});
        DIGIT_MAP.put('7', new String[]{" _ ", "  |", "  |"});
        DIGIT_MAP.put('8', new String[]{" _ ", "|_|", "|_|"});
        DIGIT_MAP.put('9', new String[]{" _ ", "|_|", " _|"});
    }

    public static String num2Lcd(int num) {
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        StringBuilder line3 = new StringBuilder();

        for (char c : num2Digits(num).toCharArray()) {
            String[] digitLines = DIGIT_MAP.get(c);
            line1.append(digitLines[0]).append(' ');
            line2.append(digitLines[1]).append(' ');
            line3.append(digitLines[2]).append(' ');
        }

        return line1.toString() + "\n" + line2.toString() + "\n" + line3.toString();
    }

    private static String num2Digits(int num) {
        Stack<Character> stack = new Stack<>();
        while (num > 0) {
            int remain = num % 10;
            stack.push(Character.forDigit(remain, 10));
            num /= 10;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Num2Lcd.num2Lcd(1234567890));
    }
}
