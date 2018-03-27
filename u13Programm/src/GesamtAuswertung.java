import java.util.LinkedList;

public class GesamtAuswertung {

    private LinkedList<DateiAuswertung> ergebnis = new LinkedList<>();
    private int gesamtLOC;
    private int gesamtZeilen;
    private int gesamtComments;

    /**
     * Fügt Objekt vom Typ DateiAuswertung in eine LinkedList ein.
     * @param db    hinzuzufügende Auswertung einer Datei, in Form eines DateiAuswertung
     *              Objekts.
     */
    public void add(DateiAuswertung db){
        ergebnis.add(db);
        this.gesamtLOC = this.gesamtLOC + db.getZeilenCode();
        this.gesamtZeilen = this.gesamtZeilen + db.getZeilenGesamt();
        this.gesamtComments = this.gesamtComments + db.getZeilenComment();
    }

    /**
     * Getter für Lines of Code
     * @return Lines of Code
     */
    public int getGesamtLOC(){
        return gesamtLOC;
    }

    /**
     * Getter für gesamt Anzahl Zeilen
     * @return  gesamte Zeilenanzahl
     */
    public int getGesamtZeilen() {
        return gesamtZeilen;
    }

    /**
     * Getter für gesamte Anzahl Comments
     * @return  Anzahl gesamte Comments
     */
    public int getGesamtComments() {
        return gesamtComments;
    }

    /**
     * To String Methode der Klasse GesamtAuswertung
     * TODO CommentRatio 0.0
     * @return  Aufbereiteter String
     */
    public String toString(){
        StringBuffer ausgabe = new StringBuffer();
        ausgabe.append("Auswertung Lines of Code (LOC)\n");
        int i = 0;
        while(i < ergebnis.size()){
            ausgabe.append(ergebnis.get(i).toString());
            i++;
        }

        return ausgabe.toString();
    }
}
