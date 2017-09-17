package lc222ak_assign2.ex2;


class Bus extends Vehicle {
    Bus(int numberOfPassengers) throws Exception {
        if (numberOfPassengers > 20) {
            throw new Exception("A bus can only carry 20 passengers");
        }
        addPassengers(numberOfPassengers);
        fee = 200 + additionalFee(numberOfPassengers);
        space = 20;
    }

    private int additionalFee(int number) {
        int additionalFee = 0;
        for (int i = 0; i < number; i++) {
            additionalFee += 10;
        }
        return additionalFee;
    }
}
