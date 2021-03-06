import cars.CarType;
import cars.Currency;
import cars.TaxiCar;
import cars.category.BusinessTaxiCar;
import cars.category.ComfortTaxiCar;
import cars.category.EconomyTaxiCar;
import cars.category.Order;
import cars.models.BusinessModels;
import cars.models.ComfortModels;
import cars.models.EconomyModels;

import java.util.Arrays;
import java.util.List;

public class Runner {
    static List<?extends TaxiCar> cars = Arrays.asList(
            new BusinessTaxiCar(10000, 20, 100, 200, 3, CarType.SEDAN, BusinessModels.BMW),
            new EconomyTaxiCar(10000, 30, 120, 190, 5, CarType.SEDAN, EconomyModels.SKODA),
            new ComfortTaxiCar(10000, 25, 110, 195, 4, CarType.HATCHBACK, ComfortModels.TOYOTA),
            new BusinessTaxiCar(15000, 10, 130, 205, 6, CarType.LIFTBACK, BusinessModels.AUDI)
    );

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        int LeftBorder = 199;
        int RightBorder = 210;
        TaxiStation taxiStation = new TaxiStation(cars);
        System.out.println("Стоимость таксопарка " + taxiStation.getTaxiStationPrice() + TaxiCar.class.getField("price").getAnnotation(Currency.class).currency());
        System.out.println("Сортировка автомобилей по расходу топлива: \n" + taxiStation.sortByFuelConsumption());
        System.out.println("Автомобили соответствующие диапозону скорости (" + LeftBorder + "," + RightBorder + ")\n" + taxiStation.getCarWithMaxSpeedRange(LeftBorder, RightBorder));//

//      пример с непроверяемым исключением
//      new EconomyTaxiCar(10000,30,120,190,5,CarType.SEDAN,EconomyModels.HYUNDAI);
//
//      пример с проверяемым исключением
//      Car exceptionCar =new EconomyTaxiCar(10000,30,120,190,6,CarType.SEDAN,EconomyModels.SKODA);
//      try {
//           exceptionCar.chanceOfBreakage();
//        }
//        catch (NotAvailableChanceOfBreakageException e){
//            e.printStackTrace();
//        }

//      реализация логики с перечесления
        TaxiCar carForShowEnumLogic = new BusinessTaxiCar(10000, 20, 100, 200, 3, CarType.SEDAN, BusinessModels.BMW);
        System.out.println("Максимальная количество клиентов за час для данного "+carForShowEnumLogic+carForShowEnumLogic.getCarType().maxClientsPerHour()+"\n");

//      внутренний класс
        BusinessTaxiCar.PremiumDriver  premiumDriver = new BusinessTaxiCar(15000, 10, 130, 205, 6, CarType.LIFTBACK, BusinessModels.AUDI).new PremiumDriver(3);
        premiumDriver.startWorking();


//       анонимные классы
        for (CarType car:CarType.values()) {
            System.out.println("для типа "+car+" максимальное количество клиентов за час = "+car.maxClientsPerHour());
        }
    }

}
