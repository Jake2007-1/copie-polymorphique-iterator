public abstract class Personne {
    private int age;         // private
    private Adresse adresse; // private

    // Les constructeurs (base et copie) devraient faire l'appel des setters qui contiennent
    // la logique de validation

    // Constructeur de base
    public Personne(int age, Adresse adresse) {
        setAge(age);
        setAdresse(adresse);
    }

    // Constructeur de copie DEEP COPY
    public Personne(Personne autre) {
        age = autre.age;
        adresse = new Adresse(autre.adresse);
    }

    // Méthode abstraite copie() pour l'appel de copie polymorphique
    // sera implémentée dans les classes Adulte et Enfant

    public abstract Personne copie();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0)
            throw new IllegalArgumentException("L'age doit être >= 0");
        this.age = age;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        if (adresse == null)
            throw new IllegalArgumentException("L'adresse ne doit pas être null")
        this.adresse = adresse;
    }


    // setters avec validation
    // age doit être plus grand que 0
    // adresse ne doit pas être nulle

    // getters

    @Override
    public String toString() {
        return "Âge: " + this.age + ", Adresse: [" + this.adresse + "]";
    }
}