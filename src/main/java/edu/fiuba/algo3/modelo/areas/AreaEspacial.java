package edu.fiuba.algo3.modelo.areas;

import edu.fiuba.algo3.modelo.Visitante;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import javafx.scene.paint.Color;

public class AreaEspacial extends Area{
    @Override
    public void aceptar(Visitante visitante, Construccion construccionAAtacar) {
        visitante.visitarArea(this, construccionAAtacar);
    }

    @Override
    public Color color() {
        return Color.BLUE;
    }
}
