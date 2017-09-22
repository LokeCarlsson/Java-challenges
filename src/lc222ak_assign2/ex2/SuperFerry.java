package lc222ak_assign2.ex2;

import java.util.ArrayList;
import java.util.Iterator;

public class SuperFerry implements Ferry {

    private ArrayList<Passenger> currentPassengers = new ArrayList<>();
    private ArrayList<Vehicle> currentVehicles = new ArrayList<>();
    private int currentMoney;

    /**
     * @return - The number of passengers in the ferry
     */
    public int countPassengers() {
        int amount = 0;
        for (Passenger ignored : currentPassengers) {
            amount++;
        }
        return amount;
    }

    /**
     * @return - Number of vehicle space that has been taken
     */
    public int countVehicleSpace() {
        int amount = 0;
        for (Vehicle v : currentVehicles) {
            amount += v.space;
        }
        return amount;
    }

    /**
     * @return - The number of money collected
     */
    public int countMoney() {
        return currentMoney;
    }

    /**
     * @param v - Vehicle to be embarked to the ferry
     */
    public void embark(Vehicle v) {
        try {
            if (currentVehicles.contains(v)) {
                throw new Exception("That passenger has already been embarked!");
            }
            if (!hasSpaceFor(v)) {
                throw new Exception("The ferry does not have room for more Vehicles");
            }
            for (Passenger p : v.passengers) {
                if (currentPassengers.contains(p)) {
                    throw new Exception("That passenger has already been embarked!");
                }
                if (!hasRoomFor(p)) {
                    throw new Exception("The ferry does not have room for more passengers");
                }
                currentPassengers.add(p);
            }
            currentVehicles.add(v);
            currentMoney += v.fee;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param p - Passenger to be embarked to the ferry
     */
    public void embark(Passenger p) {
        try {
            if (!hasRoomFor(p)) {
                throw new Exception("The ferry does not have room for more passengers");
            }
            if (currentPassengers.contains(p)) {
                throw new Exception("That passenger has already been embarked!");
            }
            currentPassengers.add(p);
            currentMoney += p.fee;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Clears all Vehicles and Passengers from the ferry
     */
    public void disembark() {
        currentVehicles.clear();
        currentPassengers.clear();
    }

    /**
     * @param v - Vehicle to check if has room for
     * @return - True if there is room, false if otherwise
     */
    public boolean hasSpaceFor(Vehicle v) {
        int space = 0;
        for (Vehicle vehicle : currentVehicles) {
            space += vehicle.space;
        }
        return  space + v.space <= 250;
    }

    /**
     * @param p - Passenger to check if has room for
     * @return - True if there is room, false if otherwise
     */
    public boolean hasRoomFor(Passenger p) {
        int space = 0;
        for (Passenger passenger : currentPassengers) {
            space += passenger.space;
        }
        return space + p.space <= 200;
    }

    /**
     * @return - String with various information of the ferry
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Ferry information: ").append("\n");
        string.append("Amount of vehicles: ").append(countVehicleSpace()).append("\n");
        string.append("Amount of passengers: ").append(countPassengers()).append("\n");
        string.append("Vehicle space left: ").append(250 - countVehicleSpace()).append("\n");
        string.append("Passenger space left: ").append(200 - countPassengers()).append("\n");
        string.append("Earned money: ").append(countMoney()).append("kr");
        return String.valueOf(string);
    }

    /**
     * @return - A new instance of the Iterator
     */
    public Iterator<Vehicle> iterator() {
        return new VehicleIterator();
    }

    class VehicleIterator implements Iterator<Vehicle> {
        private int count = 0;

        /**
         * @return - True if there is a next Vehicle
         */
        public boolean hasNext() {
            return count < currentVehicles.size();
        }

        /**
         * @return - Next Vehicle in the ferry
         */
        public Vehicle next() {
            return currentVehicles.get(count);
        }
    }
}