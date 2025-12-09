public class Adresse {
    private int numeroCivique;
    private String nomRue;
    private String nomVille;
    private final String PATTERN_REGEX = "^[a-zA-Z\\s-$]+";

    // Les constructeurs (base et copie) devraient faire l'appel des setters qui contiennent
    // la logique de validation

    // Constructeur de base
    public Adresse(int numeroCivique, String nomRue, String nomVille){
        setNumeroCivique(numeroCivique);
        setNomRue(nomRue);
        setNomVille(nomVille);
    }

    // Constructeur de copie DEEP COPY
    public Adresse(Adresse autre) {
        setNumeroCivique(autre.numeroCivique);
        setNomRue(autre.nomRue);
        setNomVille(autre.nomVille);
    }

    public int getNumeroCivique() {
        return numeroCivique;
    }

    public String getNomRue() {
        return nomRue;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNumeroCivique(int numeroCivique) {
        if (numeroCivique < 0)
            throw new IllegalArgumentException("Le numero Civique doit être suprérieur à 0");
        this.numeroCivique = numeroCivique;
    }

    public void setNomVille(String nomVille) {
        if (!nomVille.matches(PATTERN_REGEX) || nomVille.isBlank())
            throw new IllegalArgumentException("Le nom de la ville ne doit pas avoir de chiffre ni d'espace et ne doit pas être vide");
        this.nomVille = nomVille;
    }

    public void setNomRue(String nomRue) {
        if (!nomRue.matches(PATTERN_REGEX) || nomRue.isBlank())
            throw new IllegalArgumentException("Le nom de la rue ne doit pas avoir de chiffre ni d'espace et ne doit pas être vide");
        this.nomRue = nomRue;
    }
    // setters avec validation
    // numeroCivique doit être plus grand que 0
    // nomRue et nomVille ne doivent pas être vide et ils ne doivent
    // contenir que des lettres majuscules, minuscules, espaces ou "-"

    // getters

    @Override
    public String toString() {
        return numeroCivique + " " + nomRue + ", " + nomVille;
    }

}
