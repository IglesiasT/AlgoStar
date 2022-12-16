package edu.fiuba.algo3.vista.contenedoresAcciones;

import edu.fiuba.algo3.modelo.mapa.Casillero;
import javafx.scene.layout.VBox;

public class ContenedorAtacar extends VBox implements ContenedorAccion {

    private Casillero casillero;
    public void setCasilleroElegido(Casillero casillero) {
        this.casillero = casillero;
    }
}
