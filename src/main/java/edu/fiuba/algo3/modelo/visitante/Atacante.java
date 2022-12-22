package edu.fiuba.algo3.modelo.visitante;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Construccion;

public class Atacante implements VisitanteArea {

    private final int danioAereo;
    private final int danioTerrestre;


    public Atacante(int danioAereo, int danioTerrestre){
        this.danioAereo = danioAereo;
        this.danioTerrestre = danioTerrestre;
    }
    @Override
    public void visitarArea(AreaEspacial area, Construccion construccionAAtacar) {
        construccionAAtacar.recibirDanio(danioAereo);
    }

    @Override
    public void visitarArea(AreaTerrestre area, Construccion construccionAAtacar) {
        construccionAAtacar.recibirDanio(danioTerrestre);
    }
}
