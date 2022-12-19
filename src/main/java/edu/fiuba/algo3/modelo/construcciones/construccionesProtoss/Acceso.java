package edu.fiuba.algo3.modelo.construcciones.construccionesProtoss;

import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Acceso extends ConstruccionProtoss {

    public Acceso(){
        this.recursosNecesarios.agregar(new Mineral(150));
        this.turnosParaConstruirse = 8;
        this.escudo = new Escudo(500);
        this.vida = 500;
    }

    @Override
    public void construir(Casillero casilleroAConstruir, ListadoDeRecursos recursos){
        if (! casilleroAConstruir.contiene(new RangoPilon())){  // Sacar if usando patron State
            throw new FueraDeRangoDePilon();
        }
        super.construir(casilleroAConstruir, recursos);
    }
}
