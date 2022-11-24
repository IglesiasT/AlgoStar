package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class AmoSupremo extends UnidadZerg{

    public AmoSupremo(){
        this.vida = 200;
        this.turnosParaConstruirse = 5;
        this.rangoDeAtaque = 0;
        this.recursosNecesarios.agregar(new Mineral(50));
        this.area = new AreaEspacial();
        this.suministro = 0;
    }

}
