package main;

import java.util.ArrayList;

public class Participation {
    private Etudiant etu;
    private Cours cours;
    private ArrayList<Integer> notes;

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

    public void addNote(int note){
        this.notes.add(note);
    }

    public void notifierEtudiant(){
        etu.estEnCours();

    }

    public Etudiant getEtu() {
        return etu;
    }
}
