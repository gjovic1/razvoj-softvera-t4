package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Artikal {
    private String sifra, naziv;
    private double cijena;

    public Artikal(){}

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if(getNaziv()==""){
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
        if(getSifra()==""){
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
        if(getCijena()<=0){
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
        String sifra = this.sifra + "," + naziv + "," + cijena;
        return sifra;
    }

    public static ArrayList<Artikal> izbaciDuplikate (ArrayList<Artikal> artikli){
        for(int i = 0; i < artikli.size(); i++){
            for(int j = 0; j < artikli.size(); j++){
                if(artikli.get(i).equals(artikli.get(j))){
                    artikli.remove(j);
                }
            }
        }
        return artikli;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(!(o instanceof Artikal)){
            return false;
        }

        Artikal artikal = (Artikal) o;

        if(Double.compare(artikal.getCijena(), getCijena())!=0){
            return false;
        }
        if(getSifra() != null ? !getSifra().equals(artikal.getSifra()):artikal.getSifra() != null){
            return false;
        }
        return getNaziv() != null ? getNaziv().equals(artikal.getNaziv()) : artikal.getNaziv()==null;
    }
}
