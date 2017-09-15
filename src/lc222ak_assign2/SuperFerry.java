package lc222ak_assign2;

import java.util.Iterator;

public class SuperFerry implements Ferry {

    private int passangerSpace = 200;
    private int carSpace = 50;

    public int countPassengers() {
        return 0;
    }

    public int countVehicleSpace() {
        return 0;
    }

    public int countMoney() {
        return 0;
    }

    public void embark(Vehicle v) {

    }

    public void embark(Passenger p) {

    }

    public void disembark() {

    }

    public boolean hasSpaceFor(Vehicle v) {
        return false;
    }

    public boolean hasRoomFor(Passenger p) {
        return false;
    }

    public Iterator<Vehicle> iterator() {
        return null;
    }
}
