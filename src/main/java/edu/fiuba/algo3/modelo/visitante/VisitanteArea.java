package edu.fiuba.algo3.modelo.visitante;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Construccion;

public class VisitanteArea {

    private final int danioAereo;
    private final int danioTerrestre;

    public VisitanteArea(int danioAereo, int danioTerrestre){
        this.danioAereo = danioAereo;
        this.danioTerrestre = danioTerrestre;
    }
    public void visitarArea(AreaEspacial area, Construccion construccionAAtacar) {
        construccionAAtacar.recibirDanio(danioAereo);
    }
    public void visitarArea(AreaTerrestre area, Construccion construccionAAtacar) {
        construccionAAtacar.recibirDanio(danioTerrestre);
    }
}
