package main;

public class Rendu {
    private final String document;
    private final String date;
    private final Devoir devoir;
    private int note;

    public Rendu(String document, String date, Devoir devoir) {
        this.document = document;
        this.date = date;
        this.note = -1;
        this.devoir = devoir;
    }

    public String getDocument() {
        return document;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getNote() {
        return note;
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
