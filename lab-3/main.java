import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Cuvant[] cuvinte = {new Cuvant("Hello"), new Cuvant("World"), new Cuvant("Java")};
        Linie linie = new Linie(cuvinte);

        // Testarea metodei contains
        System.out.println("Contains 'World': " + linie.contains(new Cuvant("World")));
        System.out.println("Contains 'Python': " + linie.contains(new Cuvant("Python")));

        // Testarea metodei containsPattern
        System.out.println("Contains pattern 'Java': " + linie.containsPattern("Java"));
        System.out.println("Contains pattern 'lo': " + linie.containsPattern("lo"));

        // Testarea metodei toString
        System.out.println("Linie: " + linie);
    }
}
