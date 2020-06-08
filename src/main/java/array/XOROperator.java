package array;

public class XOROperator {
    public static void main(String[] args) {

        Car car = new Car();
        isManualAndDiesel(car);
    }

    private static boolean isManualAndDiesel(Car car) {
//        return (car.isDiesel() && !car.isManual()) || (!car.isDiesel() && car.isManual());
        return car.isDiesel() ^ car.isManual();
    }
}

class Car {
    public boolean isDiesel() {
        return false;
    }

    public boolean isManual() {
        return false;
    }
}
