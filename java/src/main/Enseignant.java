package main;

public class Enseignant extends Utilisateur{
    private int numen, harpege;

    public Enseignant(String nom, String prenom, String addresse, String mail, int numen, int harpege) {
        super(nom, prenom, addresse, mail);
        this.numen = numen;
        this.harpege = harpege;
    }

    public Devoir creerDevoir(Cours cours){
        Scan sc = new Scan();
        String nom, desc, date;
        int nbPts;
        nom = sc.ecoute("Nom du devoir ?");
        desc = sc.ecoute("Faites une description de ce devoir");
        date = sc.ecoute("Ecrivez une date (jj/mm/aaaa)");
        nbPts = sc.ecouteInt("Rentrez le nombre de points de ce devoir");
        return new Devoir(nom, desc, date, nbPts, cours);
    }

    public void donnerCours(Cours cours){
        System.out.println("Je donne un cours");
        cours.estDonne();
    }

    public void corrigerRendu(Rendu rendu){
        Scan sc = new Scan();
    }
}
