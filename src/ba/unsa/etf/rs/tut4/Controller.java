package ba.unsa.etf.rs.tut4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;

public class Controller {
    public TextArea beforeIzbaciArea;
    public TextArea afterIzbaciArea;
    public Button btnIzbaci;

    public ChoiceBox<Artikal> choiceArts;
    public Spinner spinnerKol;
    public TextArea konacnoArea;

    private Racun racun;
    private ArrayList<Artikal> finalni;
    private ObservableList<Artikal> list = FXCollections.observableArrayList();

    public void izbaciAction(ActionEvent actionEvent) {
        String arts = beforeIzbaciArea.getText();
        String[] artikli = arts.split("\n");
        ArrayList<Artikal> smece = new ArrayList<>();

        for(String el : artikli){
            smece.add(new Artikal(el));
        }
        smece = Artikal.izbaciDuplikate(smece);

        String res = "";
        for(Artikal el : smece){
            res += el + "\n";
        }

        afterIzbaciArea.setText(res);

        racun = new Racun();
        finalni = new ArrayList<>(smece);
        list.addAll(finalni);
        choiceArts.setItems(list);
    }


    public void dodajStavke(ActionEvent actionEvent) {
        racun.dodajStavku(choiceArts.getSelectionModel().getSelectedItem(), (Integer) spinnerKol.getValue());;
        konacnoArea.setText(racun.toString());
    }
}
