package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {

    int edellinen;

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        try {
            edellinen = Integer.parseInt(tulos.getText());
            sovellus.miinus(Integer.parseInt(syote.getText()));
            syote.setText("");
            int laskunTulos = sovellus.tulos();
            tulos.setText("" + laskunTulos);

            if (laskunTulos == 0) {
                nollaa.disableProperty().set(true);
            } else {
                nollaa.disableProperty().set(false);
            }

            undo.disableProperty().set(false);
        } catch (Exception e) {
        }
    }

    @Override
    public void peru() {
        tulos.setText("" + edellinen);
        sovellus.edellinenTulos(edellinen);
        undo.disableProperty().set(true);
        if (edellinen == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
    }

}
