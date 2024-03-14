public class Cuvant {
    private String cuvant;

    public Cuvant(String cuvant) {
        this.cuvant = cuvant;
    }

    public String getCuvant() {
        return cuvant;
    }

    // Metoda de comparare a cuvintelor
    public boolean equals(Cuvant other) {
        return this.cuvant.equals(other.getCuvant());
    }
}
