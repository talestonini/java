package codingdojo.romannums;

import java.util.LinkedHashMap;
import java.util.Map;

public class Converter {

    private static final Map<Integer, String> BANDS = new LinkedHashMap<>();

    static {
        BANDS.put(1000, "M--");
        BANDS.put(100, "CDM");
        BANDS.put(10, "XLC");
        BANDS.put(1, "IVX");
    }

    public static String toRomanNumeral(int num) {
        if (num <= 0 || num > 3000) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int o : BANDS.keySet()) {
            String band = BANDS.get(o);
            char lowerLetter = band.charAt(0);
            char middleLetter = band.charAt(1);
            char higherLetter = band.charAt(2);
            int q = num / o;
            switch (q) {
                case 9:
                    sb.append(lowerLetter);
                    sb.append(higherLetter);
                    break;
                case 8:
                case 7:
                case 6:
                    sb.append(middleLetter);
                    sb.append(timesLetter(q - 5, lowerLetter));
                    break;
                case 5:
                    sb.append(middleLetter);
                    break;
                case 4:
                    sb.append(lowerLetter);
                    sb.append(middleLetter);
                    break;
                case 3:
                case 2:
                case 1:
                    sb.append(timesLetter(q, lowerLetter));
            }
            num -= q * o;
        }

        return sb.toString();
    }

    private static String timesLetter(int times, char letter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(letter);
        }
        return sb.toString();
    }
}
