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
        ArrayList<Rendu> rendus = new ArrayList<>();
        ArrayList<Devoir> devoirs = new ArrayList<>();
        utilisateurs.put("admin", new Admin());


        while(!msg.equals("stop")){

            msg = sc.ecoute("Veuillez rentrer votre identité (admin pour créer des comptes). Utilisateurs connus : "+
                    tab_to_string(utilisateurs.keySet()));
            while (!(msg.equals("stop") || utilisateurs.containsKey(msg)))
                msg = sc.ecoute("Veuillez rentrer votre identité (admin pour créer des comptes). Utilisateurs connus : "+
                        tab_to_string(utilisateurs.keySet()));

            if(utilisateurs.get(msg).getType().equals("admin")){
                Utilisateur u = creer_utilisateur(sc);
                utilisateurs.put(u.getNom(), u);
            }
            else if(utilisateurs.get(msg).getType().equals("etu")){
                action_etu((Etudiant) utilisateurs.get(msg), sc, cours, rendus, devoirs);
            }
            else if(msg.equals("stop")){
                System.out.println("Au revoir");
            }
            else{
                action_ens((Enseignant) utilisateurs.get(msg), sc, cours, rendus, devoirs);
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

    private static Enseignant creer_ens(Scan sc){
        String nom = sc.ecoute("Quel est son nom ?");
        String prenom = sc.ecoute("Quel est son prenom ?");
        String adresse = sc.ecoute("Quel est son adresse ?");
        String mail = sc.ecoute("Quel est son mail ?");
        int numen = sc.ecouteInt("Quel est son numen ?");
        int arp = sc.ecouteInt("Quel est son harpege ?");
        return new Enseignant(nom, prenom, adresse, mail, numen, arp);
    }

    private static Etudiant creer_etu(Scan sc){
        String nom = sc.ecoute("Quel est son nom ?");
        String prenom = sc.ecoute("Quel est son prenom ?");
        String adresse = sc.ecoute("Quel est son adresse ?");
        String mail = sc.ecoute("Quel est son mail ?");
        int num = sc.ecouteInt("Quel est son numéro ?");
        return new Etudiant(nom, prenom, adresse, mail, num);
    }

    private static Admin creer_admin(Scan sc){
        String nom = sc.ecoute("Quel est son nom ?");
        String prenom = sc.ecoute("Quel est son prenom ?");
        String adresse = sc.ecoute("Quel est son adresse ?");
        String mail = sc.ecoute("Quel est son mail ?");
        return new Admin(nom, prenom, adresse, mail);
    }

    private static String tab_to_string(Set<String> tab){
        StringBuilder total = new StringBuilder();
        for (String nom: tab) {
            total.append(nom).append(", ");
        }
        return total.toString();
    }

    private static void action_etu(Etudiant etu, Scan sc, HashMap<String , Cours> cours,
                                   ArrayList<Rendu> rendus, ArrayList<Devoir> devoirs){
        String action = sc.ecoute("Que voulez vous faire (sinscrire, creerRendu, consulterDocs) ?");
        switch (action){
            case "sinscrire":
                String cour = sc.ecoute("Quel est le nom du cour ?");
                etu.inscrireDansCours(cours.get(cour));
                break;
            case "creerRendu":
                System.out.println("Votre rendu possede le numéro "+rendus.size());
                rendus.add(etu.creeRendu(devoirs.get(sc.ecouteInt("Quel est le numéro du devoir ?"))));
                break;
            case "consulterDocs":
                etu.consulterDocument();
                for (Rendu r: rendus) {
                    System.out.println(r.toString());
                }
                break;
            default:
                System.out.println("Ce choix ne correspond à aucune option");
                action_etu(etu, sc, cours, rendus, devoirs);
                break;
        }
    }

    private static void action_ens(Enseignant ens, Scan sc, HashMap<String , Cours> cours,
                                   ArrayList<Rendu> rendus, ArrayList<Devoir> devoirs){
        String action = sc.ecoute("Que voulez vous faire (donnerCour, creerDevoir, corrigerRendu) ?");
        switch (action){
            case "donnerCour":
                ens.donnerCours(cours.get(sc.ecoute("Quel est le nom du cours ?")));
                break;
            case "creerDevoir":
                System.out.println("Votre devoir possede le numero "+devoirs.size());
                devoirs.add(ens.creerDevoir(cours.get(sc.ecoute("Quel est le nom du cours ?"))));
                break;
            case "corrigerRendu":
                ens.corrigerRendu(rendus.get(sc.ecouteInt("Quel est le numero du rendu ?")));
                break;
            default:
                System.out.println("Votre choix ne correspond à aucune action");
                action_ens(ens, sc, cours, rendus, devoirs);
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

    }
}
