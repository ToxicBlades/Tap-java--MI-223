public class Vector {
    protected double x;
    protected double y;

    // Конструктор 1: инициализация координат вектора по умолчанию (0, 0)
    public Vector() {
        this.x = 0;
        this.y = 0;
    }

    // Конструктор 2: инициализация координат вектора с заданными значениями
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Конструктор 3: копирование вектора
    public Vector(Vector other) {
        this.x = other.x;
        this.y = other.y;
    }

    // Метод 1: Вычисление длины вектора
    public double calculateMagnitude() {
        return Math.sqrt(x * x + y * y);
    }

    // Метод 2: Сложение двух векторов
    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }

    // Метод 3: Проверка на параллельность двух векторов
    public boolean areParallel(Vector other) {
        return (this.x * other.y - this.y * other.x) == 0;
    }

    // Метод 4: Проверка на перпендикулярность двух векторов
    public boolean arePerpendicular(Vector other) {
        return (this.x * other.x + this.y * other.y) == 0;
    }

    // Метод 5: Печать координат вектора
    public void printCoordinates() {
        System.out.println("Координаты вектора: (" + this.x + ", " + this.y + ")");
    }
}



