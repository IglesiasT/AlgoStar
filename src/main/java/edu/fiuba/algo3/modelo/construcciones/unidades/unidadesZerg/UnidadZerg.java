package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ConstruccionZerg;
import edu.fiuba.algo3.modelo.construcciones.unidades.ComportamientoUnidad;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.mapa.*;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;

public abstract class UnidadZerg extends ConstruccionZerg implements Unidad {
    protected int rangoDeAtaque;
    protected int suministro;
    protected int danioAereo;
    protected int danioTerrestre;
    protected ComportamientoUnidad comportamiento;

    public UnidadZerg() {
        super();
        this.rangoDeAtaque = 1;
        this.danioAereo = 0;
        this.danioTerrestre = 0;
        this.area = new AreaTerrestre();
        this.comportamiento = new ComportamientoUnidad(this.ubicacion, this.rangoDeAtaque , this , this.area);
    }
    public void atacar(ConstruccionProtoss construccionEnemiga) {
        this.estado.jugar();
        this.comportamiento.atacar(construccionEnemiga, this.danioAereo, this.danioTerrestre);
    }

    public void moverse(Casillero casillero) {
        this.ubicacion = this.comportamiento.moverse(casillero);
    }

    @Override
    public void construir(Casillero casilleroAConstruir, ListadoDeRecursos recursos) {
        try{
            this.ubicacion = this.comportamiento.construir(casilleroAConstruir, recursos, this.recursosNecesarios);
        }catch (Exception e){
            if (e.getClass() == RecursosInsuficientes.class)
                casilleroAConstruir.retirarUnidad(this);
            throw e;
        }

    }

    public int consumirSuministro(int suministroAConsumir) {
        return this.comportamiento.consumirSuministro(suministroAConsumir, this.suministro);
    }
}