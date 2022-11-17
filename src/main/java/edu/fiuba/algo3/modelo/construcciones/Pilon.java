package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.SinEspacio;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.tablero.Casillero;

import java.util.ArrayList;

public class Pilon extends ConstruccionProtoss {
    ArrayList<? extends Casillero> casillerosEnergizados;
    private int radioAfectado;

    public Pilon(){
        super();
        this.turnosParaConstruirse = 5;
        this.radioAfectado = 3;
        this.casillerosEnergizados  = new ArrayList<>();
        this.escudo = 300;
        this.vida = 300;
        this.mineralNecesarioParaConstruir = 100;
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
    public void construirEnCasillero(Casillero casilleroAConstruir){
        super.construirEnCasillero(casilleroAConstruir);
        this.casillerosEnergizados = this.ubicacion.obtenerCasilleros(this.radioAfectado);
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (!casillero.contiene(new Moho()) && casillero.contiene(new SinRecurso()));
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

    public static class EdificioNoEstaOperativo extends RuntimeException{
    }
}
