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

    @Override
    public String getType() {
        return "ens";
    }

    public void corrigerRendu(Rendu rendu){
        Scan sc = new Scan();

        System.out.println("Voici le contrnu du rendu :");
        System.out.println(rendu.getDocument());
        rendu.setNote(sc.ecouteInt("Quelle note voulez vous mettre ?"));
    }

    public void remetreCertificat(Etudiant etu, Cours cours, Scan sc){
        Certificat certificat = new Certificat(sc.ecoute("Quelle est votre " +
                "appréciation pour cet éleve ?"));
        certificat.estRemit(etu, this, cours);
    }
}
