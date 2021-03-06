package cars;

public enum CarType {
    SEDAN(3){
        @Override
        public int maxClientsPerHour(){return capacity*5;}
    }, HATCHBACK(4){
        @Override
        public int maxClientsPerHour(){return capacity*3;}
    }, STATION_WAGON(5){
        @Override
        public int maxClientsPerHour(){return capacity*4;}
    }, LIFTBACK(3){
        @Override
        public int maxClientsPerHour(){return capacity*6;}
    };
    public int capacity;
    CarType(int capacity){
        this.capacity=capacity;
    }
    public abstract int maxClientsPerHour();
}
