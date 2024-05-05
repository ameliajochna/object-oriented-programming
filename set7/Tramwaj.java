public class Tramwaj extends Pojazd {
    protected String linia;
    protected boolean czyWykolejenie;
    protected String kolor;

    public Tramwaj(int iloscMiejsc, int rokProdukcji, String marka, String linia, boolean czyWykolejenie, String kolor){
        super(iloscMiejsc, rokProdukcji, marka);
        this.linia = linia;
        this.czyWykolejenie = czyWykolejenie;
        this.kolor = kolor;
    }

    @Override
    public String toString(){
        return super.toString() + ", linia: " + linia + ", czy wykolejenie: " + czyWykolejenie + ", kolor: " + kolor; 
    }
}
