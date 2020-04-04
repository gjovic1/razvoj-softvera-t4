package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;
import java.util.Objects;

public class Artikal {
    private String sifra, naziv;
    private double cijena;

    public Artikal(String a_sifra, String a_naziv, double a_cijena){
        if(sifra==""){
            throw new IllegalArgumentException("Šifra je prazna");
        }
        else{
            setSifra(a_sifra);
        }

        if(naziv==""){
            throw new IllegalArgumentException("Naziv je prazan");
        }
        else{
            setNaziv(a_naziv);
        }

        if(cijena<=0){
            throw new IllegalArgumentException("Cijena je negativna");
        }
        else{
            setCijena(a_cijena);
        }
    }

    public static String toString(Artikal a) {
        return a.sifra + ", " + a.naziv + ", " + a.cijena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if(naziv==""){
            throw new IllegalArgumentException("Naziv je prazan");
        }
        else{
            this.naziv = naziv;
        }
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        if(sifra==""){
            throw new IllegalArgumentException("Šifra je prazna");
        }
        else{
            this.sifra = sifra;
        }
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        if(cijena<=0){
            throw new IllegalArgumentException("Cijena je negativna");
        }
        else {
            this.cijena = cijena;
        }
    }


    public Artikal (String input){
        String[] artikal = input.split(",");
        sifra = artikal[0];
        naziv = artikal[1];
        cijena = Double.parseDouble(artikal[2]);
    }

    @Override
    public String toString() {
        return this.sifra + ", " + this.naziv + ", " + this.cijena;
    }

    public static ArrayList<Artikal> izbaciDuplikate (ArrayList<Artikal> artikli){
        for(int i = 0; i < artikli.size()-1; i++){
            for(int j = i+1; j < artikli.size(); j++){
                if(artikli.get(i).equals(artikli.get(j))){
                    artikli.remove(j);
                }
            }
        }
        return artikli;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Artikal)){
            return false;
        }

        Artikal artikal = (Artikal) o;

        return (artikal.sifra.equals(this.sifra) && artikal.naziv.equals(this.naziv) && artikal.cijena == this.cijena);
    }
}
