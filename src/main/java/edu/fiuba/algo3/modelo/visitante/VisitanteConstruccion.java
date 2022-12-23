package edu.fiuba.algo3.modelo.visitante;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.construcciones.ProductorDeGas;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.FueraDeRangoDePilon;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ConstruccionZerg;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.mapa.CasilleroSinGas;
import edu.fiuba.algo3.modelo.mapa.CasilleroSinMineral;
import edu.fiuba.algo3.modelo.mapa.CasilleroSinMoho;
import edu.fiuba.algo3.modelo.recursos.Nodo;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.recursos.Volcan;

public class VisitanteConstruccion {
/*
    public void construir(Criadero criadero , EspacioDeConstruccion espacio , Recurso recurso) {}

    public void construir(ConstruccionZerg contruccion , EspacioDeConstruccion espacio , Recurso recurso) {
        if (espacio.getClass() != Moho.class && !(contruccion instanceof Criadero)) {
            throw new CasilleroSinMoho();
        }
    }

    public void construir(ProductorDeGas construccion , EspacioDeConstruccion espacio , Recurso recurso) {
        if(recurso.getClass()!=Volcan .class){
            throw new CasilleroSinGas();
        }
    }

    public void construir(Construccion construccion , EspacioDeConstruccion espacio , Volcan recurso) {
        throw new NoSePuedeConstruir();
    }

    public void construir(NexoMineral construccion , EspacioDeConstruccion espacio , Recurso recurso) {
        if (recurso.getClass() != Nodo.class){
            throw new CasilleroSinMineral();
        }
    }

    public void construir(Construccion construccion , EspacioDeConstruccion espacio , Nodo recurso) {
        throw new NoSePuedeConstruir();
    }
 */

    public void construir(Criadero criadero) {}

    public void construir(ConstruccionZerg contruccion , EspacioDeConstruccion espacio ) {
        if (espacio.getClass() != Moho.class) {
            throw new CasilleroSinMoho();
        }
    }

    public void construir(ConstruccionProtoss contruccion , EspacioDeConstruccion espacio ) {
        if (espacio.getClass() != RangoPilon.class) {
            throw new FueraDeRangoDePilon();
        }
    }

    public void construir(ProductorDeGas construccion , Recurso recurso) {
        if(recurso.getClass()!=Volcan .class){
            throw new CasilleroSinGas();
        }
    }

    public void construir(Volcan recurso) {
        throw new NoSePuedeConstruir();
    }

    public void construir(NexoMineral construccion , Recurso recurso) {
        if (recurso.getClass() != Nodo.class){
            throw new CasilleroSinMineral();
        }
    }

    public void construir(Nodo recurso) {
        throw new NoSePuedeConstruir();
    }
}
