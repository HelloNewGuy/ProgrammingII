package shapes;

public class Sphere extends Shape {

    private double radius;

    // Parameterized constructor
    public Sphere(double radius) {
        this.radius = radius;
    }

    // Compute surface area: 4πr²
    @Override
    public double surface_area() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    // Compute volume: (4/3)πr³
    @Override
    public double volume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String toString() {
        return "Sphere:\n" +
                "Radius: " + radius +
                "\nSurface Area: " + surface_area() +
                "\nVolume: " + volume() + "\n";
    }
}