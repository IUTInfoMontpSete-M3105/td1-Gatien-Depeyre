package main;

public class Admin extends Utilisateur{
    @Override
    public String getType() {
        return "admin";
    }

    public Admin() {
        super("Nom", "Prenom", "adresse", "mail");

    }

    public Admin(String nom, String prenom, String adresse, String mail) {
        super(nom, prenom, adresse, mail);
    }

    public Cours creerCours(Enseignant tuteur){
        Scan sc = new Scan();
        String nom = sc.ecoute("Donnez le nom du cours");
        int semestre = sc.ecouteInt("Quel est le semestre de ce cours");
        Cours cours = new Cours(nom, semestre);
        cours.addEnseignant(tuteur);
        return cours;
    }

    public void attribuerCours(Cours cours, Enseignant enseignant){
        cours.addEnseignant(enseignant);
    }
}
