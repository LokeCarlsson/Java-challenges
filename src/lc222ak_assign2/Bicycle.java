package lc222ak_assign2;

import java.util.ArrayList;

public class Bicycle extends Vehicle {
    private ArrayList<Passenger> passengers;

    public Bicycle(ArrayList<Passenger> passengers) throws Exception {
        if (passengers.size() > 1) {
            throw new Exception("A bicycle can only carry one passengers");
        }
        this.passengers = passengers;
        fee = 50;
        space = 1;
    }
}
