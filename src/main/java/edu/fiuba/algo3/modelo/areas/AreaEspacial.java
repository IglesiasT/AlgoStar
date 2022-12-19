package edu.fiuba.algo3.modelo.areas;

import edu.fiuba.algo3.modelo.visitante.Visitante;
import edu.fiuba.algo3.modelo.construcciones.Construccion;

public class AreaEspacial implements Area{
    @Override
    public void aceptar(Visitante visitante, Construccion construccionAAtacar) {
        visitante.visitarArea(this, construccionAAtacar);
    }
}
