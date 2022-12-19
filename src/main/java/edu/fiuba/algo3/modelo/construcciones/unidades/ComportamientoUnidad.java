package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.visitante.Atacante;
import edu.fiuba.algo3.modelo.visitante.NoSePuedeMover;
import edu.fiuba.algo3.modelo.visitante.ObjetivoFueraDeRango;

public class ComportamientoUnidad {

    private Unidad unidad;
    private Casillero ubicacion;
    private int rangoDeAtaque;
    private Area area;

    public ComportamientoUnidad(Casillero ubicacion , int rangoDeAtaque , Unidad unidad , Area area) {
        this.ubicacion = ubicacion;
        this.rangoDeAtaque = rangoDeAtaque;
        this.unidad = unidad ;
        this.area = area;
    }

    public Casillero construir(Casillero casilleroAConstruir, ListadoDeRecursos recursosAConsumir , ListadoDeRecursos recursosNecesarios){
        Casillero nuevaUbicacion;
        nuevaUbicacion = moverse(casilleroAConstruir);
        recursosNecesarios.consumir(recursosAConsumir);
        return nuevaUbicacion;
    }
    public void enRangoDeAtaque(Casillero ubicacionAtacado){
        if (!((ubicacionAtacado.obtenerFila() <= this.ubicacion.obtenerFila()+this.rangoDeAtaque &&
                ubicacionAtacado.obtenerFila() >= this.ubicacion.obtenerFila()-this.rangoDeAtaque)
                &&
                (ubicacionAtacado.obtenerColumna() <= this.ubicacion.obtenerColumna()+this.rangoDeAtaque) &&
                ubicacionAtacado.obtenerColumna() >= this.ubicacion.obtenerColumna()-this.rangoDeAtaque)) {

            throw new ObjetivoFueraDeRango();
        }

    }

    public void atacar(Construccion construccionEnemiga , int danioAereo , int danioTerrestre){
        enRangoDeAtaque(construccionEnemiga.obtenerUbicacion());
        Atacante ataque = new Atacante(danioAereo, danioTerrestre);
        Area areaConstruccion = construccionEnemiga.obtenerArea();
        areaConstruccion.aceptar(ataque, construccionEnemiga);
    }

    public Casillero moverse(Casillero casillero) {

        Casillero aux = casillero.Mover(casillero ,this.area);

        if (aux == null) {
            throw new NoSePuedeMover();
        }

        if(this.ubicacion != null) {
            this.ubicacion.retirarUnidad(this.unidad);
        }
        casillero.ubicarUnidad(this.unidad);
        this.ubicacion = casillero;
        this.area = casillero.obtenerArea();

        return this.ubicacion;
    }

    public int consumirSuministro(int suministroAConsumir , int suministro){
        return suministroAConsumir + suministro;
    }
}
