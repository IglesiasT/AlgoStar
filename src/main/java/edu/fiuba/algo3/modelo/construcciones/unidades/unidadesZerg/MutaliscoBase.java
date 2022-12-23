package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.unidades.ComportamientoUnidad;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.visitante.Atacante;
import edu.fiuba.algo3.modelo.visitante.NoSePuedeMover;
import edu.fiuba.algo3.modelo.visitante.ObjetivoFueraDeRango;

public class MutaliscoBase extends UnidadZerg {

    EstadoMutalisco estadoMutalisco;


    public MutaliscoBase(){
        this.estadoMutalisco = new Mutalisco();
    }
    public void evolucionarAGuardian(ListadoDeRecursos recursosDisponibles){
        Guardian guardian = new Guardian();
        guardian.construir(this.ubicacion,recursosDisponibles);
        this.estadoMutalisco = guardian;

    }
    public void evolucionarADevorador(ListadoDeRecursos recursosDisponibles){
        Devorador devorador = new Devorador();
        devorador.construir(this.ubicacion,recursosDisponibles);
        this.estadoMutalisco = devorador;

    }
    public void atacar(ConstruccionProtoss construccionEnemiga){
        estadoMutalisco.atacar(construccionEnemiga);
    }
    @Override
    public int consumirSuministro(int suministroAConsumir){
        return this.estadoMutalisco.consumirSuministro(suministroAConsumir);
    }
    @Override
    public void recibirDanio(int danioInflingido){
        this.estadoMutalisco.recibirDanio(danioInflingido);
    }
     @Override
    public Area obtenerArea() {
        return this.estadoMutalisco.obtenerArea();
    }
    @Override
    public int obtenerVida(){
        return this.estadoMutalisco.obtenerVida();
    }

    @Override
    public void nuevoTurno(Raza raza) {
        this.estadoMutalisco.nuevoTurno(raza);
    }
    @Override
    public boolean activa(){
        return estadoMutalisco.activa();
    }
    public void moverse(Casillero casillero) {
        this.estadoMutalisco.moverse(casillero);
        casillero.ubicarUnidad(this);
        casillero.retirarUnidad((Unidad)this.estadoMutalisco);
        this.ubicacion = casillero;
    }
    @Override
    public void construir(Casillero casilleroAConstruir, ListadoDeRecursos recursos){
        moverse(casilleroAConstruir);
        this.estadoMutalisco.construir(casilleroAConstruir,recursos);
    }

    public String obtenerEstado(){

        String[] estadoString = (estadoMutalisco.getClass().toString().split("\\."));
        return estadoString[estadoString.length - 1];
    };
    @Override
    protected void enRangoDeAtaque(Casillero ubicacion){
        estadoMutalisco.enRangoDeAtaque(ubicacion);
    }
}
