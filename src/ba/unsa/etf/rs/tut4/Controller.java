package ba.unsa.etf.rs.tut4;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;

public class Controller {
    public TextArea beforeIzbaciArea;
    public TextArea afterIzbaciArea;
    public Button btnIzbaci;

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
    }
}
