package lc222ak_assign2;

public class FerryMain {
    public void main() throws Exception {
        SuperFerry myFerry = new SuperFerry();
        Car myCar = new Car(4);
        myFerry.embark(myCar);
        System.out.println(myFerry.countMoney());
        System.out.println(myFerry.countVehicleSpace());
    }
}