public class Adulte extends Personne {

    public enum Statut{
        TRAVAILLEUR,
        CHOMAGE,
        MALADIE,
        RETRAITE
    }

    // Statut sous forme d'enum ayant pour valeurs possibles
    // TRAVAILLEUR, CHOMAGE, MALADIE, RETRAITE

    private Statut statut; // private

    // Constructeur de base
    public Adulte(int age, Adresse adresse, Statut statut) {
        super(age,adresse);
        setStatut(statut);
    }

    // Constructeur de copie DEEP COPY
    public Adulte(Adulte autre) {
        super(autre.getAge(),autre.getAdresse());
        statut = autre.statut;
    }

    // setter avec validation sur le statut qui ne doit pas être nul

    public void setStatut(Statut statut) {
        if (statut == null)
            throw new IllegalArgumentException("Le statut ne peut pas être null");
        this.statut = statut;
    }


    // getter

    public Statut getStatut() {
        return statut;
    }

    // Implémentation de la copie polymorphique soit la méthode copie() utilisant le constructeur de copie

    @Override
    public Adulte copie(){
        return new Adulte(this);
    }

    @Override
    public String toString() {
        return "Adulte: " + super.toString() + ", Statut: " + this.statut;
    }
}