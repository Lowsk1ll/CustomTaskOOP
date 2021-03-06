package cars.category;
import cars.TaxiCar;
import cars.models.*;
import exceptions.ModelNotAvailableException;
import exceptions.NotAvailableChanceOfBreakageException;

import java.util.Objects;

public class EconomyTaxiCar extends TaxiCar {

    private EconomyModels economyModel;

    public EconomyTaxiCar(int price, int fuelConsumption, int horsepower, int maxSpeed, int age, cars.CarType carType, EconomyModels economyModel) {
        super(price, fuelConsumption, horsepower, maxSpeed, age, carType);
        this.economyModel = economyModel;
        if (economyModel== EconomyModels.HYUNDAI){
            throw new ModelNotAvailableException();
        }
    }

    public EconomyModels getEconomyModel() {
        return economyModel;
    }

    @Override
    public String toString() {
        return "Авто эконом класса (" +
                "Модель " + economyModel +" "+
                super.toString();
    }

    @Override
    public double chanceOfBreakage() throws NotAvailableChanceOfBreakageException {
        if(getAge()>5){
            throw new NotAvailableChanceOfBreakageException();
        }
        return getAge();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EconomyTaxiCar that = (EconomyTaxiCar) o;
        return getEconomyModel() == that.getEconomyModel();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEconomyModel());
    }
}
