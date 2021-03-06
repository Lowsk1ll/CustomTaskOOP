package cars;


import exceptions.NotAvailableChanceOfBreakageException;

public interface Car {
    double chanceOfBreakage() throws NotAvailableChanceOfBreakageException;
}
