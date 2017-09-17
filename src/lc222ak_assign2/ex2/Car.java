package lc222ak_assign2.ex2;

class Car extends Vehicle {
    Car(int numberOfPassengers) throws Exception {
        if (numberOfPassengers > 4) {
            throw new Exception("A car can only carry four passengers");
        }
        this.fee = 100 + additionalFee(numberOfPassengers);
        this.space = 5;
        addPassengers(numberOfPassengers);
    }

    private int additionalFee(int number) {
        int additionalFee = 0;
        for (int i = 0; i < number; i++) {
            additionalFee += 15;
        }
        return additionalFee;
    }
}
