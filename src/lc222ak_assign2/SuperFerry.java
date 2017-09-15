package lc222ak_assign2;

import java.util.ArrayList;
import java.util.Iterator;

public class SuperFerry implements Ferry {

    private ArrayList<Passenger> currentPassengers = new ArrayList<>();
    private ArrayList<Vehicle> currentVehicles = new ArrayList<>();
    private int currentMoney;

    public int countPassengers() {
        int amount = 0;
        for (Passenger ignored : currentPassengers) {
            amount++;
        }
        return amount;
    }

    public int countVehicleSpace() {
        int amount = 0;
        for (Vehicle ignored : currentVehicles) {
            amount++;
        }
        return amount;
    }

    public int countMoney() {
        return currentMoney;
    }

    public void embark(Vehicle v) {
        try {
            for (Passenger p : v.passengers) {
                if (!hasRoomFor(p)) {
                    throw new Exception("The ferry does not have room for more passengers");
                }
            }
            if (!hasSpaceFor(v)) {
                throw new Exception("The ferry does not have room for more Vehicles");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        currentPassengers.addAll(v.passengers);
        currentVehicles.add(v);
        currentMoney += v.fee;
    }

    public void embark(Passenger p) {
        try {
            if (!hasRoomFor(p)) {
                throw new Exception("The ferry does not have room for more passengers");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        currentPassengers.add(p);
        currentMoney += p.fee;
    }

    public void disembark() {
        currentVehicles.clear();
        currentPassengers.clear();
    }

    public boolean hasSpaceFor(Vehicle v) {
        int space = 0;
        for (Vehicle ignored : currentVehicles) {
            space ++;
        }
        return space < 250;
    }

    public boolean hasRoomFor(Passenger p) {
        int space = 0;
        for (Passenger ignored : currentPassengers) {
            space ++;
        }
        return space < 200;
    }

    public Iterator<Vehicle> iterator() {
        return new VehicleIterator();
    }

    class VehicleIterator implements Iterator<Vehicle> {
        private int count = 0;
        public boolean hasNext() {
            return count < currentVehicles.size();
        }

        public Vehicle next() {
            return currentVehicles.get(count);
        }
    }
}