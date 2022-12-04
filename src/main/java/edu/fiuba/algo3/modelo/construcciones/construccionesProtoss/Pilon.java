package edu.fiuba.algo3.modelo.construcciones.construccionesProtoss;

import edu.fiuba.algo3.modelo.construcciones.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.SinEspacio;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.mapa.Casillero;

import java.util.ArrayList;

public class Pilon extends ConstruccionProtoss {
    ArrayList<? extends Casillero> casillerosEnergizados;
    private int radioAfectado;

    public Pilon(){
        super();
        this.turnosParaConstruirse = 5;
        this.radioAfectado = 3;
        this.casillerosEnergizados  = new ArrayList<>();
        this.escudo = new Escudo(300);
        this.vida = 300;
        this.recursosNecesarios.agregar(new Mineral(100));
    }

    public void energizar(){
        if (this.turnos < this.turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        for (Casillero casillero: this.casillerosEnergizados) {
            if (! casillero.contiene(new Moho())){
                casillero.setEspacioDeConstruccion(new RangoPilon());
            }
        }
    }
    public void construir(Casillero casilleroAConstruir, ListadoDeRecursos recursos){
        super.construir(casilleroAConstruir, recursos);
        this.casillerosEnergizados = this.ubicacion.obtenerCasilleros(this.radioAfectado);
    }

    public void destruir(){
        for (Casillero casillero: this.casillerosEnergizados) {
            if (! casillero.contiene(new Moho())){
                casillero.setEspacioDeConstruccion(new SinEspacio());
            }
        }
    }

    public void nuevoTurno(){
        super.nuevoTurno();
        if (this.turnos >= this.turnosParaConstruirse){
            this.energizar();
        }
    }

}
