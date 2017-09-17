package lc222ak_assign2.ex2;

public class FerryMain {
    public void main() throws Exception {
        SuperFerry myFerry = new SuperFerry();
        Bus bus = new Bus(20);
        Bicycle bike = new Bicycle();
        Passenger pass = new Passenger();
        Lorry lorry = new Lorry(2);
        for (int i = 0; i < 200; i++) {
            Car myCar = new Car(3);
            myFerry.embark(myCar);
        }
            System.out.println("money: " + myFerry.countMoney());
            System.out.println("space: " + myFerry.countVehicleSpace());
            System.out.println("passengers: " + myFerry.countPassengers());
    }
}