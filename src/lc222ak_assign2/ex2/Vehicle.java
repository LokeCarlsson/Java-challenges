package lc222ak_assign2.ex2;

import java.util.ArrayList;

class Vehicle {
    ArrayList<Passenger> passengers = new ArrayList<>();
    int space;
    int fee;

    /**
     * @param number - Number of passengers to add to the Vehicle
     */
    void addPassengers(int number) {
        if (number <= space) {
            for (int i = 0; i < number; i++) {
                passengers.add(new Passenger());
            }
        }
    }
}
