package main;

import java.util.ArrayList;

public class Certificat {
    /*
    Certificat représente le diplome remis par chaque matière à la fin de l'UE
     */
    private int totalPts;
    private String appreciation;
    private Boolean positif;

    public Certificat(String appreciation) {
        this.totalPts = totalPts;
        this.appreciation = appreciation;
        positif = false;
    }

    public void estRemit(Etudiant etu, Enseignant ens, Cours cours){
        Participation participation = cours.getParticipationDe(etu);
        float moyenne = participation.calculMoyenne();
        if(moyenne>=10)
            this.positif = true;
        System.out.println("M."+ens.getNom()+" a remis à M."+etu.getNom()+
                " son certificat de "+cours.getNom());
    }



    @Override
    public String toString() {
        return "Certificat{" +
                "totalPts=" + totalPts +
                ", appreciation='" + appreciation + '\'' +
                '}';
    }
}
