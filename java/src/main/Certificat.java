package main;

import java.util.ArrayList;

public class Certificat {
    private int totalPts;
    private String appreciation;

    public Certificat(int totalPts, String appreciation) {
        this.totalPts = totalPts;
        this.appreciation = appreciation;
    }

    public void estRemit(Etudiant etu, Enseignant ens, Cours cours){
        Participation participation = cours.getParticipationDe(etu);
        float moyenne = participation.calculMoyenne();
        if(moyenne>=10)
            System.out.println("M."+ens.getNom()+" a remis à M."+etu.getNom()+
                    " son certificat de "+cours.getNom());
        else
            System.out.println("La moyenne est trop basse");
    }



    @Override
    public String toString() {
        return "Certificat{" +
                "totalPts=" + totalPts +
                ", appreciation='" + appreciation + '\'' +
                '}';
    }
}
