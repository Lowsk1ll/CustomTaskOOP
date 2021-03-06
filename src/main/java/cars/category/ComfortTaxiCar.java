package cars.category;

import cars.TaxiCar;
import cars.models.ComfortModels;
import exceptions.ModelNotAvailableException;
import exceptions.NotAvailableChanceOfBreakageException;

import java.util.Objects;

public class ComfortTaxiCar extends TaxiCar {
    private ComfortModels comfortModel;

    public ComfortTaxiCar(int price, int fuelConsumption, int horsepower, int maxSpeed, int age, cars.CarType carType, ComfortModels comfortModel) {
        super(price, fuelConsumption, horsepower, maxSpeed, age, carType);
        this.comfortModel = comfortModel;
        if(comfortModel== ComfortModels.KIA){
            throw new ModelNotAvailableException();
        }
    }

    public ComfortModels getComfortModel() {
        return comfortModel;
    }

    @Override
    public String toString() {
        return "Авто комфорт класса (" +
                "Модель " + comfortModel +" "+
                super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComfortTaxiCar that = (ComfortTaxiCar) o;
        return getComfortModel() == that.getComfortModel();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getComfortModel());
    }

    @Override
    public double chanceOfBreakage() throws NotAvailableChanceOfBreakageException {
        if(getAge()*0.5>6){
            throw new NotAvailableChanceOfBreakageException();
        }
        return getAge()*0.5;
    }
}
