package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.estados.ConstruccionFinalizada;
import edu.fiuba.algo3.modelo.estados.EnConstruccion;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

public abstract class Construccion {
    protected int turnosParaConstruirse;
    protected int vidaMaxima;
    protected int vida;
    protected ListadoDeRecursos recursosNecesarios;
    protected int turnos;
    protected Casillero ubicacion;
    protected Area area;
    protected Estado estado;

    public Construccion(){
        this.vidaMaxima = 100;
        this.vida = this.vidaMaxima;
        this.ubicacion = null;
        this.turnos = 0;
        this.area = new AreaTerrestre();
        this.recursosNecesarios = new ListadoDeRecursos();
        this.estado = new EnConstruccion();
    }

    public void construir(Casillero casilleroAConstruir, ListadoDeRecursos recursos){
        this.recursosNecesarios.consumir(recursos);
        casilleroAConstruir.establecerConstruccion(this);
        this.ubicacion = casilleroAConstruir;
    }
    public abstract void recibirDanio(int danioInflingido);
    protected abstract void regenerar();
    public int obtenerVida(){
        return this.vida;
    }
    public void nuevoTurno(Raza raza){
        this.turnos++;
        this.regenerar();

        if (turnos == this.turnosParaConstruirse){
            this.estado = new ConstruccionFinalizada();
        }
    }
    public void destruir(){
        ubicacion.destruirConstruccion();
    }
    public void establecerUbicacion(Casillero nuevaUbicacion){
        this.ubicacion = nuevaUbicacion;
    }
    public Casillero obtenerUbicacion(){
        return this.ubicacion;
    }
    public Area obtenerArea() {
        return this.area;
    }
    public abstract Class obtenerRazaMadre();
    public boolean activa(){ return turnos >= turnosParaConstruirse;}
    public void visitar(VisitanteConstruccion visitante , EspacioDeConstruccion espacio , Recurso recurso){
        recurso.visitar (visitante);
    }

}
