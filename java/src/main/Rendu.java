package main;

public class Rendu {
    private String document, date;
    private int note;

    public Rendu(String document, String date) {
        this.document = document;
        this.date = date;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Rendu{" +
                "document='" + document + '\'' +
                ", date='" + date + '\'' +
                ", note=" + note +
                '}';
    }
}
