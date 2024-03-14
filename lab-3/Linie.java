import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Linie {
    private Cuvant[] cuvinte;

    public Linie(Cuvant[] cuvinte) {
        this.cuvinte = cuvinte;
    }

    // Metoda de suprascriere pentru căutarea unui cuvânt în linie
    public boolean contains(Cuvant cuvant) {
        for (Cuvant c : cuvinte) {
            if (c.equals(cuvant)) {
                return true;
            }
        }
        return false;
    }

    // Metoda de suprascriere pentru căutarea unui șir după un anumit șablon cu utilizarea expresiilor regulate
    public boolean containsPattern(String pattern) {
        for (Cuvant c : cuvinte) {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(c.getCuvant());
            if (m.find()) {
                return true;
            }
        }
        return false;
    }

    // Metoda de suprascriere pentru afișarea liniei
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cuvant c : cuvinte) {
            sb.append(c.getCuvant()).append(" ");
        }
        return sb.toString().trim();
    }
}
