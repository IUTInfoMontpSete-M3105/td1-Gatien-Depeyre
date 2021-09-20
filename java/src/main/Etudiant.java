package main;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;

public class Etudiant extends Utilisateur{
    private int numEtu;
    private ArrayList<Certificat> certificats;

    public Etudiant(String nom, String prenom, String addresse, String mail, int numEtu) {
        super(nom, prenom, addresse, mail);
        this.numEtu = numEtu;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "numEtu=" + numEtu +
                ", certificats=" + certificats +
                '}';
    }

    public void addCertificat(Certificat certificat){
        certificats.add(certificat);
    }

    @Override
    public String getType() {
        return "etu";
    }

    public Rendu creeRendu(){
        Scan sc = new Scan();
        String doc = sc.ecoute("Faites votre devoir M."+getNom());
        Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dat = dateFormat.format(actuelle);

        return new Rendu(doc, dat);
    }

    public void inscrireDansCours(Cours cours){
        cours.addEtudiant(this);
    }

    public void consulterDocument(){
        System.out.println("J'affiche les documents");
    }

    public void estEnCours(){
        System.out.println("Moi, "+super.getNom()+", suis en cours");
    }
}
