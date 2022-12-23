package edu.fiuba.algo3.modelo.construcciones.construccionesProtoss;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

public abstract class ConstruccionProtoss extends Construccion {
    protected Escudo escudo;

    public ConstruccionProtoss(){
        super();
        this.escudo = new Escudo(100);
    }
    public int obtenerEscudo(){
        return this.escudo.obtenerVida();
    }
    @Override
    public void recibirDanio(int danioInflingido) {
        try {
            estado.jugar();
            this.vida -= this.escudo.recibirDanio(danioInflingido);

            if (this.vida <= 0) {
                this.destruir();
            }
        }catch (Exception e){}
    }
    @Override
    protected void regenerar() {
        this.escudo.regenerar();
    }
    public Class obtenerRazaMadre(){ return Protoss.class;}
    public void visitar(VisitanteConstruccion visitante , EspacioDeConstruccion espacio , Recurso recurso){
        super.visitar(visitante , espacio , recurso);
        visitante.construir(this, espacio);
    }
}
