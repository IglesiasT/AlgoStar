package edu.fiuba.algo3.modelo.visitante;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Construccion;

public interface VisitanteArea {
    void visitarArea(AreaEspacial area, Construccion construccionAAtacar);
    void visitarArea(AreaTerrestre area, Construccion construccionAAtacar);
}
