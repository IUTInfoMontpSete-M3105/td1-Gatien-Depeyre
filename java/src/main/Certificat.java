package main;

public class Certificat {
    private int totalPts;
    private String appreciation;

    public Certificat(int totalPts, String appreciation) {
        this.totalPts = totalPts;
        this.appreciation = appreciation;
    }

    @Override
    public String toString() {
        return "Certificat{" +
                "totalPts=" + totalPts +
                ", appreciation='" + appreciation + '\'' +
                '}';
    }
}
