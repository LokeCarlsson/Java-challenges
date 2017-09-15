package lc222ak_assign2;

import java.util.ArrayList;

public class Lorry extends Vehicle {
    private ArrayList<Passenger> passengers;

    public Lorry(ArrayList<Passenger> passengers) throws Exception {
        if (passengers.size() > 2) {
            throw new Exception("A lorry can only carry two passengers");
        }
        this.passengers = passengers;
        fee = 300 + getSpace();
        space = 40;
    }

    private int getSpace() {
        int additionalFee = 0;
        for (Passenger ignored : passengers) {
            additionalFee += 15;
        }
        return additionalFee;
    }
}
