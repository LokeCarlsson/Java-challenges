package lc222ak_assign2;

import java.util.ArrayList;

public class Bus extends Vehicle {
    private final int fee = 200 + getSpace();
    private final int space = 20;
    private ArrayList<Passenger> passengers;

    public Bus(ArrayList<Passenger> passengers) throws Exception {
        if (passengers.size() > 20) {
            throw new Exception("A bus can only carry 20 passengers");
        }
        this.passengers = passengers;
    }

    private int getSpace() {
        int additionalFee = 0;
        for (Passenger ignored : passengers) {
            additionalFee += 5;
        }
        return additionalFee;
    }
}
