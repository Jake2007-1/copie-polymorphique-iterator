public class Enfant extends Personne {

    public enum Statut{
        NOURISSON,
        PETITEENFANCE,
        ENFANCE,
        PREADOLESCENCE,
        ADOLESCENCE
    }

    // Statut sous forme d'enum ayant pour valeurs possibles
    // NOURISSON, PETITEENFANCE, ENFANCE, PREADOLESCENCE, ADOLESCENCE

    private Statut statut; // private

    public Enfant(int age, Adresse adresse, Statut statut) {
        super(age,adresse);
        this.statut = statut;
    }

    // Constructeur de copie DEEP COPY
    public Enfant(Enfant autre) {
        super(autre.getAge(),autre.getAdresse());
        this.statut = autre.getStatut();

    }

    // setter avec validation sur le statut qui ne doit pas être nul

    public void setStatut(Statut statut) {
        if (statut == null)
            throw new IllegalArgumentException("Le statut ne doit pas être null");
        this.statut = statut;
    }

    // getter

    public Statut getStatut() {
        return statut;
    }

    // Implémentation de la copie polymorphique soit la méthode copie() utilisant le constructeur de copie

    @Override
    public Enfant copie(){
        return new Enfant(this);
    }

    @Override
    public String toString() {
        return "Enfant: " + super.toString() + ", Statut: " + this.statut;
    }
}
