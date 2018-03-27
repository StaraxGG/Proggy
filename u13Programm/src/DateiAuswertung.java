public class DateiAuswertung {
    private String dateiname;
    private int zeilenCode;
    private int zeilenGesamt;
    private int zeilenComment;

    /**
     * Konstruktor der Klasse DateiAuswertung
     * @param dateiname
     */
    public DateiAuswertung(String dateiname) {
        this.dateiname = dateiname;
    }

    /**
     * Getter des Dateinamens
     * @return
     */
    public String getDateiname() {
        return dateiname;
    }

    /**
     * Zeilen Code
     * @return
     */
    public int getZeilenCode() {
        return zeilenCode;
    }

    public void addZeilenCode(){
        this.zeilenCode++;
    }

    /**
     * Zeilen Comments
     * @return
     */
    public int getZeilenComment(){
        return zeilenComment;
    }


    public void addZeilenComment() {
        this.zeilenComment++;
    }

    /**
     * Zeilen Gesamt
     * @return
     */
    public int getZeilenGesamt() {
        return zeilenGesamt;
    }

    public void addZeilenGesamt() {
        this.zeilenGesamt++;
    }

    /**
     * Gibt das Verhältnis zwischen Zeilen und Comments zurück.
     * @return  Zeilen/Comments Verhältnis
     */
    public double getCommentRadio() {
        if (this.zeilenCode == 0){
            return 0;
        }
        return this.zeilenComment/this.zeilenCode;
    }

    /**
     * To String Methode der Klasse DateiAuswertung
     * @return  Aufbereitete Ausgabe der Werte
     * dateiname, Code Zeilen, Comment Zeilen und CommentRatio
     */
    public String toString(){
        /**
        return String.format("%-25s:%-2sLOC    %-2sComments    %-2s%\n",
                dateiname,Integer.toString(zeilenCode),
                Integer.toString(zeilenComment),Integer.toString(commentRadio));


        return String.format("%-25s:%-2dLOC    %-2dComments    %-2f%\n",
                dateiname,zeilenCode,
                zeilenComment,commentRadio);
        */

        return dateiname+" ZeilenCode: "+zeilenCode+" Zeilen Comments: "+zeilenComment+" ZeilenGesamt: "+zeilenGesamt
                +" CommentRatio: "+getCommentRadio();
    }
}
