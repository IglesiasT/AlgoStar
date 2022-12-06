package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss;

import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.construcciones.unidades.visibilidad.Visibilidad;
import edu.fiuba.algo3.modelo.construcciones.unidades.visibilidad.Visible;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class Zealot extends UnidadProtoss {
    Visibilidad estado;
    public Zealot(){

        super();
        this.escudo = new Escudo(60);
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 1;
        this.suministro = 2;
        this.recursosNecesarios.agregar(new Mineral(100));
        this.estado = new Visible(this.escudo, this.vida);
    }

    @Override
    public void recibirDanio(int danioInflingido) {
        this.estado.recibirDanio(danioInflingido);
    }

    public void visibilizar(){
        estado = this.estado.hacerVisible();
    }

    public void invisibilizar(){
        estado = this.estado.hacerInvisible();
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
