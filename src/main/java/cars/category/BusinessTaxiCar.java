package cars.category;

import cars.TaxiCar;
import cars.models.BusinessModels;
import exceptions.NotAvailableChanceOfBreakageException;

import javax.xml.bind.annotation.XmlAccessorOrder;
import java.util.Objects;

public class BusinessTaxiCar extends TaxiCar {
    private BusinessModels businessModel;
    public class  PremiumDriver{
        private int drivingExperience;
        @Order(id = 3)
        public void startWorking() throws NoSuchMethodException {
            if (PremiumDriver.class.getMethod("startWorking").isAnnotationPresent(Order.class)){
                System.out.println("Водитель начинает работу c заказа id:"+PremiumDriver.class.getMethod("startWorking").getAnnotation(Order.class).id() +" на "+BusinessTaxiCar.this.toString());
            }
            System.out.println("Водитель начинает работу на "+BusinessTaxiCar.this.toString());
        }
        public PremiumDriver(int drivingExperience){
            this.drivingExperience = drivingExperience;
        }
    }


    public BusinessTaxiCar(int price, int fuelConsumption, int horsepower, int maxSpeed, int age, cars.CarType carType, BusinessModels businessModel) {
        super(price, fuelConsumption, horsepower, maxSpeed, age, carType);
        this.businessModel = businessModel;


    }

    public BusinessModels getBusinessModel() {
        return businessModel;
    }

    @Override
    public String toString() {
        return "Авто бизнес класса (" +
                "Модель " + businessModel +" "+
                super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BusinessTaxiCar that = (BusinessTaxiCar) o;
        return getBusinessModel() == that.getBusinessModel();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBusinessModel());
    }

    @Override
    public double chanceOfBreakage() throws NotAvailableChanceOfBreakageException {
        if (getAge()*0.25>4){
            throw new NotAvailableChanceOfBreakageException();
        }
        return getAge()*0.25;
    }
}
