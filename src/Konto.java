public class Konto {
    private int pengeBeholdning;

    public Konto(int startPengeBeholdning){
        this.pengeBeholdning = startPengeBeholdning;
    }

    public int getPengeBeholdning() {
        return pengeBeholdning;
    }

    public boolean updatePengeBeholdning(int feltVærdi) {
        int nyPengeBeholdning = pengeBeholdning + feltVærdi;
        if(nyPengeBeholdning < 0){
            return false;
        }
        pengeBeholdning = nyPengeBeholdning;
        return true;
    }
}

