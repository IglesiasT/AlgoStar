package edu.fiuba.algo3.modelo.construcciones.construccionesProtoss;

import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

import java.util.ArrayList;

public class Pilon extends ConstruccionProtoss {
    ArrayList<? extends Casillero> casillerosEnergizados;
    private final int radioAfectado;

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
        estado.jugar();
        for (Casillero casillero: this.casillerosEnergizados) {
            casillero.dentroDelRangoDelPilon();
        }
    }
    public void construir(Casillero casilleroAConstruir, ListadoDeRecursos recursos){
        super.construir(casilleroAConstruir, recursos);
        this.casillerosEnergizados = this.ubicacion.obtenerCasilleros(this.radioAfectado);
    }
    public void destruir(){
        for (Casillero casillero: this.casillerosEnergizados) {
            casillero.fueraDelRangoDelPilon();
        }
    }
    public void nuevoTurno(Raza raza){
        super.nuevoTurno(raza);
        try{this.energizar();}catch (RuntimeException EdificioNoEstaOperativo){};
    }

    public void visitar(VisitanteConstruccion visitante , EspacioDeConstruccion espacio , Recurso recurso){
        recurso.visitar (visitante);
    }
}
