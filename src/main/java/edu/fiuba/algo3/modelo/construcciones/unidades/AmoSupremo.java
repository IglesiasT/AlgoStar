package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;

import java.util.ArrayList;

public class AmoSupremo extends UnidadZerg{

    protected int radioDeteccion;

    public AmoSupremo(){
        this.vida = 200;
        this.turnosParaConstruirse = 5;
        this.rangoDeAtaque = 0;
        this.recursosNecesarios.agregar(new Mineral(50));
        this.area = new AreaEspacial();
        this.suministro = 0;
        this.radioDeteccion = 4;
    }

    public void visibilizarDetectados(){
        ArrayList<? extends Casillero> radio = this.ubicacion.obtenerCasilleros(this.radioDeteccion);
        for (int i = 1; i < radio.size(); i++){
            radio.get(i).obtenerUnidad().visibilizar();
        }
    }

    @Override
    public void nuevoTurno(){
        super.nuevoTurno();
        visibilizarDetectados();
    }
}
