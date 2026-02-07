package shapes;

public class ShapeArray {

    public static void main(String[] args) {

        // Object Instance
        Sphere sphere = new Sphere(5.0);
        Cylinder cylinder = new Cylinder(3.0 , 7.0);
        Cone cone = new Cone(4.0 , 6.0);

        // Store in array of shape (polymorphism)
        Shape[] shapeArray = {sphere, cylinder, cone};

        // Loop through array and print each object
        for (Shape shape: shapeArray) {
            System.out.println(shape.toString());
        }
    }
}
