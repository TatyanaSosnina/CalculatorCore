package exceptions;

/**
 * Класс исключений, возникновение которых возможно в процессе работы приложения калькулятор
 */
public class CalcNotValidDataRuntimeException extends CalcRuntimeException {
    public CalcNotValidDataRuntimeException(String message) {
        super(message);
    }
}


