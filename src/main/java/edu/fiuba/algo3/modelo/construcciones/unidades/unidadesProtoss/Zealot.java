package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss;

import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.construcciones.unidades.visibilidad.Invisible;
import edu.fiuba.algo3.modelo.construcciones.unidades.visibilidad.Visibilidad;
import edu.fiuba.algo3.modelo.construcciones.unidades.visibilidad.Visible;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.Mineral;

import java.util.ArrayList;

public class Zealot extends UnidadProtoss {
    Visibilidad estado;
    public Zealot(){

        super();
        this.danioTerrestre = 8;
        this.escudo = new Escudo(60);
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 1;
        this.suministro = 2;
        this.recursosNecesarios.agregar(new Mineral(100));
        this.estado = new Invisible();
    }

    @Override
    public void recibirDanio(int danioInflingido){
        ArrayList<? extends Casillero> radio = this.ubicacion.obtenerCasilleros(4);
        for (int i = 1; i < radio.size(); i++){
            if(radio.get(i).obtenerConstruccion().getClass() == AmoSupremo.class){
                estado = new Visible();
            }
        }
        if(this.estado.getClass() == Visible.class){
        }
    }
}
