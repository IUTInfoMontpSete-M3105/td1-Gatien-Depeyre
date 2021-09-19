package main;

import java.util.ArrayList;

public class Cours {
    private String nom;
    private int semestre;
    private ArrayList<Enseignant> enseignants;
    private ArrayList<Participation> participations;

    public Cours(String nom, int semestre) {
        this.nom = nom;
        this.semestre = semestre;
        enseignants = new ArrayList<>();
        participations = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Cours{" +
                "nom='" + nom + '\'' +
                ", semestre=" + semestre +
                '}';
    }

    public void estDonne(){
        System.out.println("Le cours "+nom+" de semestre "+semestre+" est donné.");
        for (Participation p:participations) {
            p.notifierEtudiant();
        }
    }


    public void addEnseignant(Enseignant enseignant){
        enseignants.add(enseignant);
    }

    public void addEtudiant(Etudiant etu){
        Participation participation = new Participation(etu, this);
    }
}
