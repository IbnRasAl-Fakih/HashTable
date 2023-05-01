public class MyTestingClass {
    private String name; // name of star
    private double distance; // in this case distance measured in light years
    private double radius; // in this case radius measured in relation to the radius of the sun, R(sun) = 6,957⋅10^8 m

    public MyTestingClass(String name, double distance, double radius) {
        this.name = name;
        this.distance = distance;
        this.radius = radius;
    }

    @Override
    public int hashCode() {
        double res = name.hashCode();
        res = 31 * distance + res;
        res = 31 * radius + res;
        return (int) res;
    }

    @Override
    public String toString() {
        return name + ", the distance is " + distance + ", the radius is " + radius;
    }
}
