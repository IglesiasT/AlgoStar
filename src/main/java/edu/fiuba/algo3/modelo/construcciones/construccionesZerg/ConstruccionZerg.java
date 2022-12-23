package edu.fiuba.algo3.modelo.construcciones.construccionesZerg;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

public abstract class ConstruccionZerg extends Construccion {

    public ConstruccionZerg(){
        super();
    }
    @Override
    public void recibirDanio(int danioInflingido) {
        try {
            estado.jugar();
            this.vida -= danioInflingido;

            if (this.vida <= 0) {
                this.destruir();
            }
        }catch (Exception e){}
    }
    @Override
    protected void regenerar() {
        if (this.vida < this.vidaMaxima){
            this.vida += 5;
        }
    }
    @Override
    public Class obtenerRazaMadre() {
        return Zerg.class;
    }
    public void visitar(VisitanteConstruccion visitante , EspacioDeConstruccion espacio , Recurso recurso){
        super.visitar(visitante , espacio , recurso);
        visitante.construir(this, espacio);
    }
}
