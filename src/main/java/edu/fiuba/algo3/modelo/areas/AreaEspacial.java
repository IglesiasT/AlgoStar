package edu.fiuba.algo3.modelo.areas;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.visitante.VisitanteArea;

public class AreaEspacial implements Area{
    @Override
    public void aceptar(VisitanteArea visitante, Construccion construccionAAtacar) {
        visitante.visitarArea(this, construccionAAtacar);
    }
}
