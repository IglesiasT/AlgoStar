package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.construcciones.unidades.*;
import edu.fiuba.algo3.modelo.mapa.Casillero;

import java.util.LinkedList;

public class Protoss extends Raza{
    private ListadoDeConstruccionesProtoss construccionesRealizadas;
    private LinkedList<UnidadProtoss> unidadesEngendradas;
    public Protoss(){
        super();
        this.construccionesRealizadas = new ListadoDeConstruccionesProtoss();
    }

    public Protoss(int mineralInicial, int gasInicial){
        super(mineralInicial, gasInicial);
        this.construccionesRealizadas = new ListadoDeConstruccionesProtoss();
    }

    public void nuevoTurno(){
        this.construccionesRealizadas.nuevoTurno(this.recursos);
        for (UnidadProtoss unidad : this.unidadesEngendradas) {    //delegar for en nueva clase ListadoUnidades
            unidad.nuevoTurno();
        }
    }

    private void construir(ConstruccionProtoss construccion, Casillero casilleroAConstruir){

        construccion.construir(casilleroAConstruir, this.recursos);
        this.construccionesRealizadas.agregar(construccion);
    }
    public void construirPilon(Casillero casilleroAConstruir){
        Pilon pilon = new Pilon();

        this.construir(pilon, casilleroAConstruir);
        this.maximoSuministro = this.maximoSuministro +5 ;
    }

    public void construirNexoMineral(Casillero casilleroAConstruir) {
        NexoMineral nexo = new NexoMineral();

        this.construir(nexo, casilleroAConstruir);
    }

    public void construirAsimilador(Casillero casilleroAConstruir) {
        this.construir(new Asimilador(), casilleroAConstruir);
    }

    public void construirAcceso(Casillero casilleroAConstruir){
        Acceso acceso = new Acceso();

        this.construir(acceso, casilleroAConstruir);
    }

    public void construirPuertoEstelar(Casillero casilleroAConstruir){
        if (! this.construccionesRealizadas.contiene(new Acceso())){
            throw new ConstruccionPreviaNoConstruida();
        }

        PuertoEstelar puertoEstelar = new PuertoEstelar();

        this.construir(puertoEstelar, casilleroAConstruir);
    }
    public Zealot construirZealot(Casillero casilleroAConstruir){
        if (! this.construccionesRealizadas.contiene(new Acceso())){
            throw new ConstruccionPreviaNoConstruida();
        }

        Zealot zealot = new Zealot();

        if ((suministro + zealot.consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }
        this.construir(zealot, casilleroAConstruir);
        this.suministro = zealot.consumirSuministro(this.suministro) ;

        return zealot;
    }

    public Dragon construirDragon(Casillero casilleroAConstruir){
        if (! this.construccionesRealizadas.contiene(new Acceso())){
            throw new ConstruccionPreviaNoConstruida();
        }

        Dragon dragon = new Dragon();

        if ((suministro + dragon.consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }

        this.construir(dragon, casilleroAConstruir);
        this.suministro = dragon.consumirSuministro(this.suministro) ;

        return dragon;
    }

    public Scout construirScout(Casillero casilleroAConstruir){
        if (! this.construccionesRealizadas.contiene(new PuertoEstelar())){
            throw new ConstruccionPreviaNoConstruida();
        }

        Scout scout = new Scout();

        if ((suministro + scout.consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }

        this.construir(scout, casilleroAConstruir);
        this.suministro = scout.consumirSuministro(this.suministro) ;

        return scout;
    }

    public int construcciones() {
        return construccionesRealizadas.size();
    }

    public void destruir (ConstruccionProtoss construccionADestruir) {
        this.maximoSuministro =
                this.construccionesRealizadas.destruir(construccionADestruir, this.maximoSuministro);
    }


}
