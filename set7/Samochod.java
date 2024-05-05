public class Samochod extends Pojazd{
    protected int iloscDrzwi;
    protected String rodzajNapedu;
    protected String nrRejestracji;

    public Samochod(int iloscMiejsc, int rokProdukcji, String marka, int iloscDrzwi, String rodzajNapedu, String nrRejestracji){
        super(iloscMiejsc, rokProdukcji, marka);
        this.iloscDrzwi = iloscDrzwi;
        this.rodzajNapedu = rodzajNapedu;
        this.nrRejestracji = nrRejestracji;
    }
    
    @Override
    public String toString(){
        return super.toString() + ", ilosc drzwi: " + String.valueOf(iloscDrzwi) + ", rodzaj napedu: " + rodzajNapedu + ", numer rejestracji: " + nrRejestracji; 
    }
}
