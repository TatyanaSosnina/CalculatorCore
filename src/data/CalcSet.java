package data;

/**
 * Класс, определяющий набор частей для вычисления
 */
public class CalcSet {
    /**
     * Левая часть выражения
     */
    private Integer operand1;
    /**
     * Правая часть выражения
     */
    private Integer operand2;
    /**
     * Знак операции
     */
    private Character operator;

    /**
     * Конструктор
     * @param operand1 Левая часть выражения
     * @param operand2 Правая часть выражения
     * @param operator Знак операции
     */
    public CalcSet(Integer operand1, Integer operand2, Character operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    /**
     *
     * @return левая часть выражения
     */
    public Integer getOperand1() {
        return operand1;
    }

    /**
     *
     * @return правая часть выражения
     */
    public Integer getOperand2() {
        return operand2;
    }

    /**
     *
     * @return знак операции
     */
    public Character getOperator() {
        return operator;
    }

}
