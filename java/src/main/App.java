package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class App {


    public static void main(String[] args) {
        Scan sc = new Scan();
        String msg = "";

        HashMap<String , Utilisateur> utilisateurs = new HashMap<>();
        HashMap<String , Cours> cours = new HashMap<>();
        utilisateurs.put("admin", new Admin());


        while(!msg.equals("stop")){

            msg = sc.ecoute("Veuillez rentrer votre identité (admin pour créer des comptes). Utilisateurs connus : "+
                    tab_to_string(utilisateurs.keySet()));
            while (!(msg.equals("stop") || utilisateurs.containsKey(msg)))
                msg = sc.ecoute("Veuillez rentrer votre identité (admin pour créer des comptes). Utilisateurs connus : "+
                        tab_to_string(utilisateurs.keySet()));

            if("admin".equals(msg)) {
                Utilisateur u = creer_utilisateur(sc);
                utilisateurs.put(u.getNom(), u);
            }
            if(utilisateurs.get(msg).getType().equals("admin")){
                System.out.println("ok admin");
            }
        }


        tests(sc);

    }

    public static Utilisateur creer_utilisateur(Scan sc){
        String role = sc.ecoute("Quel type d'utilisateur voulez-vous créer ? (etu, ens, admin)");
        Utilisateur uti = null;
        switch (role){
            case "etu":
                uti = creer_etu(sc);
                break;
            case "ens":
                uti = creer_ens(sc);
                break;
            case "admin":
                uti = creer_admin(sc);
                break;
            default:
                System.out.println("Type d'utilisateur invalide.");
                uti = creer_utilisateur(sc);
                break;
        }
        return uti;
    }

    public static Enseignant creer_ens(Scan sc){
        String nom = sc.ecoute("Quel est son nom ?");
        String prenom = sc.ecoute("Quel est son prenom ?");
        String adresse = sc.ecoute("Quel est son adresse ?");
        String mail = sc.ecoute("Quel est son mail ?");
        int numen = sc.ecouteInt("Quel est son numen ?");
        int arp = sc.ecouteInt("Quel est son harpege ?");
        return new Enseignant(nom, prenom, adresse, mail, numen, arp);
    }

    public static Etudiant creer_etu(Scan sc){
        String nom = sc.ecoute("Quel est son nom ?");
        String prenom = sc.ecoute("Quel est son prenom ?");
        String adresse = sc.ecoute("Quel est son adresse ?");
        String mail = sc.ecoute("Quel est son mail ?");
        int num = sc.ecouteInt("Quel est son numéro ?");
        return new Etudiant(nom, prenom, adresse, mail, num);
    }

    public static Admin creer_admin(Scan sc){
        String nom = sc.ecoute("Quel est son nom ?");
        String prenom = sc.ecoute("Quel est son prenom ?");
        String adresse = sc.ecoute("Quel est son adresse ?");
        String mail = sc.ecoute("Quel est son mail ?");
        return new Admin(nom, prenom, adresse, mail);
    }

    public static String tab_to_string(Set<String> tab){
        StringBuilder total = new StringBuilder();
        for (String nom: tab) {
            total.append(nom).append(", ");
        }
        return total.toString();
    }

    public static void action_etu(Etudiant etu, Scan sc, HashMap<String , Cours> cours){
        String action = sc.ecoute("Que voulez vous faire (sinscrire, creerRendu, consulterDocs) ?");
        switch (action){
            case "sinscrire":
                String cour = sc.ecoute("Quel est le nom du cour ?");
                etu.inscrireDansCours(cours.get(cour));
                break;
            case "creerRendu":
                etu.creeRendu();
                break;
            case "consulterDocs":
                etu.consulterDocument();
                break;
            default:
                System.out.println("Ce choix ne correspond à aucune option");
                action_etu(etu, sc, cours);
                break;
        }
    }

    public static void tests(Scan sc){

        Etudiant etu = new Etudiant("Bonbadil", "Tom", "Foret Noire",
                "Tom@middle-earth.tk", 007);

        Admin admin = new Admin("Admin", "Admin", "1 rue admin", "admin@ad.com");

        Enseignant enseignant = new Enseignant("ens1", "ens1", "1 rue ens", "ens@e.com",
                001, 001);

        Cours fr = admin.creerCours(enseignant);

        Etudiant etudiant = new Etudiant("e1", "e1", "add1", "e1@etu.fr", 001);
        Etudiant etudiant2 = new Etudiant("e1", "e1", "add1", "e1@etu.fr", 001);

        etudiant.inscrireDansCours(fr);
        etudiant2.inscrireDansCours(fr);

        enseignant.donnerCours(fr);

        Devoir dev = enseignant.creerDevoir(fr);

        Rendu r = etudiant.creeRendu();
        Rendu r2 = etudiant.creeRendu();

        enseignant.corrigerRendu(r);
    }
}
