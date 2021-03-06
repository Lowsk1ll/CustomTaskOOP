package exceptions;

public class NotAvailableChanceOfBreakageException extends Exception{
    public NotAvailableChanceOfBreakageException(){
        super("шанс поломки выше нормы");
    }
}
