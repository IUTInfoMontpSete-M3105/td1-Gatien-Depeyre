package main;

import java.util.ArrayList;

public class Participation {
    private Etudiant etu;
    private Cours cours;
    private ArrayList<Rendu> rendus;

    @Override
    public String toString() {
        return "Participation{" +
                "etu=" + etu +
                ", cours=" + cours +
                '}';
    }

    public Participation(Etudiant etu, Cours cours) {
        this.etu = etu;
        this.cours = cours;
    }

    public void addRendu(Rendu rendu){
        this.rendus.add(rendu);
    }

    public void notifierEtudiant(){
        etu.estEnCours();

    }

    public float calculMoyenne(){
        float somme = 0, coefs=0;

        for (Rendu r: rendus){
            somme+=r.getNote();
            coefs++;
        }
        return somme/coefs;
    }

    public Etudiant getEtu() {
        return etu;
    }
}
