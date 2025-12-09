import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // --- 1. Création des Objets Originaux ---
        System.out.println("--- 1. Objets Originaux ---");

        // Adresses pour les originaux
        // 10, "Rue Principale", "Montréal"
        // 25, "Avenue des Fleurs", "Laval"
        Adresse adresseMtl = new Adresse(10, "Rue Principale","Montréal" );
        Adresse adresseLav = new Adresse(25, "Avenue des Fleurs", "Laval");


        // Création des instances concrètes (Enfant et Adulte)
        // 8 ans, adresse de Montréal et statut ENFANCE
        // 45 ans, adresse de Laval et statut CHOMAGE
        Personne originalEnfant = new Enfant(8, adresseMtl, Enfant.Statut.ENFANCE);
        Personne originalAdulte = new Adulte(45, adresseLav, Adulte.Statut.CHOMAGE);

        // Création d'une liste de Personne sous la forme d'un ArrayList
        List<Personne> originaux = new ArrayList<>();

        // Faire l'ajout des originaux dans la liste

        originaux.add(originalEnfant);
        originaux.add(originalAdulte);

        // Faire l'affichage de originaux
        System.out.println("Liste originaux");
        for(Personne p: originaux) {
            System.out.println(p);
        }

        // --- 2. Copie Polymorphique (DEEP COPY) ---
        System.out.println("--- 2. Copie polymorphique (DEEP COPY) ---");

        // Création d'une liste de Personne sous la forme d'un ArrayList
        List<Personne> copies = new ArrayList<>();

        // La magie du polymorphisme :
        // L'appel à p.copie() résout dynamiquement à Enfant.copie() ou Adulte.copie().
        // Faire une boucle sur originaux et faire l'ajout dans copies d'une copie
        // de chaque objet trouvé dans originaux

        for (Personne p: originaux){
            copies.add(p.copie());
        }

        // Faire l'affichage de copies
        System.out.println("Liste copies");
        System.out.println(copies);



        // --- 3. Modification de l'original pour tester la copie profonde ---
        System.out.println("--- 3. Modification de l'original pour tester la copie profonde ---");

        // Modification de l'objet original Enfant:
        // On change son age pour 9 ans et son statut pour PREADOLESCENCE

        originalEnfant.setAge(9);
        ((Enfant) originalEnfant).setStatut(Enfant.Statut.PREADOLESCENCE);

        // Modification de l'objet original Adulte:
        // On change l'Adresse de l'original Adulte (pour tester la DEEP COPY de l'Adresse)
        // 50, "Boulevard Industriel", "Quebec"
        // Et on change son statut pour TRAVAILLEUR

        originalAdulte.setAdresse(new Adresse(50, "Boulevard Industriel", "Quebec"));
        ((Adulte) originalAdulte).setStatut(Adulte.Statut.TRAVAILLEUR);
        // Affichage des deux listes après modification
        System.out.println("\nListe originaux APRÈS Modification:");
        System.out.println(originaux);
        System.out.println(copies);

        // Afficher liste originaux
        System.out.println(originaux);

        System.out.println("\n--- 4. Vérifications  ---");
        System.out.println("Liste des copies APRÈS modification de l'original (DOIT ÊTRE INCHANGÉE):");
        // Afficher liste copies
        System.out.println(copies);
        // Les copies ne doivent pas avoir été affectées par les modifications ci-dessus,
        // prouvant la DEEP COPY.


        // Vérification des détails (pour clarté)
        Personne copieEnfant = copies.get(0);
        Personne copieAdulte = copies.get(1);



        System.out.println("\n--- Résultat du Test ---");
        System.out.println("Original Enfant (Âge: 9, Statut: PREADOLESCENCE, Ville: Montreal)");
        // Il y aura une erreur à getStatut(), pourquoi et corriger?
        System.out.println("Copie Enfant    (Âge: " + copieEnfant.getAge() + ", Statut: " + ((Enfant) copieEnfant).getStatut() + ", Ville: " + copieEnfant.getAdresse().getNomVille() + ") -> OK (8, ENFANCE, Montreal)");

        System.out.println("\nOriginal Adulte (Statut: TRAVAILLEUR, Ville: Quebec)");
        // Il y aura une erreur à getStatut(), pourquoi et corriger?
        System.out.println("Copie Adulte    (Statut: " + ((Adulte) copieAdulte).getStatut() + ", Ville: " + copieAdulte.getAdresse().getNomVille() + ") -> OK (TRAVAILLEUR, Laval)");
    }
}