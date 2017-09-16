package lc222ak_assign2;

public class FerryMain {
    public void main() throws Exception {
        SuperFerry myFerry = new SuperFerry();
        Car myCar = new Car(3);
        Bus bus = new Bus(20);
        Bicycle bike = new Bicycle();
        Passenger pass = new Passenger();
        Lorry lorry = new Lorry(2);
        for (int i = 0; i < 200; i++) {
            myFerry.embark(myCar);
        }
            System.out.println("money: " + myFerry.countMoney());
            System.out.println("space: " + myFerry.countVehicleSpace());
            System.out.println("passengers: " + myFerry.countPassengers());
    }
}