package utils;

import converter.Converter;
import data.CalcSet;
import exceptions.CalcNotValidDataRuntimeException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * класс с методами для проверки корректности и получения набора для рассчета
 */
public final class Ulils {
    /**
     * Приватный конструктор
     */
    private Ulils() {
    }

    /**
     * Признак - является число арабским или римским
     */
    private static Boolean isRoman = true;

    /**
     * Метод для получения оператора
     * @param str
     * @return
     */
    public static char makeOperation(String str) {

        if(str.isEmpty()){
            throw new CalcNotValidDataRuntimeException("Оператор отсутствует");
        }

        if(str.length() > 1){
            throw new CalcNotValidDataRuntimeException("Введено более 1 символа для оператора");
        }

        Character operator = str.charAt(0);

        for (OperatorType ot : OperatorType.values()) {
            Character operatorType = ot.getOperator();

            if (operator.equals(operatorType)) {
                return ot.getOperator();
            }
        }
        throw new CalcNotValidDataRuntimeException("Введеный оператор не является одним из разрешенных +, -, * или /");
    }

    /**
     * Метод для получения операнда
     * @param str
     * @return
     */
    public static Integer makeOperand(String str) {
        if (str.isEmpty()) {
            throw new CalcNotValidDataRuntimeException("Операнд отсутствтует");
        }

        Integer operand = null;
        // преобразование в число
        if(isRoman){
            operand = Converter.convertRomanToArabic(str);
        }
        else {
            try {
                operand = Integer.parseInt(str);
            } catch (Exception e) {
                throw new CalcNotValidDataRuntimeException("Введен неверный операнд");
            }
        }
        //проверка на величину
        if (operand < 1 || operand > 10) {
            throw new CalcNotValidDataRuntimeException("Введен операнд вне диапазона от 1 до 10 включительно!");
        }
        return operand;
    }

    /**
     * Метод для вычисления результата
     * @param set4Calculate
     * @return
     */
//    public static final Integer calculate(CalcSet set4Calculate) { ////
    public static final Integer calculate(CalcSet set4Calculate) {

        char operation = set4Calculate.getOperator();
        Integer res = null;

        switch (operation) {
            case '+': {
                res = set4Calculate.getOperand1() + set4Calculate.getOperand2();
                break;
            }
            case '-': {
                res = set4Calculate.getOperand1() - set4Calculate.getOperand2();
                break;
            }
            case '*': {
                res = set4Calculate.getOperand1() * set4Calculate.getOperand2();
                break;
            }
            case '/': {
                res = set4Calculate.getOperand1() / set4Calculate.getOperand2();
                break;
            }
        }
        return res;
    }

    /**
     * Метод для запроса входной строки
     * @return
     * @throws IOException
     */
    public final static String askData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Input:");
            String inputStr = reader.readLine();
            if (!inputStr.isEmpty()) {
                reader.close();
                return inputStr;
            }
        }
    }

    /**
     * Метод получения набора данных для рассчета
     * @return
     */
    public final static CalcSet makeParts() {

        String inputStr = null;
        try {
            inputStr = askData();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при вводе данных " + e);
        }

        String operand1Str, operand2Str, operatorStr;
        String[] parts = null;
        try {
            parts = inputStr.split(" ");
            operand1Str = parts[0];
            operatorStr = parts[1];
            operand2Str = parts[2];
        }
        catch (Exception e){
            throw new CalcNotValidDataRuntimeException("Строка не соответствует формату примера задания. " + e);
        }

        //получение оператора с проверкой
        Character operator = makeOperation(operatorStr);

        //получение частей выражения с проверкой
        int isRomanOperand1 = 0, isRomanOperand2 = 0;
        Boolean isRoman1, isRoman2;

        isRomanOperand1 = Converter.convertRomanToArabic(operand1Str);
        isRoman1 = isRomanOperand1 != 0 ? true : false;

        isRomanOperand2 = Converter.convertRomanToArabic(operand2Str);
        isRoman2 = isRomanOperand2 != 0 ? true : false;

        if(!isRoman1.equals(isRoman2)){
            throw new CalcNotValidDataRuntimeException("Части выражения введены не в едином стиле. Калькулятор умеет работать только с арабскими или римскими цифрами одновременно");
        }

        isRoman = isRoman1;

        Integer operand1 = makeOperand(operand1Str);
        Integer operand2 = makeOperand(operand2Str);

        return new CalcSet(operand1, operand2, operator);
    }

    /**
     * Метод запуска вычисления
     */
    public static final void go() {
        CalcSet set4Calculate = makeParts();
        Integer result = calculate(set4Calculate);
        System.out.println("Output:");
        System.out.println(isRoman ? Converter.convertArabicToRoman(result) : result);
    }

}
