package exceptions;

public class ModelNotAvailableException extends RuntimeException{
    public ModelNotAvailableException() {
        super("Эта модель недоступна в данный момент");
    }
}
