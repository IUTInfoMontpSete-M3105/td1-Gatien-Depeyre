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

    public Participation getParticipationDe(Etudiant etu){
        for (Participation p:this.participations) {
            if(p.getEtu().equals(etu))
                return p;
        }
        return null;
    }

    public void addEnseignant(Enseignant enseignant){
        enseignants.add(enseignant);
    }

    public void addEtudiant(Etudiant etu){
        boolean estInscrit = false;
        for (Participation p: this.participations){
            if(p.getEtu().equals(etu)) {
                System.out.println("Cet etudiant est déjà inscrit à ce cours");
                estInscrit = true;
            }
        }
        if(!estInscrit)
            participations.add(new Participation(etu, this));
    }

    public String getNom() {
        return nom;
    }
}
