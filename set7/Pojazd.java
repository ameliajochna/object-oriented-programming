public class Pojazd {
    protected int iloscMiejsc;
    protected int rokProdukcji;
    protected String marka;

    public Pojazd(int iloscMiejsc, int rokProdukcji, String marka){
        this.iloscMiejsc = iloscMiejsc;
        this.rokProdukcji = rokProdukcji;
        this.marka = marka;
    }

    public String toString(){
        return "Ilosc miejsc: " + String.valueOf(iloscMiejsc) + ", rok produkcji: " + String.valueOf(rokProdukcji) + ", marka: " + marka;
    }
}
