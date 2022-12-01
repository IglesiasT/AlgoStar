package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.Mineral;

import java.util.ArrayList;

public class Zealot extends UnidadProtoss{
    Visibilidad estado;
    public Zealot(){

        super();
        this.danioPorSuperficie.put("Tierra", 8);
        this.estado = new Invisible(new Escudo(60), this.vida);

        //this.escudo = new Escudo(60);
        this.turnosParaConstruirse = 4;
        //this.rangoDeAtaque = 1;
        this.suministro = 2;
        this.recursosNecesarios.agregar(new Mineral(100));

    }

    @Override
    public void visibilizar(){
        estado = this.estado.hacerVisible();
    }

    public void invisibilizar(){
        estado = this.estado.hacerInvisible();
    }

    @Override
    public void recibirDanio(int danioInflingido){
        this.estado.recibirDanio(danioInflingido);
    }

    @Override
    public int obtenerEscudo(){
        return this.estado.obtenerEscudo();
    }
    @Override
    public int obtenerVida(){
        return this.estado.obtenerVida();
    }
}
