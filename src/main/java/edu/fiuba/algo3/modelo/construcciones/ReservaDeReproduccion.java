package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.construcciones.unidades.Zerling;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class ReservaDeReproduccion extends ConstruccionZerg {

    public ReservaDeReproduccion(){
        this.recursosNecesarios.agregar(new Mineral(150));
        this.turnosParaConstruirse = 12;
        this.vida = 1000;
        this.vidaMaxima = 1000;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new Moho()) && casillero.contiene(new SinRecurso()));
    }

    public void evolucionarAZerling(){
        if (turnos < this.turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        // recibir Larva y cambiar estado a Zerling
    }
}
