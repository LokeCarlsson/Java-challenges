package lc222ak_assign2;

class Lorry extends Vehicle {
    Lorry(int numberOfPassengers) throws Exception {
        if (numberOfPassengers > 2) {
            throw new Exception("A lorry can only carry two passengers");
        }
        fee = 300 + additionalFee(numberOfPassengers);
        space = 40;
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
