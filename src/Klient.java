public class Klient {
    public String nimi;
    public String perekonnanimi;

    @Override
    public String toString() {
        return nimi + " " + perekonnanimi;
    }

    public Klient(String nimi, String perekonnanimi) {
        this.nimi = nimi;
        this.perekonnanimi = perekonnanimi;
    }

    public String getNimi() {
        return nimi;
    }

    public String getPerekonnanimi()
    {
        return perekonnanimi;
    }
}
