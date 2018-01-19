
/**
 * Klasse Patient zur Erstellung von Patient-Objekten
 *
 * @author (Christian Weis & Nicolas Klein)
 * @version (09.01.2018)
 */
public class Patient
{
    private int patientenNR;
    private String patientenName;

    public static final String F_PATIENTENNR_FALSCH = "Eingabe prüfen. Patientennummer muss 4stellig sein.";
    public static final String F_PATNAME_LEER = "Feld Patientenname darf nicht leer sein";

    /**
     * Konstruktor für Objekte der Klasse Patient
     *
     * @param   patientenNR     Nummer des Patienten
     * @param   patientenName   Name des Patienten
     */
    public Patient(int patientenNR, String patientenName)
    {
        setPatientenNR(patientenNR);
        setPatientenName(patientenName);
    }

    /**
     * Methode gibt die Patientennummer zurück
     *
     * @return  patientenNR
     */
    public int getPatientenNR()
    {
        return patientenNR;
    }

    /**
     * Methode gibt den Patientennamen zurück
     *
     * @return  patientenName
     */
    public String getPatientenName(){
        return patientenName;
    }

    /**
     * Methode setzt die neue Patientennummer. Prüft vorher, ob es sich um eine Zahl zwischen 999 und 10.000 handelt.
     *
     * @param   patientenNR
     */
    public void setPatientenNR(int patientenNR){
        check(patientenNR <= 9999 && patientenNR >=1000, F_PATIENTENNR_FALSCH);
        this.patientenNR = patientenNR;
    }

    /**
     * Methode setzt den neuen Patientennamen.
     *
     * @param   patientenName
     */
    public void setPatientenName(String patientenName){
        check(patientenName.trim().length()>0 && patientenName != "",F_PATNAME_LEER);
        this.patientenName = patientenName;
    }

    /**
     * Methode wirft eine Exception mit passender Fehlermeldung, wenn die Bedingung false ist
     *
     * @exception   Methode wirft passende Fehlermeldung, wenn Bedingung "false" ist
     */
    private void check(boolean bedingung, String fehlertext){
        if(bedingung != true){
            throw new RuntimeException(fehlertext);
        }
    }

    /**
     * Methode toString der Klasse Patient. Gibt textlich aufbereiteten String mit Patientennummer und Name zurück.
     *
     * @return  PatientenNR und patientenName als aufbereiteten String
     */
    public String toString(){
        StringBuffer str = new StringBuffer();
        str.append(getPatientenNR() + "\t" + getPatientenName());

        return str.toString();
    }


}
