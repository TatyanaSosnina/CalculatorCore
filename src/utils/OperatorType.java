package utils;

/**
 * Класс - перечисление операций, производимых приложением калькулятор
 */
public enum OperatorType {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    /**
     * знак операции
     */
    private Character operator;

    /**
     * Конструктор
     *
     * @param operator
     */
    private OperatorType(Character operator) {
        this.operator = operator;
    }

    /**
     * Метод для получения знака операции
     *
     * @return знак операции
     */
    public char getOperator() {
        return this.operator;
    }
}
