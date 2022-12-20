package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.visitante.Atacante;

public class Guardian extends UnidadZerg implements EstadoMutalisco {

    public Guardian(){
        this.danioTerrestre = 25;
        this.vida = 100;
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 10;
        this.recursosNecesarios.agregar(new Mineral(50));
        this.recursosNecesarios.agregar(new Gas(100));
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
