package Classes;

public class Spiller {

    private String navn;
    private Konto konto = new Konto(1000);

    public Spiller(String navn){
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public Konto getKonto() {
        return konto;
    }
}
