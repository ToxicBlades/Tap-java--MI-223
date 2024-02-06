public class Main {
    public static void main(String[] args) {
        Vector v1 = new Vector(3, 4);
        Vector v2 = new Vector(-2, 5);

        System.out.println("Длина вектора v1: " + VectorOperations.calculateMagnitude(v1));
        System.out.println("Длина вектора v2: " + VectorOperations.calculateMagnitude(v2));

        Vector sum = VectorOperations.add(v1, v2);
        System.out.print("Сумма векторов v1 и v2: " );
        sum.printCoordinates();

        System.out.println("v1 и v2 параллельны? " + VectorOperations.areParallel(v1, v2));
        System.out.println("v1 и v2 перпендикулярны? " + VectorOperations.arePerpendicular(v1, v2));

        ExtendedVector v3 = new ExtendedVector(1, 1);
        ExtendedVector v4 = new ExtendedVector(2, 2);

        System.out.println("Длина вектора v3: " + v3.calculateMagnitude());
        System.out.println("Длина вектора v4: " + v4.calculateMagnitude());

        ExtendedVector sum2 = (ExtendedVector) v3.add(v4);
        System.out.print("Сумма векторов v3 и v4: ");
        sum2.printCoordinates();

        System.out.println("v3 и v4 параллельны? " + v3.areParallel(v4));
        System.out.println("v3 и v4 перпендикулярны? " + v3.arePerpendicular(v4));

        ExtendedVector v5 = new ExtendedVector(3, 3);
        ExtendedVector v6 = new ExtendedVector(6, 6);

        System.out.println("v5 и v6 равны? " + v5.areEqual(v6));

        ExtendedVector scaledVector = v5.multiplyByScalar(2);
        System.out.print("Умножение вектора v5 на скаляр 2: ");
        scaledVector.printCoordinates();
    }
}