package edu.fiuba.algo3.modelo.areas;
import edu.fiuba.algo3.modelo.visitante.VisitanteArea;
import edu.fiuba.algo3.modelo.construcciones.Construccion;

public interface Area {
    void aceptar(VisitanteArea visitante, Construccion construccionAAtacar);

}
