package exceptions;

/**
 * Общее исключение для необрабатываемых ситуаций приложения калькулятор
 */
public class CalcRuntimeException extends RuntimeException {

    public CalcRuntimeException(String message) {
        super("Выполнение программы невозможно из-за некорректных входных данных. " + message);
    }
}

