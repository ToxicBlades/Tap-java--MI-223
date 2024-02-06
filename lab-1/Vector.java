public class Vector {
    private double x;
    private double y;

    // Constructor
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Vector lenght
    public double calculateMagnitude() {
        return Math.sqrt(x * x + y * y);
    }

    // Vector summ
    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }

    // Vector parralel
    public boolean areParallel(Vector other) {
        return (this.x * other.y - this.y * other.x) == 0;
    }

    // Vector perpendicular
    public boolean arePerpendicular(Vector other) {
        return (this.x * other.x + this.y * other.y) == 0;
    }

    // Print vector
    public void printCoordinates() {
        System.out.println("Vector coords: (" + this.x + ", " + this.y + ")");
    }

    // main
    public static void main(String[] args) {
        Vector v1 = new Vector(3, 4);
        Vector v2 = new Vector(-2, 5);

        System.out.println("Vector length v1: " + v1.calculateMagnitude());
        System.out.println("Vector lentyh v2: " + v2.calculateMagnitude());

        Vector sum = v1.add(v2);
        System.out.print("Suum of  v1 and v2: ");
        sum.printCoordinates();

        System.out.println("v1 and v2 parallel? " + v1.areParallel(v2));
        System.out.println("v1 and v2 perpendicular? " + v1.arePerpendicular(v2));
    }
}