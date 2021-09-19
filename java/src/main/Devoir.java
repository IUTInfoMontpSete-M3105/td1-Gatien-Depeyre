package main;

public class Devoir {
    private String nom, description, date;
    private int nbPts;
    private Cours cours;

    public Devoir(String nom, String description, String date, int nbPts, Cours cours) {
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.nbPts = nbPts;
        this.cours = cours;
    }

    @Override
    public String toString() {
        return "Devoir{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", nbPts=" + nbPts +
                ", cours=" + cours +
                '}';
    }
}
