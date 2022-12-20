package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.visitante.Atacante;

public class Devorador extends UnidadZerg implements EstadoMutalisco {


    public Devorador(){
        super();
        this.danioAereo = 15;
        this.vidaMaxima = 200;
        this.vida = this.vidaMaxima;
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 5;
        this.recursosNecesarios.agregar(new Mineral(150));
        this.recursosNecesarios.agregar(new Gas(50));
        this.area = new AreaEspacial();
    }

    public void construir(Casillero casillero,ListadoDeRecursos recursos){
        this.recursosNecesarios.consumir(recursos);
        this.ubicacion = casillero;
    }
    public void atacar(ConstruccionProtoss construccionEnemiga){
        estado.jugar();
        Atacante ataque = new Atacante(this.danioAereo, this.danioTerrestre);
        Area areaConstruccion = construccionEnemiga.obtenerArea();
        areaConstruccion.aceptar(ataque, construccionEnemiga);
    }

    @Override
    public boolean enRangoDeAtaque(Casillero casillero) {
        return super.enRangoDeAtaque(casillero);
    }


}
