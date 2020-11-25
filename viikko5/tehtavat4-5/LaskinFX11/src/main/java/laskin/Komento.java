
package laskin;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public abstract class Komento {
    
    TextField tulos;
    TextField syote;
    Sovelluslogiikka sovellus;
    Button nollaa;
    Button undo;
    
    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tulos = tuloskentta;
        this.syote = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }
    
    public abstract void suorita();
    
    public abstract void peru();
    
}
