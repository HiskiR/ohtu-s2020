package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    int edellinen;
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        edellinen = Integer.parseInt(tulos.getText());
        sovellus.nollaa();
        int laskunTulos = sovellus.tulos();
        syote.setText("");
        tulos.setText("" + laskunTulos);
        nollaa.disableProperty().set(true);
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        tulos.setText("" + edellinen);
        sovellus.edellinenTulos(edellinen);
        undo.disableProperty().set(true);
        if (edellinen != 0) {
            nollaa.disableProperty().set(false);
        }
    }

}
