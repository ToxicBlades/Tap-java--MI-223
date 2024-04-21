import java.util.HashSet;
import java.util.Set;

public class IntegerSet {

    private Set<Integer> set;

    // Constructor care initializează setul
    public IntegerSet() {
        this.set = new HashSet<>();
    }

    // Metodă pentru adăugarea unui număr în set
    public void add(int num) {
        set.add(num);
    }

    // Metodă pentru determinarea uniunii dintre două seturi
    public IntegerSet union(IntegerSet otherSet) {
        IntegerSet unionSet = new IntegerSet();
        unionSet.set.addAll(this.set);
        unionSet.set.addAll(otherSet.set);
        return unionSet;
    }

    // Metodă pentru determinarea intersectiei dintre două seturi
    public IntegerSet intersection(IntegerSet otherSet) {
        IntegerSet intersectionSet = new IntegerSet();
        for (Integer num : this.set) {
            if (otherSet.set.contains(num)) {
                intersectionSet.add(num);
            }
        }
        return intersectionSet;
    }

    // Metodă pentru afișarea setului
    @Override
    public String toString() {
        return set.toString();
    }

    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Setul 1: " + set1);
        System.out.println("Setul 2: " + set2);

        System.out.println("Uniunea: " + set1.union(set2));
        System.out.println("Intersectia: " + set1.intersection(set2));
    }
}
