package main;

public class App {
    public static void main(String[] args) {

        Scan sc = new Scan();

        Etudiant etu = new Etudiant("Bonbadil", "Tom", "Foret Noire",
                "Tom@middle-earth.tk", 007);

        Admin admin = new Admin("Admin", "Admin", "1 rue admin", "admin@ad.com");

        Enseignant enseignant = new Enseignant("ens1", "ens1", "1 rue ens", "ens@e.com",
                001, 001);

        Cours fr = admin.creerCours(enseignant);

        Etudiant etudiant = new Etudiant("e1", "e1", "add1", "e1@etu.fr", 001);

        etudiant.inscrireDansCours(fr);

        enseignant.donnerCours(fr);

        Devoir dev = enseignant.creerDevoir(fr);

        etudiant.creeRendu();

    }
}
