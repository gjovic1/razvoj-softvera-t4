package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Racun {

    private class StavkeRacuna{
        private Artikal artikal;
        private int kol;

        public StavkeRacuna (Artikal artikal, int kol){
            this.artikal = artikal;
            this.kol = kol;
        }

        public Artikal getArtikal() {
            return artikal;
        }

        public void setArtikal(Artikal artikal) {
            this.artikal = artikal;
        }

        public int getKol() {
            return kol;
        }

        public void setKol(int kol) {
            this.kol = kol;
        }
    }

    private ArrayList<StavkeRacuna> stvari;

    public Racun(){
        this.stvari = new ArrayList<>();
    }

    public void dodajStavku (Artikal artikal, int kol){
        StavkeRacuna stvar = new StavkeRacuna(artikal, kol);
        stvari.add(stvar);
    }

    public double ukupanIznos() {
        double iznos = 0;
        for(StavkeRacuna stvar : stvari){
            iznos += stvar.getArtikal().getCijena() * stvar.getKol();
        }
        return iznos;
    }

    @Override
    public String toString() {
        StringBuilder izlaz = new StringBuilder();
        for(StavkeRacuna stvar : stvari){
            izlaz.append(
                    stvar.getArtikal().getSifra())
                    .append(" ").append(stvar.getKol())
                    .append(" ").append(stvar.getArtikal().getCijena() * stvar.getKol())
                    .append("\n");
        }
        izlaz.append("UKUPNO").append(" ").append(ukupanIznos());
        return izlaz.toString();
    }
}
