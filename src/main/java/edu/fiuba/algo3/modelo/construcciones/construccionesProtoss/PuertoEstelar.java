package edu.fiuba.algo3.modelo.construcciones.construccionesProtoss;

import edu.fiuba.algo3.modelo.construcciones.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.FueraDeRangoDePilon;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class PuertoEstelar extends ConstruccionProtoss {
    public PuertoEstelar(){
        this.recursosNecesarios.agregar(new Mineral(150));
        this.recursosNecesarios.agregar(new Gas(150));
        this.turnosParaConstruirse = 10;
        this.escudo = new Escudo(600);
        this.vida = 600;
    }

    public void transportarTropas() {
        if (turnos < this.turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        // recibir coleccion de unidades protoss y cambiar ubicacion de todas
    }

    @Override
    public void construir(Casillero casilleroAConstruir, ListadoDeRecursos recursos){
        if (! casilleroAConstruir.contiene(new RangoPilon())){  // Sacar if usando patron State
            throw new FueraDeRangoDePilon();
        }
        super.construir(casilleroAConstruir, recursos);
    }
}
