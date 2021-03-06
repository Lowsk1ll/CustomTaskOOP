package cars;

import java.lang.reflect.Field;
import java.nio.file.NoSuchFileException;
import java.util.Objects;

abstract public class TaxiCar implements Car {
    @Currency
    public final int price;
    private final int fuelConsumption;
    private final int horsepower;
    private final int maxSpeed;
    private final int age;
    private final cars.CarType CarType;

    public TaxiCar(int Price, int fuelConsumption, int horsepower, int maxSpeed, int age, CarType carType) {
        this.price = Price;
        this.fuelConsumption = fuelConsumption;
        this.horsepower = horsepower;
        this.maxSpeed = maxSpeed;
        this.age = age;
        this.CarType = carType;
    }

    public int getPrice() {
        return price;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getAge() {
        return age;
    }

    public cars.CarType getCarType() {
        return CarType;
    }

    

    @Override
    public String toString() {

        try {
            return "price=" + price + TaxiCar.class.getField("price").getAnnotation(Currency.class).currency()+
                    ", fuelConsumption=" + fuelConsumption +
                    ", horsepower=" + horsepower +
                    ", maxSpeed=" + maxSpeed +
                    ", age=" + age +
                    ", carType=" + CarType +
                    ")\n";
        } catch (NoSuchFieldException e) {
            return e.getMessage();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxiCar taxiCar = (TaxiCar) o;
        return getPrice() == taxiCar.getPrice() &&
                getFuelConsumption() == taxiCar.getFuelConsumption() &&
                getHorsepower() == taxiCar.getHorsepower() &&
                getMaxSpeed() == taxiCar.getMaxSpeed() &&
                getAge() == taxiCar.getAge() &&
                getCarType() == taxiCar.getCarType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice(), getFuelConsumption(), getHorsepower(), getMaxSpeed(), getAge(), getCarType());
    }
    
}
