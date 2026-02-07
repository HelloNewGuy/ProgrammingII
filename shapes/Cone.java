package shapes;

public class Cone extends Shape{

    private double radius;
    private double height;

    // Parameterized constructor
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Surface area: πr(r + √(h² + r²))
    @Override
    public double surface_area() {
        double slantHeight = Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2));
        return Math.PI * radius * (radius + slantHeight);
    }

    // Volume: (1/3)πr²h
    @Override
    public double volume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(radius , 2) * height;
    }

    @Override
    public String toString() {
        return "Cone:\n" +
                "Radius: " + radius +
                "\nHeight: " + height +
                "\nSurface Area: " + surface_area() +
                "\nVolume: " + volume() + "\n";
    }
}