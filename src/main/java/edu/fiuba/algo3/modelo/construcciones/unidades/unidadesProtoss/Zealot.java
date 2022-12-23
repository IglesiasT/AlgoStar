package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss;

import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.construcciones.unidades.ComportamientoUnidad;
import edu.fiuba.algo3.modelo.construcciones.unidades.visibilidad.Visibilidad;
import edu.fiuba.algo3.modelo.construcciones.unidades.visibilidad.Visible;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class Zealot extends UnidadProtoss {
    Visibilidad visibilidad;
    public Zealot(){

        super();
        this.escudo = new Escudo(60);
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 1;
        this.suministro = 2;
        this.recursosNecesarios.agregar(new Mineral(100));
        this.visibilidad = new Visible(this.escudo, this.vida);
        this.danioTerrestre = 8;
        this.comportamiento = new ComportamientoUnidad(this.ubicacion , this.rangoDeAtaque , this , this.area);
    }
    @Override
    public void recibirDanio(int danioInflingido) {
        try {
            estado.jugar();
            this.visibilidad.recibirDanio(danioInflingido);
        }catch (Exception e){}
    }
    public void visibilizar(){
        visibilidad = this.visibilidad.hacerVisible();
    }
    public void invisibilizar(){
        visibilidad = this.visibilidad.hacerInvisible();
    }
    @Override
    public int obtenerEscudo(){
        return this.visibilidad.obtenerEscudo();
    }
    @Override
    public int obtenerVida(){
        return this.visibilidad.obtenerVida();
    }
}
