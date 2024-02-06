public class ExtendedVector extends Vector {
    public ExtendedVector(double x, double y) {
        super(x, y);
    }

    // Дополнительный метод: Умножение вектора на скаляр
    public ExtendedVector multiplyByScalar(double scalar) {
        return new ExtendedVector(this.x * scalar, this.y * scalar);
    }

    @Override
    public ExtendedVector add(Vector other) {
        return new ExtendedVector(this.x + other.x, this.y + other.y);
    }


    // Дополнительный метод: Проверка на равенство двух векторов
    public boolean areEqual(ExtendedVector other) {
        return this.x == other.x && this.y == other.y;
    }
}
