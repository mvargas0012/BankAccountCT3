package shapes;

public class Cylinder extends Shape {

    private double radius;
    private double height;

    public Cylinder(double radius,
                    double height) {

        this.radius = radius;
        this.height = height;
    }

    public double surface_area() {

        return 2 * Math.PI *
               radius * radius +
               2 * Math.PI *
               radius * height;
    }

    public double volume() {

        return Math.PI *
               radius * radius *
               height;
    }


    public String toString() {

        return "Cylinder\n" +
               "Radius: " + radius +
               "\nHeight: " + height +
               "\nSurface Area: " +
               surface_area() +
               "\nVolume: " +
               volume() + "\n";
    }
}