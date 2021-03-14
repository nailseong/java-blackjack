package rent.car;

public class K5 extends Car {

    private static final String NAME = "K5";
    private static final double DISTANCE_PER_LITER = 13;

    public K5(double distance) {
        super(distance);
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    public String getName() {
        return NAME;
    }
}