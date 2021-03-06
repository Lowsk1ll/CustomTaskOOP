import cars.TaxiCar;

import java.util.*;

public class TaxiStation {
    private List<? extends TaxiCar> cars;

    public TaxiStation sortByFuelConsumption(){
        Collections.sort(cars, (Comparator<TaxiCar>) (o1, o2) -> o1.getFuelConsumption()-o2.getFuelConsumption());
        return this;
    }
    public int getTaxiStationPrice(){
        int taxiStationPrice = 0;
        Iterator<? extends TaxiCar> iterator = cars.iterator();
        while (iterator.hasNext()){
            TaxiCar car = iterator.next();
            taxiStationPrice+=car.getPrice();
        }
        return taxiStationPrice;
    }

    public List<TaxiCar> getCarWithMaxSpeedRange(int LeftBorder, int RightBorder){
        List<TaxiCar> carsWithMaxSpeedRange = new ArrayList<>();
        for (TaxiCar car:cars) {
            if(car.getMaxSpeed()>LeftBorder && car.getMaxSpeed()<RightBorder){
                carsWithMaxSpeedRange.add(car);
            }
        }
        return carsWithMaxSpeedRange;
    }

    @Override
    public String toString() {
        return "Машины в таксопарке:\n" +
                 cars.toString();
    }

    public TaxiStation(List<? extends TaxiCar> cars) {
        this.cars = cars;
    }
}
