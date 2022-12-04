package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Construccion;

public interface Visitante {
    void visitarArea(AreaEspacial area, Construccion construccionAAtacar);
    void visitarArea(AreaTerrestre area, Construccion construccionAAtacar);
}
