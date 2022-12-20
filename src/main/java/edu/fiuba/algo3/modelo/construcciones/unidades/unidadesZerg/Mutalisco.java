package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.visitante.Atacante;
import edu.fiuba.algo3.modelo.visitante.ObjetivoFueraDeRango;
public class Mutalisco extends UnidadZerg implements EstadoMutalisco {
    public Mutalisco(){
        super();
        this.danioAereo = 9;
        this.danioTerrestre = 9;
        this.vidaMaxima = 120;
        this.vida = this.vidaMaxima;
        this.recursosNecesarios.agregar(new Mineral(100));
        this.recursosNecesarios.agregar(new Gas(100));
        this.turnosParaConstruirse = 7;
        this.rangoDeAtaque = 3;
        this.suministro = 4;
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
