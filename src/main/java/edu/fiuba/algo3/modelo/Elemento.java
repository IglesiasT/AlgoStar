package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import javafx.scene.paint.Color;

public interface Elemento {
    void aceptar(Visitante visitante, Construccion construccionAAtacar);

    Color color();
}
