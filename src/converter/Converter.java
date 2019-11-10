package converter;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Класс для преобразования арабских чисел в римские и наоборот
 */
public final class Converter {
    /**
     * Конструктор
     */
    private Converter() {
    }

    /**
     * Карта соответствия арабское число - римское для минимально необходимого набора
     * максимально возможный по условию задачи результат - 10 * 10
     */
    private static final NavigableMap<Integer, String> units;

    static {
        NavigableMap<Integer, String> initMap = new TreeMap<>();
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");
        units = Collections.unmodifiableNavigableMap(initMap);
    }

    /**
     * Метод для преобразования римских чисел в арабские
     *
     * @param romanNumberStr входной параметр - римское число в виде строки
     * @return результат - целое арабское число
     */
    public static final int convertRomanToArabic(String romanNumberStr) {
        int result = 0;
        int pos = 0;
        for (Integer key : units.descendingKeySet()) {
            while ((romanNumberStr.substring(pos)).length() >= units.get(key).length()) {
                if (units.get(key).equals(romanNumberStr.substring(pos, pos + units.get(key).length()))) {
                    result += key;
                    pos += units.get(key).length();
                } else {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод для преобразования арабских чисел в римские
     *
     * @param arabicNumber входной параметр - арабское число
     * @return результат - римское число в виде строки
     */
    public static final String convertArabicToRoman(int arabicNumber) {
        if (arabicNumber == 0) return "nulla";
        if (arabicNumber < 0) return "В Римской системе счисления отсутствуют отрицательные числа";
        StringBuilder result = new StringBuilder();

        for (Integer key : units.descendingKeySet()) {
            while (arabicNumber >= key) {
                arabicNumber -= key;
                result.append(units.get(key));
            }
        }
        return result.toString();
    }
}