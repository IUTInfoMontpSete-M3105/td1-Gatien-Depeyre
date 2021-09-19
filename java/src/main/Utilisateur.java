package main;

public class Utilisateur {
    private String nom, prenom, adresse, mail;

    public Utilisateur(String nom, String prenom, String adresse, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }
}
