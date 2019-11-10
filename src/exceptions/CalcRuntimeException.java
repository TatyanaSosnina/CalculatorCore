package exceptions;

/**
 * Общее исключение для необрабатываемых ситуаций приложения калькулятор
 */
class CalcRuntimeException extends RuntimeException {

    protected CalcRuntimeException(String message) {
        super("Выполнение программы невозможно из-за некорректных входных данных. " + message);
    }
}

