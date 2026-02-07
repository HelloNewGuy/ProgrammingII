package shapes;

public class Cylinder extends Shape {
    private double radius;
    private double height;

    // Parameterized constructor

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Surface area: 2πr² + 2πrh
    @Override
    public double surface_area() {
        return 2 * Math.PI * Math.pow(radius, 2) +
                2 * Math.PI * radius * height;
    }

    // Volume: πr²h
    @Override
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String toString() {
        return "Cylinder:\n" +
                "Radius: " + radius +
                "\nHeight: " + height +
                "\nSurface Area: " + surface_area() +
                "\nVolume: " + volume() + "\n";
    }
}